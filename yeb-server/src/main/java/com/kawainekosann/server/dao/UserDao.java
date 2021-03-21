package com.kawainekosann.server.dao;

import com.kawainekosann.server.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserByMsg(User user);
}
