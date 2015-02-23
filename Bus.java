public class Bus {
    /** Number bus */
    private int numberBus;
    /** Gasoline consumption in liters per kilometer */
    private double consumptionGasoline;
    /** name and surname of the driver */
    private String nameSurname;
    /** Number route */
    private int numberRoute;

    public Bus(int numberBus, double consumptionGasoline, String nameSurname, int numberRoute) {
        this.numberBus = numberBus;
        this.consumptionGasoline = consumptionGasoline;
        this.nameSurname = nameSurname;
        this.numberRoute = numberRoute;
    }

    public int getNumberBus() {
        return numberBus;
    }

    public double getConsumptionGasoline() {
        return consumptionGasoline;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public int getNumberRoute() {
        return numberRoute;
    }
}
