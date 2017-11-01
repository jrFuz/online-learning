package ro.onlinelearning.webservice.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.onlinelearning.webservice.commons.User;
import ro.onlinelearning.webservice.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsersRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersRepository.class);


    public static boolean registerUser(User user) {
        Connection c = DBConnection.getConnection();

        try {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO users(first_name, last_name, email_address, phone_number, city, password, last_login, register_date, admin)" +
                    "VALUES (?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0)");
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmailAddress());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getCity());

            stmt.executeUpdate();
            LOGGER.info("User created successfully");
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

        }
        return false;


    }
}
