package thinhluffy.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import thinhluffy.com.blog.model.Blog;
import thinhluffy.com.blog.service.BlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    //create blog
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("message","New blog created sucessfully!");
        return modelAndView;
    }
    //List Blog
    @GetMapping("/list")
    public ModelAndView listBlog(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
    //edit
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);

        if (blog!=null){
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit/")
    public ModelAndView edit(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Update Sucessfully!");
        return modelAndView;
    }
    //Delete Blog
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Blog blog = blogService.findById(id);

        if (blog!=null){
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete/")
    public String deleteBlog(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/list";
    }
}
