package kr.hs.dgsw.weblog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.weblog.Domain.Post;
import kr.hs.dgsw.weblog.Protocol.ResponseFormat;
import kr.hs.dgsw.weblog.Protocol.ResponseType;
import kr.hs.dgsw.weblog.Service.PostService;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post/create")
    public ResponseFormat create(@RequestBody Post post)
    {
        Post newPost = postService.create(post);
        if(newPost != null)
        {
            return new ResponseFormat(
                ResponseType.POST_ADD,
                newPost,
                newPost.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @PutMapping("post/update/{id}")
    public ResponseFormat update(@PathVariable long id, @RequestBody Post post)
    {
        Post updated = postService.update(id, post);
        if(updated != null)
        {
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                updated,
                updated.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseFormat delete(@PathVariable long id)
    {
        boolean isSuccess = postService.delete(id);
        if(isSuccess)
        {
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                isSuccess,
                id
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read/{id}")
    public ResponseFormat read(@PathVariable long id)
    {
        Post post = postService.read(id);
        if(post != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET,
                post,
                post.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read/user/{userId}")
    public ResponseFormat readByUserId(@PathVariable long userId)
    {
        Post post = postService.readByUserId(userId);
        if(post != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET_BY_USER,
                post,
                post.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read")
    public ResponseFormat readAll()
    {
        List<Post> postList = postService.readAll();
        if(postList != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET_ALL,
                postList
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}