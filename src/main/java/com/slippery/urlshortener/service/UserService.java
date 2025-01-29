package com.slippery.urlshortener.service;

import com.slippery.urlshortener.dto.UserDto;
import com.slippery.urlshortener.models.Users;

public interface UserService {
    UserDto login(Users user);
    UserDto register(Users user);
    UserDto findById(Long userId);
    UserDto updateUser(Users userDetails,Long id);
    UserDto deleteById(Long id);
    UserDto findAllUsers();


}
