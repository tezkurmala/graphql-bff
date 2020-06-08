package com.by.lcc.bff.web.resolver.query;

import com.by.lcc.bff.model.Post;
import com.by.lcc.bff.dao.PostDao;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class PostQueryResolver implements GraphQLQueryResolver {
        private PostDao postDao;

    public PostQueryResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {
            return postDao.getRecentPosts(count, offset);
        }
}