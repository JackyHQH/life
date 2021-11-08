import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class dsd {
    public static void main(String[] args) throws IOException {
        String str = "[{\"name\":\"poHeaderId\",\"type\":\"string\",\"value\":\"6543306812\"},{\"name\":\"tenantId\",\"type\":\"string\",\"value\":\"9875\"},{\"name\":\"amount\",\"type\":\"double\",\"value\":\"27000000\"},{\"name\":\"statusCode\",\"type\":\"string\",\"value\":\"PENDING\"},{\"name\":\"displayPoNum\",\"type\":\"string\",\"value\":\"PO20210920000001\"},{\"name\":\"poTypeCode\",\"type\":\"string\",\"value\":\"A102\"},{\"name\":\"poTypeName\",\"type\":\"string\",\"value\":\"代销采购订单\"},{\"name\":\"supplierCode\",\"type\":\"string\",\"value\":\"10062\"},{\"name\":\"supplierName\",\"type\":\"string\",\"value\":\"盐城优简服饰有限公司\"},{\"name\":\"companyCode\",\"type\":\"string\",\"value\":\"CO00010554\"},{\"name\":\"companyName\",\"type\":\"string\",\"value\":\"好孩子好妈咪零售有限公司\"},{\"name\":\"taxIncludeAmount\",\"type\":\"double\",\"value\":\"30510000\"},{\"name\":\"agentCode\",\"type\":\"string\",\"value\":\"201\"},{\"name\":\"agentName\",\"type\":\"string\",\"value\":\"MC-服饰采购组\"},{\"name\":\"poSourcePlatform\",\"type\":\"string\",\"value\":\"SRM\"},{\"name\":\"employeeNumber\",\"type\":\"string\",\"value\":\"GB000967\"},{\"name\":\"purchaseOrgId\",\"type\":\"string\",\"value\":\"1467\"},{\"name\":\"purchaseOrgCode\",\"type\":\"string\",\"value\":\"2000\"},{\"name\":\"attributeVarchar1\",\"type\":\"string\",\"value\":\"2\"},{\"name\":\"attributeVarchar3\",\"type\":\"string\",\"value\":\"月结45天\"},{\"name\":\"attributeBigint1\",\"type\":\"string\",\"value\":\"91908974015221080\"},{\"name\":\"attributeBigint2\",\"type\":\"string\",\"value\":\"923\"},{\"name\":\"domesticAmount\",\"type\":\"double\",\"value\":\"27000000\"},{\"name\":\"domesticTaxIncludeAmount\",\"type\":\"double\",\"value\":\"30510000\"},{\"name\":\"poHeaderCreatedBy\",\"type\":\"string\",\"value\":\"134718\"},{\"name\":\"purchaseOrgCode\",\"value\":\"1110\",\"type\":\"string\"},{\"name\":\"purchaseOrgId\",\"value\":1474,\"type\":\"string\"}]\n";
        ObjectMapper objectMapper = new ObjectMapper();
        List<RestVariable> list = objectMapper.readValue(str, new TypeReference<List<RestVariable>>(){});
        list.remove(16);
        list.remove(16);
        int i = 0;
        for (RestVariable l:list) {
            System.out.println(i+++"--"+l.getName()+"--"+l.getValue());
        }

        list.stream()
                .filter(variable -> variable != null && variable.getValue() != null && StringUtils.isNotEmpty(variable.getName()))
                .collect(Collectors.toMap(RestVariable::getName, RestVariable::getValue));
        System.out.println(list);

    }
}
