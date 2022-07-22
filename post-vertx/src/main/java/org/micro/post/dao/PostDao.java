package org.micro.post.dao;

import io.smallrye.mutiny.Uni;
import org.micro.post.dto.PostDto;
import org.micro.post.model.Post;

import java.util.List;

public interface PostDao {

    Uni<Post> save(PostDto postDto);

    Uni<Post> findByTitle(String title);

    Uni<Post> findById(Long id);

    Uni<List<Post>> findAll();
}