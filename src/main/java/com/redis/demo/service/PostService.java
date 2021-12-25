package com.redis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.redis.demo.model.Post;

@Service
public interface PostService {
	public Boolean savePost(Post post);
	public List<Post> getAllPost();
	public Post getPostById(String id);
	public void deletePostById(String id);
}
