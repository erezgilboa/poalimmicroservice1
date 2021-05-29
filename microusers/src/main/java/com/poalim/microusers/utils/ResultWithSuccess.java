package com.poalim.microusers.utils;

public class ResultWithSuccess<T> {

    private T result = null;
    private boolean success = false;

    public ResultWithSuccess(boolean success) {
        this.success = success;
    }

    public ResultWithSuccess(boolean success, T value) {
        this.success = success;
        this.result = value;
    }

    public ResultWithSuccess() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T value) {
        this.result = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResultWithSuccess{" +
                "result=" + result +
                ", success=" + success +
                '}';
    }
}
