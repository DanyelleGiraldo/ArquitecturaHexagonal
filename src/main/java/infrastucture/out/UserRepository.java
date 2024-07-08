package infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.entity.User;
import domain.service.UserService;
import infrastucture.config.DatabaseConfig;

public class UserRepository implements UserService{

    @Override
    public void createUser(User user) {
        String sql = "Insert into users (name, email) VALUES (?,?)";

        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.executeUpdate();
                try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        user.setId(generatedKeys.getLong(1));
                    }
                } 
            }catch(SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public User findUserById(Long id) {
        String sql = "SELECT id, name, email FROM users where id = ?";
        User user  = null;

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            try(ResultSet resultset = statement.executeQuery()){
                if(resultset.next()){
                    user = new User();
                    user.setId(resultset.getLong("id"));
                    user.setName(resultset.getString("name"));
                    user.setEmail(resultset.getString("email"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
