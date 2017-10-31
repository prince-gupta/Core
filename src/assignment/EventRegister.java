package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by prashant on 18/6/17.
 */
public class EventRegister {
    static Map<String, Map<Date, String>> eventMap = new HashMap();

    public static void main(String[] args) {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("*******Menu*********");
            System.out.println("1. Add Event");
            System.out.println("2. View Events by City");
            System.out.println("3. View Event by Date");
            System.out.println("Press 'n/N' to exit..");
            System.out.println("Enter you choice: ");
            String decision = input.nextLine().toLowerCase();
            switch (decision) {
                case "1":
                    String cityName = acceptInput("Enter City Name: ");
                    String eventName = acceptInput("Enter Event Name: ");
                    Date eventDate = acceptDate();
                    addEvent(cityName, eventDate, eventName);
                    break;
                case "2":
                    cityName = acceptInput("Enter City Name: ");
                    viewEvent(cityName);
                    break;
                case "3":
                    cityName = acceptInput("Enter City Name: ");
                    viewEventByDate(cityName);
                    break;
                case "n":
                    System.exit(0);
            }
        }
    }

    private static String acceptInput(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    }

    private static Date acceptDate() {
        Date eventDate = new Date();
        String eDate = acceptInput("Please Enter eventDate in dd/mm/yyyy format");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            eventDate = dateFormat.parse(eDate);
        } catch (ParseException e) {
            System.out.println("Oops DateFormat does not matched!");
            acceptDate();
        }
        return eventDate;
    }


    private static void addEvent(String cityName, Date eventDate, String eventName) {
        System.out.println("Adding Event:  " + eventName + " in the City: " + cityName + " on " + eventDate);
        if (isEventPresent(cityName)) {
            Map<Date, String> event = eventMap.get(cityName);
            if(event.containsKey(eventDate)){
                System.out.println("Event " + event.get(eventDate) + " is replaced with " + eventName);
            }
            eventMap.get(cityName).put(eventDate, eventName);
        } else {
            Map<Date, String> tempMap = new HashMap<>();
            tempMap.put(eventDate, eventName);
            eventMap.put(cityName, tempMap);
        }

    }

    private static void viewEvent(String cityName) {
        if (isEventPresent(cityName)) {
            System.out.println("Events in : " + cityName);
            eventMap.get(cityName).entrySet()
                    .stream()
                    .forEach(event ->
                        System.out.println("Event: " + event.getValue() + "\n" + "Date: " + event.getKey()));
        } else {
            System.out.println("No events found in the city: " + cityName);
        }
    }

    private static void viewEventByDate(String cityName) {
        Date eventDate = acceptDate();
        if (isEventPresent(cityName)) {
            Map<Date, String> events = eventMap.get(cityName);
            if (events.containsKey(eventDate)) {
                System.out.println("Event in : " + cityName);
                System.out.println("Event: " + events.get(eventDate) + "\n" + "Date: " + eventDate);
            }else {
                System.out.println("No event found in the city: " + cityName + " on " + eventDate);
            }
        }else{
            System.out.println("No event found in the city: " + cityName);
        }

    }

    private static boolean isEventPresent(String cityName) {
        return eventMap.containsKey(cityName);
    }

}
