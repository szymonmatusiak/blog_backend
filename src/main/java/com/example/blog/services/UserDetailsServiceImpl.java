package com.example.blog.services;

import com.example.blog.objects.ApplicationUser;
import com.example.blog.objects.Role;
import com.example.blog.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.invoke.empty.Empty;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserRepository.findByEmail(username);
        if (user == null) {
            new UsernameNotFoundException(username);
        }
        User user1 = new User(user.getEmail(), user.getPassword(), Collections.emptyList());
        return user1;
    }

    public SimpleGrantedAuthority toGrantedAuthority(Role role) {
        return new SimpleGrantedAuthority(role.getRoleName());
    }

    public Set<SimpleGrantedAuthority> toGranted(Set<Role> roles) {
        return roles.stream().map(this::toGrantedAuthority).collect(Collectors.toSet());
    }
}
