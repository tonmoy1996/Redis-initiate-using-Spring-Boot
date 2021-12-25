package com.redis.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.demo.model.Post;

@Repository
public class PostRepository {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	private static final String KEY="USER";
	
	public void savePost(Post post) {
		redisTemplate.opsForHash().put(KEY, post.getId().toString(), post);
	}
	
	public List<Post> getAllPost(){
		List<Post> posts;
		posts=redisTemplate.opsForHash().values(KEY);
		return posts;
	}
}
