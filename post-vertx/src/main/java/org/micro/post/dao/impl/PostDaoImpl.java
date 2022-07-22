package org.micro.post.dao.impl;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.hibernate.reactive.mutiny.Mutiny;
import org.micro.post.dao.PostDao;
import org.micro.post.dto.PostDto;
import org.micro.post.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDaoImpl implements PostDao {

    private final Mutiny.SessionFactory sessionFactory;
    private static final String TITLE_PARAM = "title";

    @Override
    public Uni<Post> save(PostDto postDto) {
        return sessionFactory.withSession(session -> {
            Post post = new Post();
            post.setTitle(postDto.getTitle());
            post.setText(postDto.getText());
            return session.persist(post).chain(session::flush).replaceWith(post);
        });
    }

    @Override
    public Uni<Post> findByTitle(String title) {
        return sessionFactory.withSession(session -> session.createQuery("select p from Post p where p =:title", Post.class)
                .setParameter(TITLE_PARAM, title).getSingleResult());
    }

    @Override
    public Uni<Post> findById(Long id) {
        return sessionFactory.withSession(session -> session.find(Post.class, id));
    }

    @Override
    public Uni<List<Post>> findAll() {
        return sessionFactory.withSession(session -> session.createQuery("select p from Post p", Post.class).getResultList());
    }
}