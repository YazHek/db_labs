package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Pictures {

    private static final String FIND_ALL = "SELECT * FROM `mydb`.`pictures`";
    private static final String FIND_BY_ID =
            "SELECT * FROM `mydb`.`pictures` WHERE id=?";
    private static final String CREATE =
            "INSERT INTO `mydb`.`pictures` (id, picture_name)"
                    + " VALUES (?,?)";
    private static final String UPDATE =
            "UPDATE `mydb`.`pictures` SET picture_name=? WHERE id=?";
    private static final String DELETE =
            "DELETE FROM `mydb`.`pictures` WHERE id=?";


    public void findAll() throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {

                print(resultSet);

            }
        }
    }

    public void findById(Integer id) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat =
                     connection.prepareStatement(FIND_BY_ID)) {

            pStat.setInt(1, id);
            try (ResultSet resultSet = pStat.executeQuery()) {

                print(resultSet);
            }
        }
    }

    public void create(Integer id, String pictureName) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(CREATE)) {

            pStat.setInt(1, id);
            pStat.setString(2, pictureName);

            pStat.executeUpdate();


        }
    }

    public void update(Integer id, String pictureName) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(UPDATE)) {

            pStat.setString(1, pictureName);
            pStat.setInt(2, id);

            pStat.executeUpdate();

        }
    }

    public void delete(Integer id) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(DELETE)) {

            pStat.setInt(1, id);

            pStat.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{id: " + resultSet.getInt("id"));
            System.out.print(", picture_name: " +
                    resultSet.getString("picture_name"));
            System.out.println("}");
        }
    }
}
