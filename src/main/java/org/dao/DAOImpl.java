package org.dao;

import org.models.Question;
import org.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOImpl implements DAOAccess {
    @Override
    public Question getQuestion(int id) {
        Question question = null;
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement("SELECT * FROM QUESTIONS WHERE ID = :1")) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next())
                question = parseQuestion(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return question;
    }

    @Override
    public void insertUser(User user) {
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement("INSERT INTO USERS VALUES(:1, :2, :3)")) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getMaxTotalPoints());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Question parseQuestion(ResultSet rs) {
        Question question = null;

        try {
            int id = rs.getInt("ID");
            String quest = rs.getString("QUESTION");
            String answer = rs.getString("ANSWER");
            int points = rs.getInt("POINTS");
            question = new Question(id, quest, answer, points);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return question;
    }
}
