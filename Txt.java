import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Txt {
    private Scanner in;
    private int numberRoute;
    private double lengthRoute;
    private int amountBusRoute;

    public Txt() throws FileNotFoundException {
        in = new Scanner(new File("src/FileRoute"));
    }

    public void readFromFile(ArrayList<Route> listRoute, Txt txt) throws Exception {
        while (in.hasNext()) {
            numberRoute = in.nextInt();
            lengthRoute = in.nextDouble();
            amountBusRoute = in.nextInt();
            Route route = new Route(txt);
            listRoute.add(route);
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
}
