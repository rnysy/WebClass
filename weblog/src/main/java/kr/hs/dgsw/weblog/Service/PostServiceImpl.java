package kr.hs.dgsw.weblog.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.weblog.Domain.Post;
import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Repository.PostRepository;
import kr.hs.dgsw.weblog.Repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init()
    {
        User user = userRepository.save(new User("hng01","12345678", "허남경", "nknk610@dgsw.hs.kr","010-2313-2342", "picture"));
        postRepository.save(new Post(user.getId(), "자세한 제목은 내용을 참조", "자세한 내용은 제목을 참조"));
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post read(Long id) {
        return postRepository.findById(id). isPresent() ? postRepository.findById(id).get() : null;
    }

    @Override
    public Post readByUserId(Long userId) {
        return postRepository.findTopByUserIdOrderByIdDesc(userId).orElse(null);
    }

    @Override
    public Post update(Long id, Post post) {
        return postRepository.findById(id)
        .map(found -> {
            found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
            found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
            found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
            return postRepository.save(found);
        }).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        try
        {
            postRepository.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }
}