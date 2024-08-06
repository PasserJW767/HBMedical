package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.service.IMailVerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("mailVerifyService")
@Slf4j
public class MailVerifyServiceImpl implements IMailVerifyService {

    @Autowired
    JavaMailSenderImpl mailSender;

    private String code = null;

    @Override
    public boolean sendVerifyCode(String receiver) {
        if(mailSender == null){
            log.error("注册邮件发送失败！自动注入的mailSender对象为空！");
            return false;
        }
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        /*邮件标题*/
        mailMessage.setSubject("【河北中医药网】注册验证码");
        /*邮件内容(随机生成验证码)*/
        code = UUID.randomUUID().toString().substring(0,6);
        if(code == null){
            log.error("注册邮件发送失败！生成的随机验证码为空！");
            return false;
        }
        mailMessage.setText("【河北中医药网】\n" +
                            "您本次注册的验证码为" + code + ",\n" +
                            "若并非您本人操作，请忽视本封邮件。");
        /*发送人(必须和配置文件中的username相同)*/
        mailMessage.setFrom("709263897@qq.com");
        /*收件人*/
        mailMessage.setTo(receiver);
        /*发送*/
        mailSender.send(mailMessage);
        return true;
    }

    @Override
    public String getVerifyCode() {
        return this.code;
    }
}
