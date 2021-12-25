package com.redis.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.demo.model.Post;
import com.redis.demo.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Boolean savePost(Post post) {
		try {
			postRepository.savePost(post);
			return true;	
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Post> getAllPost() {
		return postRepository.getAllPost();
	}
	

}
