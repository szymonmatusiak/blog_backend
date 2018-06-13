package com.example.blog.repositories;

import com.example.blog.objects.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostRepository extends JpaRepository<Post, Long> {
    //List<Post> findAllByTags_Tag_Name(String tag);
    List<Post> findByTags_Name(String name);

}
