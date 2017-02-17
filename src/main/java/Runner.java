import by.epam.training.DataConfig;
import by.epam.training.beans.Comment;
import by.epam.training.beans.User;
import by.epam.training.services.CommentService;
import by.epam.training.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Package: PACKAGE_NAME
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
public class Runner {
    private static final ApplicationContext ANNO_CONTEXT =
            new AnnotationConfigApplicationContext(DataConfig.class);
            //new ClassPathXmlApplicationContext("config.xml");

    private static UserService userService =
            ANNO_CONTEXT.getBean(UserService.class);

    private static CommentService commentService =
            ANNO_CONTEXT.getBean(CommentService.class);

    public static void main(String[] args) {
        User newUser = new User("isakau","spring", User.Roles.ADMIN);
        userService.addUser(newUser);
        User isakau = userService.getByLogin("isakau");
        Comment comment =
                new Comment(isakau, "Hello, Valera!");
        commentService.addComment(comment);
        for (Comment comment1 : commentService.getAll()) {
            System.out.println(comment1);
        }
    }
}
