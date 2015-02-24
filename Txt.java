import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Txt {
    private Scanner in;
    private Scanner on;
    private int numberRoute;
    private double lengthRoute;
    private int amountBusRoute;
    private int numberBus;
    private double consumptionGasoline;
    private String nameSurname;
    private int numberBusRoute;

    public Txt() throws FileNotFoundException {
        in = new Scanner(new File("src/FileRoute"));
        on = new Scanner(new File("src/FileBus"));
        String trash = on.nextLine();
        trash = in.nextLine();
    }

    public void readFromFile(ArrayList<Route> listRoute, Txt txt, ArrayList<Bus> listBus) throws Exception {
        while (in.hasNext()) {
            numberRoute = in.nextInt();
            lengthRoute = in.nextDouble();
            amountBusRoute = in.nextInt();
            Route route = new Route(txt);
            listRoute.add(route);
        }
        while (on.hasNext()) {
            numberBus = on.nextInt();
            consumptionGasoline = on.nextDouble();
            numberBusRoute = on.nextInt();
            nameSurname = on.nextLine().trim();
            Bus bus = new Bus(txt);
            listBus.add(bus);
        }
    }

    public int getAmountBusRoute() {
        return amountBusRoute;
    }

    public double getLengthRoute() {
        return lengthRoute;
    }

    public int getNumberRoute() {
        return numberRoute;
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

    public int getNumberBusRoute() {
        return numberBusRoute;
    }
}
