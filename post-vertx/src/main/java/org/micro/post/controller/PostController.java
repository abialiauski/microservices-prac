package org.micro.post.controller;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.micro.post.dao.PostDao;
import org.micro.post.dto.PostDto;
import org.micro.post.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostDao postDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Uni<Post> createPost(@RequestBody PostDto postDto) {
        return postDao.save(postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Uni<Post> getById(@PathVariable Long id) {
        return postDao.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    public Uni<Post> getByTitle(@RequestParam String title) {
        return postDao.findByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Uni<List<Post>> getAll() {
        return postDao.findAll();
    }
}