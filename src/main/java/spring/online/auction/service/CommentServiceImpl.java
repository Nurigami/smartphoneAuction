package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Comment;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.User;
import spring.online.auction.model.response.CommentResponse;
import spring.online.auction.model.response.Message;
import spring.online.auction.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private UserService userService;
    @Override
    public CommentResponse getCommentsCountByPhoneId(Long phoneId) {
        return new CommentResponse(commentRepository.getCommentsCountByPhoneId(phoneId));
    }

    @Override
    public Message addComment(Long phoneId, String login, String text) {
        Phone phone = phoneService.getPhoneById(phoneId);
        User user = userService.getUserByLogin(login);
        Comment comment = new Comment(user,phone,text);
        commentRepository.save(comment);
        return new Message("Comment is added");
    }

    @Override
    public Message removeComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentRepository.delete(comment);
        return new Message("Comment is removed");
    }

    @Override
    public List<Comment> getCommentsByPhoneId(Long phoneId) {
        return commentRepository.getCommentsByPhoneId(phoneId);
    }
}
