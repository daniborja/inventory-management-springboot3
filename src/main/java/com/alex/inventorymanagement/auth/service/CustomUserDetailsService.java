package com.alex.inventorymanagement.auth.service;

import com.alex.inventorymanagement.auth.jwt.UserDetailsImpl;
import com.alex.inventorymanagement.common.exceptions.UserNotFoundException;
import com.alex.inventorymanagement.users.entity.Usuario;
import com.alex.inventorymanagement.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // @Autowired in auto by constructor thanks to @RequiredArgsConstructor
    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
        Usuario user = userService.findOneByEmail(email);

        return new UserDetailsImpl(user);
    }

}