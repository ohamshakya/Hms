package com.project.hms.security;

import com.project.hms.entity.User;
import com.project.hms.repository.UsersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    private final UsersRepo usersRepo;

    public MyUserDetailsService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = usersRepo.findByUsername(username);
        if(users == null){
            log.error("USER NOT FOUND");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(users);
    }
}
