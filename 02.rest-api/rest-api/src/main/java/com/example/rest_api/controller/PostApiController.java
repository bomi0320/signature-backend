package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // http://localhost:8080/api/post
    @PostMapping("/post")
    public String post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    // http://localhost:8080/api/user
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);

        return userRequest;
    }

}
