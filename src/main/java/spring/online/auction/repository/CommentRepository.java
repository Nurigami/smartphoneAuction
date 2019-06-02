package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select count(c.phone.id) from Comment c " +
            "where c.phone.id = :id ")
    Long getCommentsCountByPhoneId(@Param("id") Long phoneId);

    @Query("select c from Comment c " +
            "where c.phone.id = :id ")
    List<Comment> getCommentsByPhoneId(@Param("id") Long phoneId);
}
