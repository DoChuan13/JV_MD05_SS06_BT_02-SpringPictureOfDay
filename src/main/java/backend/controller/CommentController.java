package backend.controller;

import backend.model.Comment;
import backend.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/comment"})
public class CommentController {
    @Autowired
    ICommentService commentService;

    @GetMapping
    public ModelAndView showPicture() {
        ModelAndView view = new ModelAndView("index");
        List<Comment> commentList = commentService.findAll();
        Comment comment = new Comment();
        view.addObject("comment", comment);
        view.addObject("listComment", commentList);
        return view;
    }

    @PostMapping("/create")
    public String actionCreateComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String actionLikeComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        comment.setLikes(comment.getLikes() + 1);
        commentService.save(comment);
        return "redirect:/";
    }
}
