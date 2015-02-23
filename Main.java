import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Route> listRoute = new ArrayList<Route>();
        ArrayList<Bus> listBus = new ArrayList<Bus>();
        ArrayList<Bus> listBusInPark = new ArrayList<Bus>();
        ArrayList<Bus> listBusOnRoute = new ArrayList<Bus>();
    }

    public static void addListBus(ArrayList<Bus> listBus) {
        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);
        System.out.println("Введите номер автобуса");
        int numberBus = in.nextInt();
        System.out.println("Введите расход автобуса");
        double consumptionGasoline = in.nextDouble();
        System.out.println("Введите фамилию имя водителя");
        String nameSurname = in.nextLine();
        System.out.println("Введите имя маршрута");
        int numberRoute = in.nextInt();
        Bus bus = new Bus(numberBus,consumptionGasoline,nameSurname,numberRoute);
        listBus.add(bus);
    }
    public static void addListRoute(ArrayList<Route> listRote) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер маршрута");
        int number = in.nextInt();
        System.out.println("Введите длину маршрута");
        double length = in.nextDouble();
        System.out.println("Введите необходимое количество автобусов для этого маршрута");
        int amountBus = in.nextInt();
        Route route = new Route(number, length, amountBus);
        listRote.add(route);
    }
}
