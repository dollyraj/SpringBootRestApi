package com.restapi.demo.controller;


import com.restapi.demo.entity.Post;
import com.restapi.demo.service.PostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/posts")
@Validated
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{customer_id}")
   // @ResponseStatus(HttpStatus.CREATED)
     List<Post> createPost(@PathVariable("customer_id") int customerId, @RequestBody @Valid Post post){
         return postService.createPost(customerId,post);
    }

    @GetMapping("/{customer_id}/p")
    List<Post> retrievePostForCustomer(@PathVariable("customer_id") int customerId, @RequestBody @Valid Post post){
        return postService.retrievePostForCustomer(customerId);
    }
}
