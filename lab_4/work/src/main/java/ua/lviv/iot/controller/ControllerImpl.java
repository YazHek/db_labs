package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.CatastrophyWarning;
import ua.lviv.iot.DAO.City;
import ua.lviv.iot.DAO.CloudState;
import ua.lviv.iot.DAO.Country;
import ua.lviv.iot.DAO.DayOfWeek;
import ua.lviv.iot.DAO.Pictures;
import ua.lviv.iot.DAO.WeatherConditions;

import java.sql.SQLException;

public class ControllerImpl implements Controller {

    private static CatastrophyWarning catastrophyWarning;
    private static City city;
    private static CloudState cloudState;
    private static Country country;
    private static DayOfWeek dayOfWeek;
    private static Pictures pictures;
    private static WeatherConditions weatherConditions;

    public ControllerImpl() {

        catastrophyWarning = new CatastrophyWarning();
        city = new City();
        cloudState = new CloudState();
        country = new Country();
        dayOfWeek = new DayOfWeek();
        pictures = new Pictures();
        weatherConditions = new WeatherConditions();
    }

    @Override
    public void findAllCatastrophyWarning() throws SQLException {
        catastrophyWarning.findAll();

    }

    @Override
    public void findByIdCatastrophyWarning(Integer id) throws SQLException {
        catastrophyWarning.findById(id);

    }

    @Override
    public void createCatastrophyWarning(Integer id,
                                         Integer catastrophyPictureId,
                                         Integer weatherConditionId)
            throws SQLException {
        catastrophyWarning.create(id, catastrophyPictureId,
                weatherConditionId);

    }

    @Override
    public void updateCatastrophyWarning(Integer id,
                                         Integer catastrophyPictureId,
                                         Integer weatherConditionId)
            throws SQLException {
        catastrophyWarning.update(id, catastrophyPictureId,
                weatherConditionId);

    }

    @Override
    public void deleteCatastrophyWarning(Integer id) throws SQLException {
        catastrophyWarning.delete(id);

    }

    @Override
    public void findAllCity() throws SQLException {
        city.findAll();

    }

    @Override
    public void findByIdCity(Integer id) throws SQLException {
        city.findById(id);

    }

    @Override
    public void createCity(Integer id, String cityName, Integer countryId)
            throws SQLException {
        city.create(id, cityName, countryId);

    }

    @Override
    public void updateCity(Integer id, String cityName, Integer countryId)
            throws SQLException {
        city.update(id, cityName, countryId);

    }

    @Override
    public void deleteCity(Integer id) throws SQLException {
        city.delete(id);

    }

    @Override
    public void findAllCloudState() throws SQLException {
        cloudState.findAll();

    }

    @Override
    public void findByIdCloudState(Integer id) throws SQLException {
        cloudState.findById(id);

    }

    @Override
    public void createCloudState(Integer id, String name) throws SQLException {
        cloudState.create(id, name);

    }

    @Override
    public void updateCloudState(Integer id, String name) throws SQLException {
        cloudState.update(id, name);

    }

    @Override
    public void deleteCloudState(Integer id) throws SQLException {
        cloudState.delete(id);

    }

    @Override
    public void findAllCountry() throws SQLException {
        country.findAll();

    }

    @Override
    public void findByIdCountry(Integer id) throws SQLException {
        country.findById(id);

    }

    @Override
    public void createCountry(Integer id, String name, Integer cityId,
                              Integer cityCountryId) throws SQLException {
        country.create(id, name, cityId, cityCountryId);

    }

    @Override
    public void updateCountry(Integer id, String name, Integer cityId,
                              Integer cityCountryId) throws SQLException {
        country.create(id, name, cityId, cityCountryId);

    }

    @Override
    public void deleteCountry(Integer id) throws SQLException {
        country.delete(id);

    }

    @Override
    public void findAllDayOfWeek() throws SQLException {
        dayOfWeek.findAll();

    }

    @Override
    public void findByIdDayOfWeek(Integer id) throws SQLException {
        dayOfWeek.findById(id);

    }

    @Override
    public void createDayOfWeek(Integer id, String name) throws SQLException {
        dayOfWeek.create(id, name);

    }

    @Override
    public void updateDayOfWeek(Integer id, String name) throws SQLException {
        dayOfWeek.update(id, name);

    }

    @Override
    public void deleteDayOfWeek(Integer id) throws SQLException {
        dayOfWeek.delete(id);

    }

    @Override
    public void findAllPictures() throws SQLException {
        pictures.findAll();

    }

    @Override
    public void findByIdPictures(Integer id) throws SQLException {
        pictures.findById(id);

    }

    @Override
    public void createPictures(Integer id, String pictureName)
            throws SQLException {
        pictures.create(id, pictureName);

    }

    @Override
    public void updatePictures(Integer id, String pictureName)
            throws SQLException {
        pictures.update(id, pictureName);

    }

    @Override
    public void deletePictures(Integer id) throws SQLException {
        pictures.delete(id);

    }

    @Override
    public void findAllWeatherConditions() throws SQLException {
        weatherConditions.findAll();

    }

    @Override
    public void findByIdWeatherConditions(Integer id) throws SQLException {
        weatherConditions.findById(id);

    }

    @Override
    public void createWeatherConditions(Integer id, Integer temparature,
                                        Integer huminity, String windDirection,
                                        String windSpeed, Integer waterTemp,
                                        String date, Integer hour,
                                        Integer dayOfWeekId, Integer picturesId,
                                        Integer cloudStateId, Integer cityId,
                                        Integer cityCountryId,
                                        Integer catastrophyWarningId)
            throws SQLException {
        weatherConditions.create(id, temparature, huminity, windDirection,
                windSpeed, waterTemp, date, hour, dayOfWeekId, picturesId,
                cloudStateId, cityId, cityCountryId,
                catastrophyWarningId);

    }

    @Override
    public void updateWeatherConditions(Integer id, Integer temparature,
                                        Integer huminity, String windDirection,
                                        String windSpeed, Integer waterTemp,
                                        String date, Integer hour,
                                        Integer dayOfWeekId, Integer picturesId,
                                        Integer cloudStateId, Integer cityId,
                                        Integer cityCountryId,
                                        Integer catastrophyWarningId)
            throws SQLException {
        weatherConditions.update(id, temparature, huminity, windDirection,
                windSpeed, waterTemp, date, hour, dayOfWeekId, picturesId,
                cloudStateId, cityId, cityCountryId,
                catastrophyWarningId);
    }

    @Override
    public void deleteWeatherConditions(Integer id) throws SQLException {
        weatherConditions.delete(id);

    }
}
