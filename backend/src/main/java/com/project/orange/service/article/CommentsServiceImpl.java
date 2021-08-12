package com.project.orange.service.article;

import com.project.orange.entity.article.Comments;
import com.project.orange.entity.user.BadgesUsers;
import com.project.orange.repository.article.CommentsRepository;
import com.project.orange.repository.user.BadgesUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    // 뱃지 부여 위한 코드
    @Autowired
    public BadgesUsersRepository badgesUsersRepository;

    @Override
    public Optional<Comments> createComment(Comments comments) {
        // 처음 댓글 작성시 10번 뱃지 부여 로직
        List<BadgesUsers> badgesUsers;
        badgesUsers = badgesUsersRepository.findByUserAndBadge(comments.getUser(), 10L);

        // 처음 얻는 뱃지
        if(badgesUsers.isEmpty()) {
            Long badgeId = 10L;
            Long userId = comments.getUser();

            BadgesUsers badgeUser = BadgesUsers.builder()
                    .badge(badgeId)
                    .user(userId)
                    .badgeCount(1)
                    .build();
            badgesUsersRepository.save(badgeUser);
        }

        Comments newComment = commentsRepository.save(comments);

        return Optional.ofNullable(newComment);
    }

    @Override
    public Optional<Comments> selectOne(Long commentId) { return commentsRepository.findById(commentId); }

    @Override
    public List<Comments> selectAll() { return commentsRepository.findAll(); }

    @Override
    public  List<Comments> selectAllByArticleId(Long article) {
        return commentsRepository.findAllByArticle(article);
    }

    @Override
    public Optional<Comments> updateComment(Comments comments) {
        Comments updatedComment = commentsRepository.save(comments);

        return Optional.ofNullable(updatedComment);
    }

    @Override
    public void deleteByCommentId(Long commentId) { commentsRepository.deleteById(commentId); }
}
