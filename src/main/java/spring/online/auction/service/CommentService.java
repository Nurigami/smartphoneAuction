package spring.online.auction.service;

import spring.online.auction.entity.Comment;
import spring.online.auction.model.response.CommentResponse;
import spring.online.auction.model.response.Message;

import java.util.List;

public interface CommentService {
    CommentResponse getCommentsCountByPhoneId(Long phoneId);
    Message addComment(Long phoneId, String login, String text);
    Message removeComment(Long commentId);
    List<Comment> getCommentsByPhoneId(Long phoneId);
}
