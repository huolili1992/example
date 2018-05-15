package com.huolili.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by Huolili on 2018/4/12
 */
public class MailUtil {
    public static String User= "desktop_02@sina.com";
    public static String PassWord= "desktop_02";
    public static String HOST = "smtp.sina.com";
    //  public static String HOST = "smtp.sina.cn";

    public static String from=User;

    public static final String Subject = "【TV自动化测试报错】本邮件由大屏监控组自动化测试自动发出";
    private static final String picPath = "data//local//tmp//screenshot//screenshot.png";
//    public static final String PicPath = "//Users//leeco//Documents//screenshot.png";

    //    收件人邮箱
    Address to1;
    Address to2,to3,to4;
    Address[] receivers;

//    sendMail():发送邮件
    public  void sendMail(String content) throws MessagingException, UnsupportedEncodingException {
//        初始化发、收件人信息
        to1=new InternetAddress("huolili@le.com");
        receivers=new InternetAddress[1];
        receivers[0]=to1;

        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822");

//        1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties prop=new Properties();
        prop.put("mail.smtp.host",HOST); //设置smtp主机
        prop.put("mail.smtp.auth", "true"); //身份验证
        prop.put("mail.smtp.port","25");  // 设置端口
//        2. 根据配置创建会话对象, 用于和邮件服务器交互
        Authenticator authenticator=new Authenticator() {
            public  PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(User,PassWord);
            }
        };
        Session session=Session.getDefaultInstance(prop,authenticator);
//        开启邮件日志
//        session.setDebug(true);
//        创建MimeMessage对象
        MimeMessage mimeMessage=new MimeMessage(session);
//        3.创建邮件
//        设置发件人
        mimeMessage.setFrom(new InternetAddress(from,"大屏监控组","UTF-8"));
//        设置收件人
        mimeMessage.addRecipients(Message.RecipientType.TO, receivers);
//        设置主题
        mimeMessage.setSubject(Subject);
//        创建正文
//        mimeMessage.setText(content,"utf-8");
        MimeBodyPart text=new MimeBodyPart();
        MimeBodyPart img=new MimeBodyPart();
        DataHandler dh=new DataHandler(new FileDataSource(picPath));
        img.setDataHandler(dh);
        img.setContentID("a");

        text.setText(content+"</a><br /><img src='cid:a'>","UTF-8","html");

//      创建MimeMultipart对象，它是个容器，可容纳多个bodypart
        MimeMultipart mm=new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(img);
        mm.setSubType("related");
        mimeMessage.setContent(mm);

        mimeMessage.saveChanges();



//        3. 发送邮件
        Transport transport = session.getTransport("smtp");//创建连接

        transport.connect(HOST,User,PassWord);//连接服务器

        transport.send(mimeMessage);//发送信息

        transport.close();//关闭连接

        System.out.print("Mail send succeed!");


    }

//    public static void main(String[] Args) throws UnsupportedEncodingException, MessagingException {
//        new MailUtil().sendMail("test");
//        System.exit(0);
//    }
}
