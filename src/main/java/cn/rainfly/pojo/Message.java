package cn.rainfly.pojo;

public class Message {

    private    Boolean res;

    private   String msg;

    public static  Message CreateMessage(Boolean res, String msg) {
        Message message = new Message();
        message.setRes(res);
        message.setMsg(msg);
        return message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }
}
