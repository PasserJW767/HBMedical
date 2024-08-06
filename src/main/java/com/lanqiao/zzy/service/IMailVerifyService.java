package com.lanqiao.zzy.service;

public interface IMailVerifyService {
    public boolean sendVerifyCode(String receiver);
    public String getVerifyCode();
}
