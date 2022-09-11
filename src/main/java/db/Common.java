package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Common {

    public static void main(String[] args) {
//            connection.setAutoCommit(false);
//            preparedStatement.executeUpdate();
//            preparedStatement.executeUpdate();
//            preparedStatement.executeUpdate();
//            connection.commit();
//            connection.rollback();

        try (Connection connection = ConnectionManager.getConnection()) {
            System.out.println("connect");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.first_name, a.last_name, mv.title from movies mv \n" +
                    "join artists_movies am on mv.id = am.movie_id \n" +
                    "JOIN artists a on a.id = am.artist_id \n" +
                    "WHERE a.FIRST_NAME like '%leo%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + " ");
                System.out.print(resultSet.getString("last_name") + " ");
                System.out.println(resultSet.getString("title"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
