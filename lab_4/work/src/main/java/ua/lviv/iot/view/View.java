package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.controller.ControllerImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private static Controller controller;
    private static String buttonMenu =
            "\n\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n" +
                    "\t4 - Update\n\t5 - Delete\n\t0 - Go back\n";

    public View() {

        controller = new ControllerImpl();
    }

    public void showMenu() throws SQLException {

        String breakPoint;

        do {
            System.out.print("Press Any key to continue..");
            new Scanner(System.in).nextLine();

            outputMenu();
            System.out.print("\nPlease, select menu point: ");
            breakPoint = new Scanner(System.in).nextLine().toUpperCase();

            switch (breakPoint) {

                case "1":
                    workWithCatastrophyWarning();
                    break;
                case "2":
                    workWithCity();
                    break;
                case "3":
                    workWithCloudState();
                    break;
                case "4":
                    workWithCountry();
                    break;
                case "5":
                    workWithDayOfWeek();
                    break;
                case "6":
                    workWithPictures();
                    break;
                case "7":
                    workWithWeatherConditions();
                    break;
                case "0":
                    System.out.println("\n\nDone!");
                    break;
                default:
                    System.out.println("Menu point does not exist!");
            }
        } while (!breakPoint.equals("0"));

    }

    private void outputMenu() {
        System.out.println("\t\tMenu");
        System.out.println("(Choose Table to work with:)");
        System.out.print("\t1 - CatastrophyWarning\n" + "\t2 - City\n" +
                "\t3 - CloudState\n" + "\t4 - Country\n" + "\t5 - DayOfWeek\n" +
                "\t6 - Pictures\n" + "\t7 - WeatherConditions\n"
                + "\t0 - Exit\n");
    }

    private void workWithCatastrophyWarning() throws SQLException {
        System.out.print("\tTable 'CatastrophyWarning'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllCatastrophyWarning();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdCatastrophyWarning(
                        new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter catastrophy_picture_id: ");
                Integer catastrophyPictureId =
                        new Scanner(System.in).nextInt();
                System.out.print("Enter weather_condition_id: ");
                Integer weatherConditionId = new Scanner(System.in).nextInt();
                controller.createCatastrophyWarning(
                        id, catastrophyPictureId, weatherConditionId);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter catastrophy_picture_id: ");
                catastrophyPictureId = new Scanner(System.in).nextInt();
                System.out.print("Enter weather_condition_id: ");
                weatherConditionId = new Scanner(System.in).nextInt();
                controller.updateCatastrophyWarning(
                        id, catastrophyPictureId, weatherConditionId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCatastrophyWarning(
                        new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithCity() throws SQLException {

        System.out.print("\tTable 'City'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllCity();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdCity(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter cityName: ");
                String cityName = new Scanner(System.in).nextLine();
                System.out.print("Enter weather_condition_id: ");
                Integer countryId = new Scanner(System.in).nextInt();
                controller.createCity(id, cityName, countryId);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter cityName: ");
                cityName = new Scanner(System.in).nextLine();
                System.out.print("Enter weather_condition_id: ");
                countryId = new Scanner(System.in).nextInt();
                controller.updateCity(id, cityName, countryId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCity(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithCloudState() throws SQLException {

        System.out.print("\tTable 'CloudState'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllCloudState();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdCloudState(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                controller.createCloudState(id, name);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                name = new Scanner(System.in).nextLine();
                controller.updateCloudState(id, name);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCloudState(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithCountry() throws SQLException {

        System.out.print("\tTable 'Country'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllCountry();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdCountry(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter cityId: ");
                Integer cityId = new Scanner(System.in).nextInt();
                System.out.print("Enter cityCountryId: ");
                Integer cityCountryId = new Scanner(System.in).nextInt();
                controller.createCountry(id, name, cityId, cityCountryId);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                name = new Scanner(System.in).nextLine();
                System.out.print("Enter cityId: ");
                cityId = new Scanner(System.in).nextInt();
                System.out.print("Enter cityCountryId: ");
                cityCountryId = new Scanner(System.in).nextInt();
                controller.updateCountry(id, name, cityId, cityCountryId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCountry(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithDayOfWeek() throws SQLException {

        System.out.print("\tTable 'DayOfWeek'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllDayOfWeek();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdDayOfWeek(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                controller.createDayOfWeek(id, name);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                name = new Scanner(System.in).nextLine();
                controller.updateDayOfWeek(id, name);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteDayOfWeek(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithPictures() throws SQLException {

        System.out.print("\tTable 'Pictures'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllPictures();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdPictures(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String pictureName = new Scanner(System.in).nextLine();
                controller.createPictures(id, pictureName);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                pictureName = new Scanner(System.in).nextLine();
                controller.updatePictures(id, pictureName);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deletePictures(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithWeatherConditions() throws SQLException {

        System.out.print("\tTable 'WeatherConditions'");
        System.out.print(buttonMenu);
        System.out.print("Select button: ");

        switch (new Scanner(System.in).nextLine().toUpperCase()) {

            case "1":
                controller.findAllWeatherConditions();
                break;
            case "2":
                System.out.print("Enter Id: ");
                controller.findByIdWeatherConditions(
                        new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter tempature: ");
                Integer tempature = new Scanner(System.in).nextInt();
                System.out.print("Enter huminity: ");
                Integer huminity = new Scanner(System.in).nextInt();
                System.out.print("Enter wind_direction: ");
                String windDirection = new Scanner(System.in).nextLine();
                System.out.print("Enter wind_speed: ");
                String windSpeed = new Scanner(System.in).nextLine();
                System.out.print("Enter water_temp: ");
                Integer waterTemp = new Scanner(System.in).nextInt();
                System.out.print("Enter date: ");
                String date = new Scanner(System.in).nextLine();
                System.out.print("Enter hour: ");
                Integer hour = new Scanner(System.in).nextInt();
                System.out.print("Enter day_of_week_id: ");
                Integer dayOfWeekId = new Scanner(System.in).nextInt();
                System.out.print("Enter pictures_id: ");
                Integer picturesId = new Scanner(System.in).nextInt();
                System.out.print("Enter cloud_state_id: ");
                Integer cloudStateId = new Scanner(System.in).nextInt();
                System.out.print("Enter city_id: ");
                Integer cityId = new Scanner(System.in).nextInt();
                System.out.print("Enter city_country_id: ");
                Integer cityCountryId = new Scanner(System.in).nextInt();
                System.out.print("Enter catastrophy_warning_id: ");
                Integer catastrophyWarningId = new Scanner(
                        System.in).nextInt();
                controller.createWeatherConditions(id, tempature, huminity,
                        windDirection, windSpeed, waterTemp, date, hour,
                        dayOfWeekId, picturesId, cloudStateId, cityId,
                        cityCountryId, catastrophyWarningId);
                break;
            case "4":
                System.out.print("Enter Id: ");
                id = new Scanner(System.in).nextInt();
                System.out.print("Enter tempature: ");
                tempature = new Scanner(System.in).nextInt();
                System.out.print("Enter huminity: ");
                huminity = new Scanner(System.in).nextInt();
                System.out.print("Enter wind_direction: ");
                windDirection = new Scanner(System.in).nextLine();
                System.out.print("Enter wind_speed: ");
                windSpeed = new Scanner(System.in).nextLine();
                System.out.print("Enter water_temp: ");
                waterTemp = new Scanner(System.in).nextInt();
                System.out.print("Enter date: ");
                date = new Scanner(System.in).nextLine();
                System.out.print("Enter hour: ");
                hour = new Scanner(System.in).nextInt();
                System.out.print("Enter day_of_week_id: ");
                dayOfWeekId = new Scanner(System.in).nextInt();
                System.out.print("Enter pictures_id: ");
                picturesId = new Scanner(System.in).nextInt();
                System.out.print("Enter cloud_state_id: ");
                cloudStateId = new Scanner(System.in).nextInt();
                System.out.print("Enter city_id: ");
                cityId = new Scanner(System.in).nextInt();
                System.out.print("Enter city_country_id: ");
                cityCountryId = new Scanner(System.in).nextInt();
                System.out.print("Enter catastrophy_warning_id: ");
                catastrophyWarningId = new Scanner(
                        System.in).nextInt();
                controller.updateWeatherConditions(id, tempature, huminity,
                        windDirection, windSpeed, waterTemp, date, hour,
                        dayOfWeekId, picturesId, cloudStateId, cityId,
                        cityCountryId, catastrophyWarningId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteWeatherConditions(
                        new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }
}

