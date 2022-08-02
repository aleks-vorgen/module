package org.controllers;

import org.dao.DAOAccess;
import org.dao.OracleFactory;
import org.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView showQuestion(@ModelAttribute User user) {
        DAOAccess dao = new OracleFactory().getDAO();
        dao.insertUser(user);
        return new ModelAndView("showQuestion", "question", new QuestionController().viewQuestion());
    }
}
