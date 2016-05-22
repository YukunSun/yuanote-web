package com.yuanote.domain;

public class NotebookType {
    private Long sid;

    private String notebookTypeCode;

    private String notebookTypeName;

    private String notebookTypeDesc;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getNotebookTypeCode() {
        return notebookTypeCode;
    }

    public void setNotebookTypeCode(String notebookTypeCode) {
        this.notebookTypeCode = notebookTypeCode == null ? null : notebookTypeCode.trim();
    }

    public String getNotebookTypeName() {
        return notebookTypeName;
    }

    public void setNotebookTypeName(String notebookTypeName) {
        this.notebookTypeName = notebookTypeName == null ? null : notebookTypeName.trim();
    }

    public String getNotebookTypeDesc() {
        return notebookTypeDesc;
    }

    public void setNotebookTypeDesc(String notebookTypeDesc) {
        this.notebookTypeDesc = notebookTypeDesc == null ? null : notebookTypeDesc.trim();
    }
}