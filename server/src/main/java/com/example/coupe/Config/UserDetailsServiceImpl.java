package com.example.coupe.Config;

import java.util.ArrayList;
import java.util.List;

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

// We could've added this class to the Services package but since the task here
// is related to security we chose to include it in this package

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myuser = userRepository.findByUsername(username);
        if(myuser==null) throw new UsernameNotFoundException("User not found !!!");
        
        List<GrantedAuthority> authorities = new ArrayList<>();
      //System.out.println(myuser.getRoles());
        //System.out.println("-------------------------------------------------");
        myuser.getRoles().forEach(r->{
          //  System.out.println(r.getRoleName());
            authorities.add(new SimpleGrantedAuthority(r.getRoleName().toString()));
          
        });
      //  System.out.println(authorities.get(0));
        return new User(myuser.getUsername(), myuser.getPassword(), authorities);
    }
    
}
