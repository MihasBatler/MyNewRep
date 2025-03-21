package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    void add(User user);

    @Transactional(readOnly = true)
    List<User> listUsers();

    @Transactional(readOnly = true)
    User getUserByCar(String model, int series);
}


