package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.CommnetRepository;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.TopicRepository;
import ru.job4j.forum.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postStore;
    private TopicRepository topicStore;
    private CommnetRepository commnetStore;
    private UserRepository userStore;

    public PostService(PostRepository postStore,
                       TopicRepository topicStore,
                       CommnetRepository commnetStore,
                       UserRepository userStore) {
        this.postStore = postStore;
        this.topicStore = topicStore;
        this.commnetStore = commnetStore;
        this.userStore = userStore;
    }

    public void save(Post post) {
        postStore.save(post);
    }

    public void addComment(Comment comment) {
        commnetStore.save(comment);
    }

    public List<Comment> showAllComments(int postId) {
        return commnetStore.findCommentsByPostId(postId);
    }

    public User findUserByName(String username) {
        return userStore.findUserByUsername(username);
    }

    public List<Topic> showAllTopic() {
        List<Topic> rsl = new ArrayList<>();
        topicStore.findAll().forEach(rsl::add);
        return rsl;
    }

    public Topic findTopicById(int topicId) {
        return topicStore.findById(topicId).get();
    }

    public List<Post> findPostByTopic(int topicId) {
       return postStore.findByTopicId(topicId);
    }

    public Post findPostById(int postId) {
        return postStore.findById(postId).get();
    }
}
