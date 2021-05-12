package com.usps.usps.repositories;

import com.usps.usps.models.User;

import java.util.List;

public interface UserCustomRepository {
    public List<User> findUsersByProp(String pro);
}
