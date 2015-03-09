import java.util.ArrayList;

public class Route {

    /** Number route */
    private int number;
    /** Lenght route */
    private double length;
    /** The number of buses on the route */
    private int minAmountBus;

    private int statusAmountBus;

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

    public int getNumber() {
        return number;
    }

    public double getLength() {
        return length;
    }

    public int getMinAmountBus() {
        return minAmountBus;
    }

    public void viewRoute() {
        System.out.println("Number route: " + number + "| Lenght route: " + length + "| Number of buses on the route: " + minAmountBus);
    }

    public int getStatusAmountBus() {
        statusAmountBus = busThisRoute.size();
        return statusAmountBus;
    }

    public void addBusRoute(Bus bus) {
        this.busThisRoute.add(bus);
    }

    public ArrayList<Bus> getBusThisRoute() {
        return busThisRoute;
    }

    public void adequacyBusesOnRoute() {
        getStatusAmountBus();
        System.out.println("The number of buses on the route: " + statusAmountBus);
        if (statusAmountBus < minAmountBus) {
            System.out.println("Coach is not enough");
        }
        else System.out.println("Coach enough");
    }
}
