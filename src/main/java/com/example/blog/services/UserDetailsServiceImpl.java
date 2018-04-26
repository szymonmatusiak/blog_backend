package com.example.blog.services;

import com.example.blog.objects.UserRename;
import com.example.blog.repositories.UserRenameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRenameRepository userRenameRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRename user = userRenameRepository.findByEmail(username);
        if (user == null) {
            new UsernameNotFoundException(username);
        }
        return new User(user.getEmail(), user.getPassword(), emptyList());
    }
}
