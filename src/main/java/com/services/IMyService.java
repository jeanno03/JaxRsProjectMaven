package com.services;

import com.beans.User;

import java.util.List;

public interface IMyService {

    User getPersistUser();
    List<User> getPersistUsers();
    User getUpdateUser(int id, String name);
    User getRemoveUser(int id);
}
