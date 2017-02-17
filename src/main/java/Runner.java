import by.epam.training.beans.User;
import by.epam.training.services.CommentService;
import by.epam.training.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Package: PACKAGE_NAME
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
public class Runner {
    private static final ApplicationContext ANNO_CONTEXT =
            new ClassPathXmlApplicationContext("config.xml");

    private static UserService userService =
            ANNO_CONTEXT.getBean(UserService.class);

    private static CommentService commentService =
            ANNO_CONTEXT.getBean(CommentService.class);

    public static void main(String[] args) {
        User newUser = new User("lotysh","spring", User.Roles.ADMIN);
        userService.addUser(newUser);
        for (User user : userService.getAll()) {
            System.out.println(user);
        }
    }
}
