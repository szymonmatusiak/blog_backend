package com.example.blog.repositories;

import com.example.blog.objects.Post;
import com.example.blog.objects.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
