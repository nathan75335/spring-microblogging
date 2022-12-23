package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.Exceptions.NotFoundException
import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.repository.PostRepository
import com.godsonpeya.microblog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(private var postRepository: PostRepository, private val userRepository: UserRepository) {
    fun getAllPost() : List<Post> {

        val posts : List<Post> = postRepository.findAll();

        if(posts.isNullOrEmpty()){
            throw NotFoundException("The posts were not Found")
        }

        return posts
    }

    fun getOnePost(id: Long) : Post{
        var post = postRepository.findById(id).orElseThrow{
            NotFoundException("The post was not Found")
        }

        return post
    }

    fun updatePost(id : Long , post : Post) : Post{

        var postLooked = postRepository.findById(id).orElseThrow {
            NotFoundException("THe post was not Found")
        }

        postLooked.content = post.content
        postLooked.updatedAt = post.updatedAt

        return postRepository.save(postLooked)
    }

    fun deletePost(id: Long): String{
        var postLooked = postRepository.findById(id).orElseThrow{
            NotFoundException("The post was not Found")
        }

        postRepository.delete(postLooked)

        return "The post has been deleted"
    }

    fun savePost(userId :Long, post : Post) : Post{
        var user = userRepository.findById(userId).orElseThrow{
            NotFoundException("The user was not Found")
        }

        post.user = user;

        return postRepository.save(post)
    }
}