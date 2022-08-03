package db;

import db.entitys.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MovieStoreDao {
    private static MovieStoreDao INSTANCE;

    private MovieStoreDao() {
    }

    public static MovieStoreDao getInstance() {
        if (INSTANCE == null) {
            synchronized (MovieStoreDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieStoreDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Movie> getMovfieById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "SELECT id , title , release_date FROM movies WHERE id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("release_date")));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
