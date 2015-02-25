import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Route> listRoute = new ArrayList<Route>();
        ArrayList<Bus> listAllBus = new ArrayList<Bus>();
        ArrayList<Bus> listBusInPark = new ArrayList<Bus>();
        ArrayList<Bus> listBusOnRoute = new ArrayList<Bus>();

        Txt txt = new Txt();
        txt.readFromFile(listRoute,txt,listAllBus,listBusInPark);
        viewListRoute(listRoute);
        viewListAllBus(listAllBus);
        setStatusBusOnRoute(listBusInPark, listBusOnRoute);
        viewListBusInParK(listBusInPark);
        viewListBusOnRoute(listBusOnRoute);
        setStatusBusInPark(listBusInPark,listBusOnRoute);
        viewListBusInParK(listBusInPark);
        viewListBusOnRoute(listBusOnRoute);

    }

    public static void addListBus(ArrayList<Bus> listBus) {
        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);
        System.out.println("Введите номер автобуса");
        int numberBus = in.nextInt();
        System.out.println("Введите расход автобуса");
        double consumptionGasoline = in.nextDouble();
        System.out.println("Введите фамилию имя водителя");
        String nameSurname = on.nextLine();
        System.out.println("Введите номер маршрута");
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
    private static void viewListBus(ArrayList<Bus> listBus, String title) {
        System.out.println(title);
        for (int i = 0; i < listBus.size(); i++) {
            listBus.get(i).viewBus();
        }
    }

    public static void viewListAllBus(ArrayList<Bus> listBus) {
        viewListBus(listBus,"List all bus");
    }

    public static void viewListBusInParK(ArrayList<Bus> listBus) {
        viewListBus(listBus,"List bus in park");
    }
    public static void viewListBusOnRoute(ArrayList<Bus> listBus) {
        viewListBus(listBus,"List bus on route");
    }

    public static void viewListRoute(ArrayList<Route> listRoute) {
        System.out.println();
        System.out.println("List all route ");
        for (int i = 0; i < listRoute.size(); i++) {
            listRoute.get(i).viewRoute();
        }
    }

    public static void setStatusBusOnRoute(ArrayList<Bus> listBusInPark, ArrayList<Bus> listBusOnRoute) {
        System.out.println("Какой автобус отправить на маршрут ?");
        viewListBusInParK(listBusInPark);
        System.out.println("введите номер автобуса какой отправить: ");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        for(int i = 0; i < listBusInPark.size();i++) {
            if (listBusInPark.get(i).getNumberBus() == index) {
                listBusInPark.get(i).setStatusRoute();
                listBusOnRoute.add(listBusInPark.get(i));
                listBusInPark.remove(i);
                break;
            }
        }
    }

    public static void setStatusBusInPark(ArrayList<Bus> listBusInPark, ArrayList<Bus> listBusOnRoute) {
        System.out.println("Какой автобус отправить в парк ?");
        viewListBusOnRoute(listBusOnRoute);
        System.out.println("введите номер автобуса какой отправить: ");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        for(int i = 0; i < listBusOnRoute.size();i++) {
            if (listBusOnRoute.get(i).getNumberBus() == index) {
                listBusOnRoute.get(i).setStatusPark();
                listBusInPark.add(listBusOnRoute.get(i));
                listBusOnRoute.remove(i);
                break;
            }
        }
    }

}
