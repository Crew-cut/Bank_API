package com.bank.config;

import com.bank.domain.Users;
import com.bank.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = userRepo.findByLogin(username);
        if (users.isPresent()){
            var userObj = users.get();
            return User.builder()
                    .username(userObj.getLogin())
                    .password(userObj.getPassword())
                    .roles(getRole(userObj))
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }

    }

    private String [] getRole(Users users) {
        if (users.getRole() == null){
            return new String[]{"USER"};
        }
        return users.getRole().split(",");
    }
}
