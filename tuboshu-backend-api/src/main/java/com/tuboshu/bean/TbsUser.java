package com.tuboshu.bean;

import java.io.Serializable;

public class TbsUser implements Serializable {
    /**
     * ����id
     */
    private Long id;

    /**
     * �����Ժ�΢�ſ���
     */
    private String openId;

    /**
     * �����Ժ�΢�ſ���
     */
    private String unionId;

    /**
     * �ֻ���
     */
    private String phoneNum;

    /**
     * ����
     */
    private String name;

    /**
     * �ȼ�,0����ͨ�û�
     */
    private String level;

    /**
     * ����ʱ��
     */
    private Long created;

    /**
     * ����
     */
    private String pwd;

    /**
     * �˺�
     */
    private String account;

    /**
     * �����ʲ���
     */
    private Long accountId;

    /**
     * ����
     */
    private String email;

    /**
     * �������
     */
    private String areaCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", created=").append(created);
        sb.append(", pwd=").append(pwd);
        sb.append(", account=").append(account);
        sb.append(", accountId=").append(accountId);
        sb.append(", email=").append(email);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}