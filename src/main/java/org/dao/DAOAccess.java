package org.dao;

import org.models.Question;
import org.models.User;

public interface DAOAccess {
    Question getQuestion(int id);
    void insertUser(User user);
}
