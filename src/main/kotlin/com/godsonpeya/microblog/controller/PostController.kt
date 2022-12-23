package com.godsonpeya.microblog.controller

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("posts")
class PostController @Autowired constructor(private val postService: PostService) {
    @GetMapping("getall")
    fun getAllPosts() : ResponseEntity<List<Post>>
    =  ResponseEntity.ok(postService.getAllPost())

    @GetMapping("getone/{id}")
    fun getOnePost(@PathVariable id :Long) : ResponseEntity<Post>
    = ResponseEntity.ok(postService.getOnePost(id))

    @PostMapping("add/{userId}")
    fun addPost(@PathVariable userId : Long, @RequestBody post : Post) : ResponseEntity<Post>
    = ResponseEntity.ok(postService.savePost(userId, post))

    @DeleteMapping("delete/{id}")
    fun deletePost(@PathVariable id : Long) : ResponseEntity<String>
    = ResponseEntity.ok(postService.deletePost(id))

    @PutMapping("update/{id}")
    fun updatePost(@PathVariable id:Long, @RequestBody post : Post)  : ResponseEntity<Post>
    = ResponseEntity.ok(postService.updatePost(id, post))
}