import java.util.ArrayList;

public class Route {

    /** Number route */
    private int number;
    /** Lenght route */
    private double length;
    /** The number of buses on the route */
    private int amountBus;

    private int statusAmountBus;

    private ArrayList<Bus> busThisRoute = new ArrayList<Bus>();

    public Route(int number, double length, int amountBus) {
        this.number = number;
        this.length = length;
        this.amountBus = amountBus;
    }

    public Route(Txt txt) throws Exception {
        this.number = txt.getNumberRoute();
        this.length = txt.getLengthRoute();
        this.amountBus = txt.getAmountBusRoute();
    }

    public int getNumber() {
        return number;
    }

    public double getLength() {
        return length;
    }

    public int getAmountBus() {
        return amountBus;
    }

    public void viewRoute() {
        System.out.println("Number route: " + number + "| Lenght route: " + length + "| Number of buses on the route: " + amountBus);
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
}
