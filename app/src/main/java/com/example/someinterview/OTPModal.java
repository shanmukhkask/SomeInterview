package com.example.someinterview;

import com.google.gson.annotations.SerializedName;

public class OTPModal {

    @SerializedName("phone")
    public String phone;

    @SerializedName("value")
    public String value;

    @SerializedName("status")
    public String status;

    @SerializedName("message")
    public String message;

    public OTPModal(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
