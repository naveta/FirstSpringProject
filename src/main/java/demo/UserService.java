package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by robotic4 on 7/10/15.
 */

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User save(User user){
        user=userDao.save(user);
        return user;
    }
}
