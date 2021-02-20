package com.example.micro.smlr.services.entity;

import com.example.micro.smlr.models.entity.User;
import com.example.micro.smlr.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(s);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Boolean changeUser(User newUser) {
        Optional<User> oldUser  = userRepository.findUserById(newUser.getUserId());
        if(oldUser.isEmpty()){
            throw new EntityNotFoundException("User not found");
        }
        User user = oldUser.get();
        user.setUsername(newUser.getUsername());
        user.setAge(newUser.getAge());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean save(User user) {
        try{
            userRepository.save(user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
