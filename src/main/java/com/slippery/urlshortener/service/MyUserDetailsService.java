package com.slippery.urlshortener.service;

import com.slippery.urlshortener.models.UserPrincipal;
import com.slippery.urlshortener.models.Users;
import com.slippery.urlshortener.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user =repository.findByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
