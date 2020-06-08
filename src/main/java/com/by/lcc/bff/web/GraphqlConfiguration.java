package com.by.lcc.bff.web;

import java.util.ArrayList;
import java.util.List;

import com.by.lcc.bff.dao.AuthorDao;
import com.by.lcc.bff.dao.PostDao;
import com.by.lcc.bff.model.Author;
import com.by.lcc.bff.model.Post;
import com.by.lcc.bff.web.resolver.field.AuthorResolver;
import com.by.lcc.bff.web.resolver.field.PostResolver;
import com.by.lcc.bff.web.resolver.query.PostQueryResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setCategory("Post " + postId + " + by author " + authorId);
                Author author = new Author();
                author.setId("Author" + authorId);
                post.setAuthor(author);
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public PostResolver postResolver(AuthorDao authorDao) {
        return new PostResolver(authorDao);
    }

    @Bean
    public AuthorResolver authorResolver(PostDao postDao) {
        return new AuthorResolver(postDao);
    }

    @Bean
    public PostQueryResolver query(PostDao postDao) {
        return new PostQueryResolver(postDao);
    }

//    @Bean
//    public Mutation mutation(PostDao postDao) {
//        return new Mutation(postDao);
//    }
}
