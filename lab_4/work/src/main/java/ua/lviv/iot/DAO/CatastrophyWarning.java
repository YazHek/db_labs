package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class CatastrophyWarning {


    private static final String FIND_ALL =
            "SELECT * FROM `mydb`.`catastrophy_warning`";
    private static final String FIND_BY_ID =
            "SELECT * FROM `mydb`.`catastrophy_warning` WHERE id=?";
    private static final String CREATE =
            "INSERT INTO `mydb`.`catastrophy_warning` (id," +
                    " catastrophy_picture_id, weather_condition_id)"
                    + " VALUES (?,?,?)";
    private static final String UPDATE =
            "UPDATE `mydb`.`catastrophy_warning` SET catastrophy_picture_id=?,"
                    + " weather_condition_id=? WHERE id=?";
    private static final String DELETE =
            "DELETE FROM `mydb`.`catastrophy_warning` WHERE id=?";


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

    public void create(Integer id, Integer catastrophyPictureId,
                       Integer weatherConditionId) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(CREATE)) {

            pStat.setInt(1, id);
            pStat.setInt(2, catastrophyPictureId);
            pStat.setInt(3, weatherConditionId);

            pStat.executeUpdate();


        }
    }

    public void update(Integer id, Integer catastrophyPictureId,
                       Integer weatherConditionId) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(UPDATE)) {

            pStat.setInt(1, id);
            pStat.setInt(2, catastrophyPictureId);
            pStat.setInt(3, weatherConditionId);

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
            System.out.print(", catastrophy_picture_id: " + resultSet.getInt(
                    "catastrophy_picture_id"));
            System.out.print(", weather_condition_id: " + resultSet.getInt(
                    "weather_condition_id"));
            System.out.println("}");
        }
    }

}
