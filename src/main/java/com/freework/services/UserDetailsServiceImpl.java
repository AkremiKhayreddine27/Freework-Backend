package com.freework.services;

import com.freework.entities.Freelancer;
import com.freework.repositories.FreelancersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private FreelancersRepository freelancersRepository;
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        Freelancer activeUserInfo = freelancersRepository.findByName(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority("user");
        UserDetails userDetails = (UserDetails)new User(activeUserInfo.getName(),
                activeUserInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
