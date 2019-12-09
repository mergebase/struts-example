package org.apache.struts2.showcase.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.showcase.application.Storage;
import org.apache.struts2.showcase.exception.CreateException;
import org.apache.struts2.showcase.exception.StorageException;
import org.apache.struts2.showcase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao extends AbstractDao {

    @Autowired
    private Storage storage;

    private static final Logger log = LogManager.getLogger(LoginDao.class);


    public Class getFeaturedClass() {
        return User.class;
    }

    public User getByUsernameAndPassword(String user, String pass)
    {
        User inStorageUser = (User) get(user);

        if(inStorageUser != null) {
            if (pass.equals(inStorageUser.getPassword())) {
                return inStorageUser;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void addUser(User user) {

        try {
            merge(user);
        } catch (StorageException exception) {
            log.error("Unable to create user " + user.getUsername());
        }
    }

    public void addUser(String user, String pass) {
        User newUser = new User(user, pass);
        addUser(newUser);
    }
}
