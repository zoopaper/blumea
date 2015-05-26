package org.stream.auth;

/**
 * 用户主体
 * <p/>
 * User: zhangchao@mail-inc.com
 * Date: 12-4-1
 * Time: 上午11:55
 */
public class Principal {

    private long userId;

    private int type;

    private String account;

    private long timestamp;

    private String pId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
