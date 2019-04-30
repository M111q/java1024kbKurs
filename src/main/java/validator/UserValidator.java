package validator;

import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserValidator {


    private static UserValidator instance = null;


    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public Boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (!isUserByLoginExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("Wybrany login już istnieje.");
        }
        if (!isLoginNotToShort(user.getLogin())) {
            throw new UserShortLengthLoginException("Login jest za krótki.");
        }
        if (!isPasswordNotToShort(user.getPassword())) {
            throw new UserShortLengthPasswordException("Hasło jest za krótkie.");
        }

        return true;
    }

    private Boolean isUserByLoginExist(String userLogin) {
        User user = null;

        try {
            user = UserDaoImpl.getInstance().getUserByLogin(userLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return !userLogin.equals(null);
    }

    private Boolean isLoginNotToShort(String userLogin) {

        if (userLogin.length() >= 4) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isPasswordNotToShort(String password) {

        if (password.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }

}
