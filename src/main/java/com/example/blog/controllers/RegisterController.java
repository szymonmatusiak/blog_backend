package com.example.blog.controllers;

import com.example.blog.objects.ApplicationUser;
import com.example.blog.objects.Role;
import com.example.blog.repositories.ApplicationUserRepository;
import com.example.blog.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;

@RestController
@RequestMapping("/api2")
public class RegisterController {

    @Autowired
    private ApplicationUserRepository userRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApplicationUser> saveUser(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByRoleName("user");
        //Role role = new Role("user");
        HashSet<Role> hash = new HashSet<>();
        hash.add(role);
        user.setRoles(hash);
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/user2", method = RequestMethod.GET)
    @ResponseBody
    public ApplicationUser getUser(Principal principal) {
        ApplicationUser user = userRepo.findByEmail(principal.getName());

        return user;
    }
}
