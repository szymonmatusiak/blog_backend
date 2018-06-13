package com.example.blog.repositories;

import com.example.blog.objects.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<PostComment, Long> {
}
