package spring.online.auction.service;

import spring.online.auction.model.response.TimeResponse;

import java.time.LocalDateTime;

public interface TimeService {
    TimeResponse getTimeLeftByPhoneId(Long phoneId);
    String sayTimeLeft(Long diffMinutes);
    Long countTimeLeft(LocalDateTime dateTimePosted);
}
