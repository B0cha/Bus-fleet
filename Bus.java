import java.util.ArrayList;

public class Bus {
    /** Number bus */
    private int numberBus;
    /** Gasoline consumption in liters per kilometer */
    private double consumptionGasoline;
    /** name and surname of the driver */
    private String nameSurname;
    /** Number route */
    private int numberRoute;

    private String status = "В парке";

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

    public void viewBus() {
        System.out.println("Number bus: " + numberBus + " | Gasoline consumption: " + consumptionGasoline + " | Name Surname: " + nameSurname + " | Number route: " + numberRoute);
    }

    public void setStatusPark () {
        this.status = "В парке";
    }
    public void setStatusRoute () {
        this.status = "На маршруте";
    }

}
