package com.example.coupe.Config;

import java.util.ArrayList;
import java.util.Collection;

//import com.example.coupe.Services.AccountService;
import com.example.coupe.dao.UserRepository;
import com.example.coupe.entities.MyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //@Autowired
    //private AccountService accountService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myuser = userRepository.findByUsername(username);
        if(myuser==null) throw new UsernameNotFoundException("User not found !!!");
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        myuser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        System.out.println(myuser.getUsername());
        return new User(myuser.getUsername(), myuser.getPassword(), authorities);
    }
    
}
