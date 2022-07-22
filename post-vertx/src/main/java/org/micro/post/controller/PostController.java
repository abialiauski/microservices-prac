package org.micro.post.controller;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.micro.post.dao.PostDao;
import org.micro.post.dto.PostDto;
import org.micro.post.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostDao postDao;

    @PostMapping
    public Uni<Post> createPost(@RequestBody PostDto postDto) {
        return postDao.save(postDto);
    }

    @GetMapping("/{id}")
    public Uni<Post> getById(@PathVariable Long id) {
        return postDao.findById(id);
    }

    @GetMapping("/title")
    public Uni<Post> getByTitle(@RequestParam String title) {
        return postDao.findByTitle(title);
    }

    @GetMapping
    public Uni<List<Post>> getAll() {
        return postDao.findAll();
    }
}