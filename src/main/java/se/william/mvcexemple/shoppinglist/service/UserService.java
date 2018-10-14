package se.william.mvcexemple.shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.william.mvcexemple.shoppinglist.entity.Role;
import se.william.mvcexemple.shoppinglist.entity.RoleRepository;
import se.william.mvcexemple.shoppinglist.entity.User;
import se.william.mvcexemple.shoppinglist.entity.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        Role userRole = roleRepository.findById(3).get();
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setActive(1);
        this.userRepository.save(user);
    }

}
