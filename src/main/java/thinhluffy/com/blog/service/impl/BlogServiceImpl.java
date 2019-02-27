package thinhluffy.com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import thinhluffy.com.blog.model.Blog;
import thinhluffy.com.blog.repository.BlogRepository;
import thinhluffy.com.blog.service.BlogService;

import java.util.List;


public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
