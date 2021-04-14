//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public JSONObject(Map<String, Object> map) {
        this.map = map;
    }

    public JSONObject(boolean ordered) {
        this(16, ordered);
    }

    public JSONObject(int initialCapacity) {
        this(initialCapacity, false);
    }

    public JSONObject(int initialCapacity, boolean ordered) {
        if (ordered) {
            this.map = new LinkedHashMap(initialCapacity);
        } else {
            this.map = new HashMap(initialCapacity);
        }

    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return this.map.get(key);
    }

    public JSONObject getJSONObject(String key) {
        Object value = this.map.get(key);
        if (value instanceof JSONObject) {
            return (JSONObject)value;
        } else {
            return value instanceof String ? JSON.parseObject((String)value) : (JSONObject)toJSON(value);
        }
    }

    public JSONArray getJSONArray(String key) {
        Object value = this.map.get(key);
        if (value instanceof JSONArray) {
            return (JSONArray)value;
        } else {
            return value instanceof String ? (JSONArray)JSON.parse((String)value) : (JSONArray)toJSON(value);
        }
    }

    public <T> T getObject(String key, Class<T> clazz) {
        Object obj = this.map.get(key);
        return TypeUtils.castToJavaBean(obj, clazz);
    }

    public Boolean getBoolean(String key) {
        Object value = this.get(key);
        return value == null ? null : TypeUtils.castToBoolean(value);
    }

    public byte[] getBytes(String key) {
        Object value = this.get(key);
        return value == null ? null : TypeUtils.castToBytes(value);
    }

    public boolean getBooleanValue(String key) {
        Object value = this.get(key);
        return value == null ? false : TypeUtils.castToBoolean(value);
    }

    public Byte getByte(String key) {
        Object value = this.get(key);
        return TypeUtils.castToByte(value);
    }

    public byte getByteValue(String key) {
        Object value = this.get(key);
        return value == null ? 0 : TypeUtils.castToByte(value);
    }

    public Short getShort(String key) {
        Object value = this.get(key);
        return TypeUtils.castToShort(value);
    }

    public short getShortValue(String key) {
        Object value = this.get(key);
        return value == null ? 0 : TypeUtils.castToShort(value);
    }

    public Integer getInteger(String key) {
        Object value = this.get(key);
        return TypeUtils.castToInt(value);
    }

    public int getIntValue(String key) {
        Object value = this.get(key);
        return value == null ? 0 : TypeUtils.castToInt(value);
    }

    public Long getLong(String key) {
        Object value = this.get(key);
        return TypeUtils.castToLong(value);
    }

    public long getLongValue(String key) {
        Object value = this.get(key);
        return value == null ? 0L : TypeUtils.castToLong(value);
    }

    public Float getFloat(String key) {
        Object value = this.get(key);
        return TypeUtils.castToFloat(value);
    }

    public float getFloatValue(String key) {
        Object value = this.get(key);
        return value == null ? 0.0F : TypeUtils.castToFloat(value);
    }

    public Double getDouble(String key) {
        Object value = this.get(key);
        return TypeUtils.castToDouble(value);
    }

    public double getDoubleValue(String key) {
        Object value = this.get(key);
        return value == null ? 0.0D : TypeUtils.castToDouble(value);
    }

    public BigDecimal getBigDecimal(String key) {
        Object value = this.get(key);
        return TypeUtils.castToBigDecimal(value);
    }

    public BigInteger getBigInteger(String key) {
        Object value = this.get(key);
        return TypeUtils.castToBigInteger(value);
    }

    public String getString(String key) {
        Object value = this.get(key);
        return value == null ? null : value.toString();
    }

    public Date getDate(String key) {
        Object value = this.get(key);
        return TypeUtils.castToDate(value);
    }

    public java.sql.Date getSqlDate(String key) {
        Object value = this.get(key);
        return TypeUtils.castToSqlDate(value);
    }

    public Timestamp getTimestamp(String key) {
        Object value = this.get(key);
        return TypeUtils.castToTimestamp(value);
    }

    @Override
    public Object put(String key, Object value) {
        return this.map.put(key, value);
    }

    public JSONObject fluentPut(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        this.map.putAll(m);
    }

    public JSONObject fluentPutAll(Map<? extends String, ? extends Object> m) {
        this.map.putAll(m);
        return this;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    @Override
    public Object remove(Object key) {
        return this.map.remove(key);
    }

    public JSONObject fluentRemove(Object key) {
        this.map.remove(key);
        return this;
    }

    @Override
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return this.map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override
    public Object clone() {
        return new JSONObject((Map)(this.map instanceof LinkedHashMap ? new LinkedHashMap(this.map) : new HashMap(this.map)));
    }

    @Override
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class returnType;
        String name;
        JSONField annotation;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return this.equals(args[0]);
            } else {
                returnType = method.getReturnType();
                if (returnType != Void.TYPE) {
                    throw new JSONException("illegal setter");
                } else {
                    name = null;
                    annotation = (JSONField)method.getAnnotation(JSONField.class);
                    if (annotation != null && annotation.name().length() != 0) {
                        name = annotation.name();
                    }

                    if (name == null) {
                        name = method.getName();
                        if (!name.startsWith("set")) {
                            throw new JSONException("illegal setter");
                        }

                        name = name.substring(3);
                        if (name.length() == 0) {
                            throw new JSONException("illegal setter");
                        }

                        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                    }

                    this.map.put(name, args[0]);
                    return null;
                }
            }
        } else if (parameterTypes.length == 0) {
            returnType = method.getReturnType();
            if (returnType == Void.TYPE) {
                throw new JSONException("illegal getter");
            } else {
                name = null;
                annotation = (JSONField)method.getAnnotation(JSONField.class);
                if (annotation != null && annotation.name().length() != 0) {
                    name = annotation.name();
                }

                if (name == null) {
                    name = method.getName();
                    if (name.startsWith("get")) {
                        name = name.substring(3);
                        if (name.length() == 0) {
                            throw new JSONException("illegal getter");
                        }

                        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                    } else {
                        if (!name.startsWith("is")) {
                            if (name.startsWith("hashCode")) {
                                return this.hashCode();
                            }

                            if (name.startsWith("toString")) {
                                return this.toString();
                            }

                            throw new JSONException("illegal getter");
                        }

                        name = name.substring(2);
                        if (name.length() == 0) {
                            throw new JSONException("illegal getter");
                        }

                        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                    }
                }

                Object value = this.map.get(name);
                return TypeUtils.cast(value, method.getGenericReturnType(), ParserConfig.getGlobalInstance());
            }
        } else {
            throw new UnsupportedOperationException(method.toGenericString());
        }
    }
}
