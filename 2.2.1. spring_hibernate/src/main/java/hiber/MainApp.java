package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("Чичи", "Рис", "user1@mail.ru");
      User user2 = new User("Чючю", "Петрова", "user2@mail.ru");
      User user3 = new User("Чюча", "Янг", "user3@mail.ru");
      User user4 = new User("Чичю", "Чан", "user4@mail.ru");
      User user5 = new User("Тарас", "Бульба", "user5@mail.ru");

      Car mercedes = new Car("mercedes", 17);
      Car hyundai = new Car("hyundai", 424);
      Car nissan = new Car("nissan", 110);
      Car toyota = new Car("toyota", 100);
      Car mitsubishi = new Car("mitsubishi", 490);


      userService.add(user1.setCar(mercedes).setUser(user1));
      userService.add(user2.setCar(hyundai).setUser(user2));
      userService.add(user3.setCar(nissan).setUser(user3));
      userService.add(user4.setCar(toyota).setUser(user4));
      userService.add(user5.setCar(mitsubishi).setUser(user5));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("mercedes", 17));


      context.close();
   }
}
