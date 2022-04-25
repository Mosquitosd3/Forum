package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Comment;

import java.util.List;

public interface CommnetRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findCommentsByPostId(int postId);
}
