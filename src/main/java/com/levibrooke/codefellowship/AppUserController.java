package com.levibrooke.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/sign-up")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String bio, String dateOfBirth) {
        AppUser newUser =  new AppUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, bio, dateOfBirth);
        appUserRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id, Model m) {
        AppUser user = appUserRepository.findById(id).get();
        m.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/myprofile")
    public String getMyProfile(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/new-post")
    public RedirectView createPost(AppUser author, String body, Principal p) {
        Post newPost = new Post(body);
        AppUser user = appUserRepository.findByUsername(p.getName());
        newPost.author = user;
        postRepository.save(newPost);
        return new RedirectView("/myprofile");
    }
}
