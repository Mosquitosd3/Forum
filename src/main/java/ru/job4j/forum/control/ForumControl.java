package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class ForumControl {
    private final PostService service;

    public ForumControl(PostService post) {
        this.service = post;
    }

    @GetMapping("/topic/{id}")
    public String showPostsByTopic(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal());
        model.addAttribute("topic", service.findTopicById(id));
        model.addAttribute("posts", service.findPostByTopic(id));
        return "forum/topic";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal());
        model.addAttribute("topics", service.showAllTopic());
        return "forum/create";
    }

    @GetMapping("/post/{id}")
    public String postPage(Model model, @PathVariable("id") int postId) {
        model.addAttribute("user", SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal());
        model.addAttribute("post", service.findPostById(postId));
        model.addAttribute("comments", service.showAllComments(postId));
        return "forum/post";
    }

    @PostMapping("/addComment/{id}")
    public String addComment(@PathVariable("id") int postId,
                             @ModelAttribute Comment comment) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        comment.setPost(service.findPostById(postId));
        comment.setUser(service.findUserByName(username));
        service.addComment(comment);
        return "redirect:/post/" + postId;
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", service.findPostById(id));
        model.addAttribute("topics", service.showAllTopic());
        return "forum/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        post.setUser(service.findUserByName(username));
        service.save(post);
        return "redirect:/topic/" + post.getTopic().getId();
    }

}
