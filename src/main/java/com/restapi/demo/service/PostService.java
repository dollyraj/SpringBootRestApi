package com.restapi.demo.service;


import com.restapi.demo.entity.Customer;
import com.restapi.demo.entity.Post;
import com.restapi.demo.exception.CustomerNotFoundException;
import com.restapi.demo.jparepo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    CustomerService customerService;

    public PostService(PostRepository postRepository,CustomerService customerService) {
        this.postRepository = postRepository;
        this.customerService=customerService;
    }


    public List<Post> createPost(int customer_id, Post post){

       // List<PostDTO> postDTOList=new ArrayList<PostDTO>();

        Optional<Customer> customer=customerService.findCustomerById(customer_id);

        if(!customer.isPresent())
            throw new CustomerNotFoundException("Customer not found with id: "+customer_id);

       // Post postEntity=new Post(postDTO.getId(),postDTO.getName());
        post.setCustomer(customer.get());



        postRepository.save(post);

       // postDTOList.addAll(customer.get().getPosts());

        return customer.get().getPosts();
    //   return new PostDTO((postEntity.getId()),postEntity.getName());
    }


    public List<Post> retrievePostForCustomer(int customer_id) {
        Optional<Customer> customer=customerService.findCustomerById(customer_id);

        if(!customer.isPresent())
            throw new CustomerNotFoundException("Customer not found with id: "+customer_id);


        return customer.get().getPosts();
    }
}
