package com.sql.ehremail.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailTool {
    @Autowired
    JavaMailSenderImpl mailSender;
    ;
    /**
     * 发送纯文本无附件的简单邮件
     * @param title
     * @param content
     * @param fromEmail
     * @param toEmail
     */
    public void sendSimpleMail(String title,String content,String fromEmail,String toEmail){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setSubject(title);
        message.setText(content);
        message.setTo(toEmail);
        message.setFrom(fromEmail);
        mailSender.send(message);
    }

    /**
     * 发送内容支持html，带有多个附件的复杂邮件
     * @param title
     * @param content
     * @param fromEmail
     * @param toEmail
     * @param files
     */
    public void sendComplexMail(String title,String content,String fromEmail,String toEmail,
                                File[] files){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);    //multipart:是否支持文件上传

            //邮件设置
            helper.setSubject(title);
            helper.setText(content, true);  //html:内容是否支持html
            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            //上传文件
            for(int i=0;i<files.length;i++)
                helper.addAttachment(files[i].getName(),files[i]);
            mailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送内容支持html，带有一个附件的复杂邮件
     * @param title
     * @param content
     * @param fromEmail
     * @param toEmail
     * @param fileName
     * @param file
     */
    public void sendComplexMail(String title, String content, String fromEmail, String toEmail,
                                String fileName, File file){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);    //multipart:是否支持文件上传

            //邮件设置
            helper.setSubject(title);
            helper.setText(content, true);  //html:内容是否支持html
            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            //上传文件
            helper.addAttachment(fileName,file);
            mailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
