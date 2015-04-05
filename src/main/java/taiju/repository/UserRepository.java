package taiju.repository;

import org.springframework.data.repository.CrudRepository;
import taiju.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
