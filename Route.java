public class Route {

    /** Number route */
    private int number;
    /** Lenght route */
    private double length;
    /** The number of buses on the route */
    private int amountBus;

    public Route(int number, double length, int amountBus) {
        this.number = number;
        this.length = length;
        this.amountBus = amountBus;
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
}
