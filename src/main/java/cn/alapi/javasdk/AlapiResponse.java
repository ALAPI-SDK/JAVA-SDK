package cn.alapi.javasdk;

/**
 * @author yeliulee
 * Created at 2021/6/22 21:04
 */
public class AlapiResponse {
    private long code;
    private String msg;
    private Object data;
    private long time;
    private String logID;

    public long getCode() { return code; }
    public void setCode(long value) { this.code = value; }

    public String getMsg() { return msg; }
    public void setMsg(String value) { this.msg = value; }

    public Object getData() { return data; }
    public void setData(Object value) { this.data = value; }

    public long getTime() { return time; }
    public void setTime(long value) { this.time = value; }

    public String getLogID() { return logID; }
    public void setLogID(String value) { this.logID = value; }
}

