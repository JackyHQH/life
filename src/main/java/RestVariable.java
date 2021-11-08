//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class RestVariable {
    private String name;
    private String type;
    private RestVariable.RestVariableScope variableScope;
    private Object value;
    private String valueUrl;

    public RestVariable() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(
            include = Inclusion.NON_NULL
    )
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public RestVariable.RestVariableScope getVariableScope() {
        return this.variableScope;
    }

    public void setVariableScope(RestVariable.RestVariableScope variableScope) {
        this.variableScope = variableScope;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getScope() {
        String scope = null;
        if (this.variableScope != null) {
            scope = this.variableScope.name().toLowerCase();
        }

        return scope;
    }


    public void setValueUrl(String valueUrl) {
        this.valueUrl = valueUrl;
    }

    @JsonSerialize(
            include = Inclusion.NON_NULL
    )
    public String getValueUrl() {
        return this.valueUrl;
    }


    public static enum RestVariableScope {
        LOCAL,
        GLOBAL;

        private RestVariableScope() {
        }
    }
}
