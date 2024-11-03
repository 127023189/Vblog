package org.yixi.vblogserver.bean;


public class RespBean {
    private String status;
    private String msg;

    public RespBean() {
    }

    public RespBean(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "RespBean{status = " + status + ", msg = " + msg + "}";
    }
}
