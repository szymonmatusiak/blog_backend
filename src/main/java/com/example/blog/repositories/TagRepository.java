package com.example.blog.repositories;

import com.example.blog.objects.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TagRepository extends JpaRepository<Tag, Long> {
    //Tag findByTagName(String name);
}
