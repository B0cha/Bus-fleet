import java.util.ArrayList;

public class Route {

    /** Number route */
    private int number;
    /** Length route */
    private double length;
    /** The minimum number of buses on the route */
    private int minAmountBus;
    /** The number of buses on the route */
    private int statusAmountBus;
    /** List of buses on the route */
    private ArrayList<Bus> busThisRoute = new ArrayList<Bus>();

    public Route(int number, double length, int amountBus) {
        this.number = number;
        this.length = length;
        this.minAmountBus = amountBus;
    }

    public Route(Txt txt) throws Exception {
        this.number = txt.getNumberRoute();
        this.length = txt.getLengthRoute();
        this.minAmountBus = txt.getAmountBusRoute();
    }
    /** Get number route */
    public int getNumber() {
        return number;
    }
    /** Get length route */
    public double getLength() {
        return length;
    }
    /** Get minimum amount of buses on the route */
    public int getMinAmountBus() {
        return minAmountBus;
    }
    /** View route data */
    public void viewRoute() {
        System.out.println("Number route: " + number + "| Lenght route: " + length + "| Number of buses on the route: " + minAmountBus);
    }
    /** get the number of buses on the route */
    public int getStatusAmountBus() {
        statusAmountBus = busThisRoute.size();
        return statusAmountBus;
    }
    /** Adding to the list of bus route */
    public void addBusRoute(Bus bus) {
        this.busThisRoute.add(bus);
    }
    /** Gey list of buses on the route */
    public ArrayList<Bus> getBusThisRoute() {
        return busThisRoute;
    }
    /** Checking the adequacy of bus route */
    public void adequacyBusesOnRoute() {
        getStatusAmountBus();
        System.out.println("The number of buses on the route: " + statusAmountBus);
        if (statusAmountBus < minAmountBus) {
            System.out.println("Coach is not enough");
        }
        else System.out.println("Coach enough");
    }
}
