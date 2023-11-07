package com.spring.javablog.JavablogController;

import com.spring.javablog.model.Post;
import com.spring.javablog.service.JavablogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class JavablogController {
    @Autowired
    JavablogService javablogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView();
        List<Post> posts = javablogService.findAll();
        mv.addObject("posts", posts);

        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getFullPost(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("fullPost");
        Post post = javablogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value="/newpost", method = RequestMethod.POST)
    public String savePost(@ModelAttribute @Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "verifique se os campos obrigatórios foram preenchios!");
            return "redirect:/newpost";
        } else {
            post.setDate(LocalDate.now());
            javablogService.save(post);
            return "redirect:/posts";
        }

    }
}
