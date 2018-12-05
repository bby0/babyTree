package com.qfedu.babytree.pojo;

public class Feedback {
    private Integer feeId;

    private Integer feeUserId;

    private String feeLink;

    private String feeContent;

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public Integer getFeeUserId() {
        return feeUserId;
    }

    public void setFeeUserId(Integer feeUserId) {
        this.feeUserId = feeUserId;
    }

    public String getFeeLink() {
        return feeLink;
    }

    public void setFeeLink(String feeLink) {
        this.feeLink = feeLink == null ? null : feeLink.trim();
    }

    public String getFeeContent() {
        return feeContent;
    }

    public void setFeeContent(String feeContent) {
        this.feeContent = feeContent == null ? null : feeContent.trim();
    }
}