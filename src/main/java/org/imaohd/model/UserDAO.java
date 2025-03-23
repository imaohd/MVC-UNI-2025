package org.imaohd.model;

import java.util.List;

interface UserDAO {

    boolean create(User user);

    User findById(int id);

    List<User> findAll();

    boolean update(User user);

    boolean delete(int id);

}
