package entity.parser;

import entity.User;

public class UserParser {


    public static User StringToUser(String oneLineFromFile) {


        return convertToUser(oneLineFromFile);
    }

    private static User convertToUser(String oneLineFromFile) {

        String [] userInfo = oneLineFromFile.split(User.USER_SEPARATOR);

        User user = new User(
                Long.parseLong(userInfo[0]),
                userInfo[1],
                userInfo[2]
        );

        return user;

    }
}


