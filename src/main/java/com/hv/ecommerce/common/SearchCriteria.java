package com.hv.ecommerce.common;

public class SearchCriteria {
    private String column;
    private String operation;
    private Object value;

    public SearchCriteria(String column, String operation, String value) {
        this.column = column;
        this.operation = operation;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public String getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }
}
