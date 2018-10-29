package com.tuboshu.bean;

import java.io.Serializable;

public class TbsUser implements Serializable {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 备用以后微信开发
     */
    private String openId;

    /**
     * 备用以后微信开发
     */
    private String unionId;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 等级,0：普通用户
     */
    private String level;

    /**
     * 创建时间
     */
    private Long created;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 账号
     */
    private String account;

    /**
     * 关联资产表
     */
    private Long accountId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地区编号
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