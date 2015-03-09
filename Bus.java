public class Bus {
    /** Number bus */
    private int numberBus;
    /** Gasoline consumption in liters per kilometer */
    private double consumptionGasoline;
    /** name and surname of the driver */
    private String nameSurname;
    /** Number route */
    private int numberRoute;
    /** Location bus */
    private String status = "In the park";

    public Bus(int numberBus, double consumptionGasoline, String nameSurname, int numberRoute) {
        this.numberBus = numberBus;
        this.consumptionGasoline = consumptionGasoline;
        this.nameSurname = nameSurname;
        this.numberRoute = numberRoute;
    }

    public Bus(Txt txt) {
        this.numberBus = txt.getNumberBus();
        this.consumptionGasoline = txt.getConsumptionGasoline();
        this.nameSurname = txt.getNameSurname();
        this.numberRoute = txt.getNumberBusRoute();
    }
    /** Get number bus */
    public int getNumberBus() {
        return numberBus;
    }
    /** Get gasoline consumption */
    public double getConsumptionGasoline() {
        return consumptionGasoline;
    }
    /** Get Name and surname drivers bus */
    public String getNameSurname() {
        return nameSurname;
    }
    /** Get number route */
    public int getNumberRoute() {
        return numberRoute;
    }
    /** View bus his data */
    public void viewBus() {
        System.out.println("Number bus: " + numberBus + " | Gasoline consumption: " + consumptionGasoline + " | Name Surname: " + nameSurname + " | Number route: " + numberRoute);
    }
    /** Change the location of the bus on in the park */
    public void setStatusPark () {
        this.status = "In the park";
    }
    /** Change the location of the bus on the route */
    public void setStatusRoute () {
        this.status = "On the route";
    }
}
