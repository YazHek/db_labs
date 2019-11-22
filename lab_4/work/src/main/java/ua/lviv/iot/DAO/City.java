package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class City {

    private static final String FIND_ALL = "SELECT * FROM `mydb`.`city`";
    private static final String FIND_BY_ID =
            "SELECT * FROM `mydb`.`city` WHERE id=?";
    private static final String CREATE =
            "INSERT INTO `mydb`.`city` (id, city_name, country_id)"
                    + " VALUES (?,?,?)";
    private static final String UPDATE =
            "UPDATE `mydb`.`city` SET city_name=?, country_id=? WHERE id=?";
    private static final String DELETE =
            "DELETE FROM `mydb`.`city` WHERE id=?";

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

    public void create(Integer id, String cityName, Integer countryId)
            throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(CREATE)) {

            pStat.setInt(1, id);
            pStat.setString(2, cityName);
            pStat.setInt(3, countryId);

            pStat.executeUpdate();


        }
    }

    public void update(Integer id, String cityName, Integer countryId)
            throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(UPDATE)) {

            pStat.setInt(1, id);
            pStat.setString(2, cityName);
            pStat.setInt(3, countryId);

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
            System.out.print(", country_id: " + resultSet
                    .getInt("country_id"));
            System.out.print(", city_name: " + resultSet
                    .getString("city_name"));
            System.out.println("}");
        }
    }
}
