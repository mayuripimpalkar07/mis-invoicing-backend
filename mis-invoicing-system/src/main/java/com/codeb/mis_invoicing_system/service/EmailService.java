package com.codeb.mis_invoicing_system.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Value("${app.backend.url}")
    private String backendUrl;

    @Value("${BREVO_API_KEY}")
    private String brevoApiKey;

    @Value("${BREVO_SENDER_EMAIL}")
    private String senderEmail;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BREVO_API_URL = "https://api.brevo.com/v3/smtp/email";

    public void sendVerificationEmail(String toEmail, String token) {
        String verificationLink = backendUrl + "/api/auth/verify?token=" + token;
        String content = "Please click the link below to verify your email:<br><br><a href=\"" + verificationLink + "\">" + verificationLink + "</a>";
        sendEmail(toEmail, "CodeB - Verify your email", content);
    }

    public void sendResetPasswordEmail(String toEmail, String token) {
        String resetLink = backendUrl + "/api/auth/reset-password?token=" + token;
        String content = "Click the link below to reset your password (valid for 15 minutes):<br><br><a href=\"" + resetLink + "\">" + resetLink + "</a>";
        sendEmail(toEmail, "CodeB - Reset your password", content);
    }

    private void sendEmail(String toEmail, String subject, String htmlContent) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", brevoApiKey);
        headers.set("accept", "application/json");

        Map<String, Object> sender = new HashMap<>();
        sender.put("name", "CodeB");
        sender.put("email", senderEmail);

        Map<String, Object> recipient = new HashMap<>();
        recipient.put("email", toEmail);

        Map<String, Object> body = new HashMap<>();
        body.put("sender", sender);
        body.put("to", new Object[]{recipient});
        body.put("subject", subject);
        body.put("htmlContent", htmlContent);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        restTemplate.postForEntity(BREVO_API_URL, request, String.class);
    }
}