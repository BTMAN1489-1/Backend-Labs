package edu.phoenix.dao;

import edu.phoenix.NullArgumentException;
import edu.phoenix.model.User;

import java.util.*;

public class Database {
    public static List<User> dataBase = new ArrayList<>();

    public static void addUser(String name, String login, String password) {
        User user = getUser(login);
        try {
            if (login == null || password == null || user != null) {
                throw new NullArgumentException("login or password was null or user is exist");
            }
            dataBase.add(new User(name, login, password));
        } catch (NullArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    public static User getUser(String login) {
        for (User u : dataBase) {
            if ((Objects.equals(u.getLogin(), login))) {
                return u;
            }
        }
        return null;
    }

    public static void deleteUser(String login) {
        User u = getUser(login);
        try {
            if (u == null) {
                throw new NullArgumentException("User not found");
            }
            dataBase.remove(u);
        } catch (NullArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void updateUser(User user) {
        User u = getUser(user.getLogin());
        try {
            if (u == null) {
                throw new NullArgumentException("User not found");
            }
            int index = dataBase.indexOf(u);
            dataBase.set(index, user);
        } catch (NullArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}