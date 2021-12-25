package com.redis.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.demo.model.Post;
import com.redis.demo.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("")
	public ResponseEntity<List<Post>> getAllPost() {
		return ResponseEntity.ok(postService.getAllPost());
	}

	@PostMapping("/create")
	public ResponseEntity<String> savePost(@RequestBody Post post) {
		System.out.println(post);
		postService.savePost(post);
		return ResponseEntity.ok("Saved");
	}

	@GetMapping("/{id}")
	public Post getPostById(@PathVariable("id") String id) {
		Post post;
		post = postService.getPostById(id);
		return post;
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable("id") String id) {
		try {
			postService.deletePostById(id);
			return ResponseEntity.ok("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
