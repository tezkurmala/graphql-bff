package com.by.lcc.bff.web.resolver.field;

import java.util.List;

import com.by.lcc.bff.model.Author;
import com.by.lcc.bff.model.Post;
import com.by.lcc.bff.dao.PostDao;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class AuthorResolver implements GraphQLResolver<Author> {
    private PostDao postDao;

    public AuthorResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }
}
