package com.example.blog.repositories;

import com.example.blog.objects.UserRename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRenameRepository extends JpaRepository<UserRename, Long> {

    UserRename findByEmail(String username);
}
