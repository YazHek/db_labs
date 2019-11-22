package ua.lviv.iot.controller;

import java.sql.SQLException;

public interface Controller {

    void findAllCatastrophyWarning() throws SQLException;

    void findByIdCatastrophyWarning(Integer id) throws SQLException;

    void createCatastrophyWarning(Integer id, Integer catastrophyPictureId,
                                  Integer weatherConditionId)
            throws SQLException;

    void updateCatastrophyWarning(Integer id, Integer catastrophyPictureId,
                                  Integer weatherConditionId)
            throws SQLException;

    void deleteCatastrophyWarning(Integer id) throws SQLException;

    void findAllCity() throws SQLException;

    void findByIdCity(Integer id) throws SQLException;

    void createCity(Integer id, String cityName, Integer countryId)
            throws SQLException;

    void updateCity(Integer id, String cityName, Integer countryId)
            throws SQLException;

    void deleteCity(Integer id) throws SQLException;

    void findAllCloudState() throws SQLException;

    void findByIdCloudState(Integer id) throws SQLException;

    void createCloudState(Integer id, String name) throws SQLException;

    void updateCloudState(Integer id, String name) throws SQLException;

    void deleteCloudState(Integer id) throws SQLException;

    void findAllCountry() throws SQLException;

    void findByIdCountry(Integer id) throws SQLException;

    void createCountry(Integer id, String name,
                       Integer cityId, Integer cityCountryId)
            throws SQLException;

    void updateCountry(Integer id, String name,
                       Integer cityId, Integer cityCountryId)
            throws SQLException;

    void deleteCountry(Integer id) throws SQLException;

    void findAllDayOfWeek() throws SQLException;

    void findByIdDayOfWeek(Integer id) throws SQLException;

    void createDayOfWeek(Integer id, String name) throws SQLException;

    void updateDayOfWeek(Integer id, String name) throws SQLException;

    void deleteDayOfWeek(Integer id) throws SQLException;

    void findAllPictures() throws SQLException;

    void findByIdPictures(Integer id) throws SQLException;

    void createPictures(Integer id, String pictureName) throws SQLException;

    void updatePictures(Integer id, String pictureName) throws SQLException;

    void deletePictures(Integer id) throws SQLException;

    void findAllWeatherConditions() throws SQLException;

    void findByIdWeatherConditions(Integer id) throws SQLException;

    void createWeatherConditions(Integer id, Integer temparature,
                                 Integer huminity, String windDirection,
                                 String windSpeed, Integer waterTemp,
                                 String date, Integer hour, Integer dayOfWeekId,
                                 Integer picturesId, Integer cloudStateId,
                                 Integer cityId, Integer cityCountryId,
                                 Integer catastrophyWarningId)
            throws SQLException;

    void updateWeatherConditions(Integer id, Integer temparature,
                                 Integer huminity, String windDirection,
                                 String windSpeed, Integer waterTemp,
                                 String date, Integer hour, Integer dayOfWeekId,
                                 Integer picturesId, Integer cloudStateId,
                                 Integer cityId, Integer cityCountryId,
                                 Integer catastrophyWarningId)
            throws SQLException;

    void deleteWeatherConditions(Integer id) throws SQLException;


}
