package com.by.lcc.bff.web.resolver.field;

import com.by.lcc.bff.model.Author;
import com.by.lcc.bff.dao.AuthorDao;
import com.by.lcc.bff.model.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        return authorDao.getAuthorById(post.getAuthor().getId()).get();
    }
}
