package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    final private String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        File file = new File(fileName);
        file.createNewFile();
    }

    @Override
    public void saveUser(User user) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        printWriter.write(user.toString() + "\n");

        printWriter.close();
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {

        for (User user: users
             ) {
            saveUser(user);
        }
    }

    @Override
    public List<User> getAllUsers() throws IOException {

        List<User> userList = new ArrayList<User>();


        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String oneLineFromFile = reader.readLine();

        while(oneLineFromFile != null) {
            if (oneLineFromFile != null) {
                userList.add(UserParser.StringToUser(oneLineFromFile));
            }
            oneLineFromFile = reader.readLine();
        }

        reader.close();
        return userList;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> userList = new ArrayList<User>();

        userList = getAllUsers();

        for (User user:userList) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> userList = new ArrayList<User>();

        userList = getAllUsers();

        for (User user:userList) {
            if (user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {

        List<User> userList = new ArrayList<User>();

        userList = getAllUsers();

        for (User user:userList) {
            if (user.getLogin().equals(login)){
                userList.remove(user);
                break;
            }
        }

        saveListToFile(userList);

    }

    @Override
    public void removeUserById(Long id) throws IOException {

        List<User> userList = new ArrayList<User>();

        userList = getAllUsers();

        for (User user:userList) {
            if (user.getId().equals(id)){
                userList.remove(user);
                break;
            }
        }

        saveListToFile(userList);
    }

    private void saveListToFile(List<User> listToSaveToFile) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileName);

        for (User user:listToSaveToFile) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();

    }

}
