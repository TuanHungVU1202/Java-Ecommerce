package com.hv.ecommerce.common;

public class DynamicObj<T extends Object> {
    T object;

    public T getEntity(Object e) {
        return object;
    }

    public void setEntity(T e) {
        this.object = e;
    }
}
