package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.online.auction.entity.Comment;
import spring.online.auction.model.response.CommentResponse;
import spring.online.auction.model.response.Message;
import spring.online.auction.service.CommentService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auction/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/all/{phoneId}")
    public CommentResponse getCommentsCountByPhoneId(@PathVariable Long phoneId){
        return commentService.getCommentsCountByPhoneId(phoneId);
    }
    @PostMapping("/user/{phoneId}")
    public Message addComment(@PathVariable Long phoneId, Principal principal, @RequestHeader String text){
        if (principal==null) return new Message("Please sign in");
        return commentService.addComment(phoneId,principal.getName(),text);
    }
    @DeleteMapping("/admin/{commentId}")
    public Message removeComment(@PathVariable Long commentId){
        return commentService.removeComment(commentId);
    }
    @GetMapping("/all/history/{phoneId}")
    public List<Comment> getCommentsByPhoneId(@PathVariable Long phoneId){
        return commentService.getCommentsByPhoneId(phoneId);
    }
}
