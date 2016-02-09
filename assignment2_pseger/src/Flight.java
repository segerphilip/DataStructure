import javax.print.attribute.standard.OrientationRequested;
import java.util.Scanner;

/**
 * Created by philip on 2/9/16.
 */

public class Flight {
    private String airline;
    private int flightNum;
    private String origin;
    private String destination;

    public Flight(String airline, int flightNum, String origin, String destination) {
        this.airline = airline;
        this.flightNum = flightNum;
        this.origin = origin;
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Flight readFlight() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input flight information:");
        System.out.print("Airline: ");
        airline = scan.nextLine();
        System.out.print("Flight Number: ");
        flightNum = scan.nextInt();
        System.out.print("Origin: ");
        origin = scan.nextLine();
        System.out.print("Destination: ");
        destination = scan.nextLine();

        Flight fln = new Flight(airline, flightNum, origin, destination);
        return fln;
    }

    public static boolean stopOver(Flight fl1, Flight fl2) {
        if (fl1.getDestination() == fl2.getOrigin() || fl1.getOrigin() == fl2.getDestination())
            return true;
        else
            return false;
    }

    public String toString() {
        String info = airline + " flight " + flightNum + ", departing from " + origin +
                " and arriving in " + destination + ".";
        return info;
    }

    public static void main(String[] args) {
        Flight fl1 = new Flight("Alaska Airlines", 9, "Portland", "Boston");
        Flight fl2 = new Flight("Alaska Airlines", 13, "Boston", "Amsterdam");
        System.out.println(stopOver(fl1, fl2));
    }
}
