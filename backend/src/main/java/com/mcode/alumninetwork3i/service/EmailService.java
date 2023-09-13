package com.mcode.alumninetwork3i.service;

public interface EmailService {
    void send(String to, String subject, String content);

    String buildEmailVerifyMail(String token);

    String buildResetPasswordMail(String token);
}
