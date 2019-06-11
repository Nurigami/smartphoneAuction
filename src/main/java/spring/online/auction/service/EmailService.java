package spring.online.auction.service;

public interface EmailService {
    void sendEmail(String subject, String messageText, String toEmail);
    String getWinnerEmail(Long phoneId);
    String getSellerEmail(Long phoneId);
}
