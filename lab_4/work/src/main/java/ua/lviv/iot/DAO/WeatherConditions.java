package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class WeatherConditions {


    private static final String FIND_ALL =
            "SELECT * FROM `mydb`.`weather_conditions`";
    private static final String FIND_BY_ID =
            "SELECT * FROM `mydb`.`weather_conditions` WHERE id=?";
    private static final String CREATE =
            "INSERT INTO `mydb`.`weather_conditions` (id, temparature," +
                    "huminity, wind_direction, wind_speed, water_temp, date," +
                    "hour, day_of_week_id, pictures_id, cloud_state_id," +
                    "city_id, city_country_id, catastrophy_warning_id)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE `mydb`.`weather_conditions` SET temparature=?" +
                    ", huminity=?, wind_direction=?, wind_speed=?" +
                    ", water_temp=?, date=?, hour=?" +
                    ", day_of_week_id=?, pictures_id=?, cloud_state_id=?" +
                    ", city_id=?, city_country_id=?, catastrophy_warning_id=?" +
                    " WHERE id=?";
    private static final String DELETE =
            "DELETE FROM `mydb`.`weather_conditions` WHERE id=?";

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
        try (PreparedStatement pStat = connection
                .prepareStatement(FIND_BY_ID)) {

            pStat.setInt(1, id);

            try (ResultSet resultSet = pStat.executeQuery()) {

                print(resultSet);
            }
        }
    }

    public void create(Integer id, Integer temparature, Integer huminity,
                       String windDirection, String windSpeed,
                       Integer waterTemp, String date,
                       Integer hour, Integer dayOfWeekId,
                       Integer picturesId, Integer cloudStateId,
                       Integer cityId, Integer cityCountryId,
                       Integer catastrophyWarningId) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(CREATE)) {

            pStat.setInt(1, id);
            pStat.setInt(2, temparature);
            pStat.setInt(3, huminity);
            pStat.setString(4, windDirection);
            pStat.setString(5, windSpeed);
            pStat.setInt(6, waterTemp);
            pStat.setString(7, date);
            pStat.setInt(8, hour);
            pStat.setInt(9, dayOfWeekId);
            pStat.setInt(10, picturesId);
            pStat.setInt(11, cloudStateId);
            pStat.setInt(12, cityId);
            pStat.setInt(13, cityCountryId);
            pStat.setInt(14, catastrophyWarningId);

            pStat.executeUpdate();


        }
    }

    public void update(Integer id, Integer temparature, Integer huminity,
                       String windDirection, String windSpeed,
                       Integer waterTemp, String date,
                       Integer hour, Integer dayOfWeekId,
                       Integer picturesId, Integer cloudStateId,
                       Integer cityId, Integer cityCountryId,
                       Integer catastrophyWarningId) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pStat = connection.prepareStatement(UPDATE)) {

            pStat.setInt(1, id);
            pStat.setInt(2, temparature);
            pStat.setInt(3, huminity);
            pStat.setString(4, windDirection);
            pStat.setString(5, windSpeed);
            pStat.setInt(6, waterTemp);
            pStat.setString(7, date);
            pStat.setInt(8, hour);
            pStat.setInt(9, dayOfWeekId);
            pStat.setInt(10, picturesId);
            pStat.setInt(11, cloudStateId);
            pStat.setInt(12, cityId);
            pStat.setInt(13, cityCountryId);
            pStat.setInt(14, catastrophyWarningId);


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
            System.out.print(", temparature: " +
                    resultSet.getInt("temparature"));
            System.out.print(", huminity: " +
                    resultSet.getInt("huminity"));
            System.out.print(", wind_direction: " +
                    resultSet.getString("wind_direction"));
            System.out.print(", wind_speed: " +
                    resultSet.getString("wind_speed"));
            System.out.print(", water_temp: " +
                    resultSet.getInt("water_temp"));
            System.out.print(", date: " +
                    resultSet.getString("date"));
            System.out.print(", hour: " +
                    resultSet.getInt("hour"));
            System.out.print(", day_of_week_id: " +
                    resultSet.getInt("day_of_week_id"));
            System.out.print(", pictures_id: " +
                    resultSet.getInt("pictures_id"));
            System.out.print(", cloud_state_id: " +
                    resultSet.getInt("cloud_state_id"));
            System.out.print(", city_id: " +
                    resultSet.getInt("city_id"));
            System.out.print(", city_country_id: " +
                    resultSet.getInt("city_country_id"));
            System.out.print(", catastrophy_warning_id: " +
                    resultSet.getInt("catastrophy_warning_id"));

            System.out.println("}");
        }
    }
}
