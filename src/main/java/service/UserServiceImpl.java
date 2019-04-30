package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDaoImpl userDao = null;
    private UserValidator userValidator = null;
    private static UserServiceImpl instance = null;

    public static UserServiceImpl getInstance() {
        if (instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();
        userValidator = UserValidator.getInstance();
    }

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public void addUser(User user) throws FileNotFoundException, UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException {
        if (userValidator.isValidate(user)){
            userDao.saveUser(user);
        }
    }

    public void removeUserById(Long userId) throws IOException {

        userDao.removeUserById(userId);

    }
}
