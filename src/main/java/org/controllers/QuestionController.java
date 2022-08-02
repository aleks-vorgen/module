package org.controllers;

import org.dao.DAOAccess;
import org.dao.OracleFactory;
import org.models.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {
    private Question question;

    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public ModelAndView viewQuestion() {
        DAOAccess dao = new OracleFactory().getDAO();
        question = dao.getQuestion((int) (Math.random() * 5));
        return new ModelAndView("showQuestion", "question", question);
    }
}
