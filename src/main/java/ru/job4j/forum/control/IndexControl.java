package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.job4j.forum.service.PostService;

@Controller
public class IndexControl {
    private final PostService service;

    public IndexControl(PostService post) {
        this.service = post;
    }

    @GetMapping({"/", "index"})
    public String index(Model model) {
        model.addAttribute("topics", service.showAllTopic());
        model.addAttribute("posts", service);
        return "index";
    }
}
