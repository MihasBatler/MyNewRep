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

//Иван, извините, что здесь пишу. У меня никак не получается добавить папки в .gitignore
//Бился с этим весь день. Пытался добавить target, spring_hibernate.iml, resources.
//Я перепробовал все способы (вручную, через терминал, в идее), получилось добавить только .idea.
//Никак не могу понять, что не так
