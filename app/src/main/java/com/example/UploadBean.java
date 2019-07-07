package com.example;

/**
 * Author:紫楼主
 * Date:2019/7/7
 */
public class UploadBean {
    private String status;
    private String message;
    private String headPath;

    public UploadBean() {
    }

    public UploadBean(String status, String message, String headPath) {
        this.status = status;
        this.message = message;
        this.headPath = headPath;
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

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    @Override
    public String toString() {
        return "UploadBean{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", headPath='" + headPath + '\'' +
                '}';
    }
}
