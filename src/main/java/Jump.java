import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.aop.framework.ProxyConfig;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

/**
 * @author kzcming
 * @since 2020/11/19 15:51
 */

public class Test {

    public static void main(String[] args) throws Exception {
        test("https://www.instagram.com/accounts/login/");
    }


    public static void test(String url) throws Exception{
        // ConnectionSocketFactory注册
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new MyConnectionSocketFactory())
                .register("https",new MySSLConnectionSocketFactory()).build();
        // HTTP客户端连接管理池
        BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(reg);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRetryHandler((exception, executionCount, context) -> false)
                .setConnectionManager(connManager)
                .build();
        try {
            // socks代理地址 , socks 地址和端口,这里随便写了一个1008
            InetSocketAddress socksaddr = InetSocketAddress.createUnresolved("10.213.20.73", 7890);
            HttpClientContext context = HttpClientContext.create();
            context.setAttribute("socks.address", socksaddr);

            // 请求目标
            HttpGet request = new HttpGet(url);
            System.out.println("----------------------------------------");
            System.out.println("执行请求 ：" + request.getRequestLine());
            System.out.println("通过代理： " + socksaddr);
            System.out.println("----------------------------------------");

            CloseableHttpResponse response = httpclient.execute(request, context);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println("返回响应：" + response.getStatusLine());
                System.out.println("响应内容：" + EntityUtils.toString(entity));
                System.out.println("----------------------------------------");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }


    /**
     * 实现 http 链接的socket 工厂
     */
    static class MyConnectionSocketFactory extends PlainConnectionSocketFactory {
        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            // socket代理
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
            return new Socket(proxy);
        }
    }


    /**
     * 实现 https 链接的socket 工厂
     */
    static class MySSLConnectionSocketFactory extends SSLConnectionSocketFactory {
        public MySSLConnectionSocketFactory() {
            super(SSLContexts.createDefault(), getDefaultHostnameVerifier());
        }


        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
//      // socket代理
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
            return new Socket(proxy);
        }


        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            remoteAddress = InetSocketAddress.createUnresolved(host.getHostName(), host.getPort());
            return super.connectSocket(connectTimeout, socket, host, remoteAddress, localAddress, context);
        }

    }


}
