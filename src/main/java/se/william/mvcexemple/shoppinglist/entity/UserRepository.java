package se.william.mvcexemple.shoppinglist.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
