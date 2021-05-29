package com.poalim.microusers.viewmodel;

import java.io.Serializable;

public class VmDeleteResult implements Serializable {

    private Boolean isDeleted;
    private String reason;

    public VmDeleteResult(Boolean isDeleted, String reason) {
        this.isDeleted = isDeleted;
        this.reason = reason;
    }

    public VmDeleteResult() {
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "VmDeleteResult{" +
                "isDeleted=" + isDeleted +
                ", reason='" + reason + '\'' +
                '}';
    }
}
