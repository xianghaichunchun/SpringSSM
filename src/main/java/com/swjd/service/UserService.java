package com.swjd.service;

import com.swjd.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public abstract User login(User user);
}
