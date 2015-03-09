import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Txt {
    /** Reading information from a file with routes */
    private Scanner in;
    /** Reading information from a file with bus */
    private Scanner on;
    /** Number route */
    private int numberRoute;
    /** length route */
    private double lengthRoute;
    /** Amount bus on the route */
    private int amountBusRoute;
    /** Number bus */
    private int numberBus;
    /** Gasoline consumption in liters per kilometer  */
    private double consumptionGasoline;
    /** Name and surname drivers bus */
    private String nameSurname;
    /** Number route bus */
    private int numberBusRoute;

    public Txt() throws FileNotFoundException {
        in = new Scanner(new File("src/FileRoute"));
        on = new Scanner(new File("src/FileBus"));
        String trash = on.nextLine();
        trash = in.nextLine();
    }
    /** Reading information buses and routes of two files */
    public void readFromFile(ArrayList<Route> listRoute, Txt txt, ArrayList<Bus> listBus, ArrayList<Bus> listBusInPark) throws Exception {
        while (in.hasNext()) {
            try {
                numberRoute = in.nextInt();
                lengthRoute = in.nextDouble();
                amountBusRoute = in.nextInt();
                Route route = new Route(txt);
                listRoute.add(route);
            } catch (Exception e) {
                System.out.println("No valid data file ");
                System.exit(0);
            }
        }
        while (on.hasNext()) {
            try {
                numberBus = on.nextInt();
                consumptionGasoline = on.nextDouble();
                numberBusRoute = on.nextInt();
                nameSurname = on.nextLine().trim();
                Bus bus = new Bus(txt);
                for (int i = 0; i < listRoute.size(); i++) {
                    if (listRoute.get(i).getNumber() == bus.getNumberRoute()) {
                        listRoute.get(i).addBusRoute(bus);
                        break;
                    }
                }
                listBus.add(bus);
                listBusInPark.add(bus);
            }catch (Exception e) {
                System.out.println(" No valid data file ");
                System.exit(0);
            }
        }
    }
    /** Get amount bus route */
    public int getAmountBusRoute() {
        return amountBusRoute;
    }
    /** Get length route */
    public double getLengthRoute() {
        return lengthRoute;
    }
    /** Get number route */
    public int getNumberRoute() {
        return numberRoute;
    }
    /** Get number bus */
    public int getNumberBus() {
        return numberBus;
    }
    /** Get consumption gasoline */
    public double getConsumptionGasoline() {
        return consumptionGasoline;
    }
    /** Get name and surname drivers bus */
    public String getNameSurname() {
        return nameSurname;
    }
    /** Get number bus route */
    public int getNumberBusRoute() {
        return numberBusRoute;
    }
}
