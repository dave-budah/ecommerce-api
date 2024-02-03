package com.selvigtech.blog.api.model;

public class DataChange<T> {
    private  ChangeType changeType;
    private T data;

    public DataChange() {

    }

    public DataChange(ChangeType changeType, T data) {
        this.changeType = changeType;
        this.data = data;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum ChangeType {
        INSERT,
        UPDATE,
        DELETE
    }
}
