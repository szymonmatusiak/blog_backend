package com.example.blog.repositories;

import com.example.blog.objects.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    //List<Paragraph> findAllByPostId(int id);
}
