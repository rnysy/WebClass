package kr.hs.dgsw.weblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.hs.dgsw.weblog.Domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);
}