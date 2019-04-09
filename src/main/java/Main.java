import entity.Boots;
import entity.User;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Boots trampki = new Boots(1L,"converse",100,1,"black",50,42,false);
        //System.out.println(trampki);

        List<User> userki = new ArrayList<User>();
        userki.add(new User(1L,"andrzej", "andrzejkowski"));
        userki.add(new User(2L,"michal", "michalkowski"));

        UserServiceImpl userService = new UserServiceImpl(userki);

        List<User> test = userService.getAllUsers();
        System.out.println(test.size());
        for (User user:test
             ) {
            System.out.println(user.getLogin());
        }

        userService.removeUserById(2L);
        System.out.println("Fsafasf /n /n");


        test = userService.getAllUsers();
        System.out.println(test.size());
        for (User user:test
        ) {
            System.out.println(user.getLogin());
        }
    }
}
