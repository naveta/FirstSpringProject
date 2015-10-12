package demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by robotic4 on 6/10/15.
 */


@Repository

@Transactional
public interface UserDao extends CrudRepository<User,Long> {

    public User findByEmail(String email);
}
