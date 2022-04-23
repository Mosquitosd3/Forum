package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postStore;
    private TopicRepository topicStore;

    public PostService(PostRepository postStore, TopicRepository topicStore) {
        this.postStore = postStore;
        this.topicStore = topicStore;
    }

    public void save(Post post) {
        postStore.save(post);
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
