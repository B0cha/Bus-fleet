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

        int a = 0;
        while(a < 1) {
            Scanner put = new Scanner(System.in);
            menu();
            System.out.println("Enter the following command :");
            String out = put.nextLine();
            switch (out) {
                case "a":
                    setStatusBusOnRoute(listBusInPark, listBusOnRoute);
                    break;
                case "b":
                    setStatusBusInPark(listBusInPark, listBusOnRoute);
                    break;
                case "c":
                    System.out.println("Select list : \n" +
                            "1) Complete list of all buses\n" +
                            "2) List of buses in the park\n" +
                            "3) List of bus route\n" +
                            "4) List of routes");
                    int loko = put.nextInt();
                    switch (loko) {
                        case 1:
                            viewListAllBus(listAllBus);
                            break;
                        case 2:
                            viewListBusInParK(listBusInPark);
                            break;
                        case 3:
                            viewListBusOnRoute(listBusOnRoute);
                            break;
                        case 4:
                            viewListRoute(listRoute);
                            break;
                    }
                    break;
                case "d":
                    addListRoute(listRoute);
                    break;
                case "e":
                    addListBus(listAllBus,listBusInPark);
                    break;
                case "f":
                    minBusesOnRoute(listRoute);
                    break;
                case "g":
                    searchDriver(listAllBus);
                    break;
                case "h":
                    gasolineCostsOnRoute(listRoute);
                    break;
                case "quit":
                    a++;
                    break;
                default:
                    System.out.println("There is no such team retype");
            }
        }


    }

    public static void addListBus(ArrayList<Bus> listBus,ArrayList<Bus> listBusInPark) {
        try {
            Scanner in = new Scanner(System.in);
            Scanner on = new Scanner(System.in);
            System.out.println("Creating a bus ...");
            System.out.println("Enter the number of new bus ");
            int numberBus = in.nextInt();
            System.out.println("Enter the consumption of the bus");
            double consumptionGasoline = in.nextDouble();
            System.out.println("Enter the name of the name of the bus driver");
            String nameSurname = on.nextLine();
            System.out.println("Enter the number of the route");
            int numberRoute = in.nextInt();
            Bus bus = new Bus(numberBus, consumptionGasoline, nameSurname, numberRoute);
            listBus.add(bus);
            listBusInPark.add(bus);
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }
    }
    public static void addListRoute(ArrayList<Route> listRote) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Create a route ...");
            System.out.println("Enter the number of the route");
            int number = in.nextInt();
            System.out.println("Enter the length of the route");
            double length = in.nextDouble();
            System.out.println("Enter the required number of buses for this route");
            int amountBus = in.nextInt();
            Route route = new Route(number, length, amountBus);
            listRote.add(route);
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }
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
        System.out.println("Which bus to send the route ?");
        viewListBusInParK(listBusInPark);
        System.out.println("Enter the number of the bus which sent: ");
        Scanner in = new Scanner(System.in);
        int index = -1;
        try {
            index = in.nextInt();
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }
        for(int i = 0; i < listBusInPark.size();i++) {
            if (listBusInPark.get(i).getNumberBus() == index) {
                listBusInPark.get(i).setStatusRoute();
                listBusOnRoute.add(listBusInPark.get(i));
                listBusInPark.remove(i);
                System.out.println("Bus successfully sent !");
                break;
            }
        }
    }

    public static void setStatusBusInPark(ArrayList<Bus> listBusInPark, ArrayList<Bus> listBusOnRoute) {
        System.out.println("Which bus to go to the park ?");
        viewListBusOnRoute(listBusOnRoute);
        System.out.println("Enter the number of the bus which sent: ");
        Scanner in = new Scanner(System.in);
        int index = -1;
        try {
            index = in.nextInt();
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }

        for(int i = 0; i < listBusOnRoute.size();i++) {
            if (listBusOnRoute.get(i).getNumberBus() == index) {
                listBusOnRoute.get(i).setStatusPark();
                listBusInPark.add(listBusOnRoute.get(i));
                listBusOnRoute.remove(i);
                System.out.println("Bus successfully sent !");
                break;
            }
        }
    }

    public static void searchDriver(ArrayList<Bus> listAllBus){
        Scanner str = new Scanner(System.in);
        System.out.println("Enter last name of the driver you want to search ");
        String name = str.nextLine();
        for(int i = 0; i < listAllBus.size(); i++) {
            if (name.equals(listAllBus.get(i).getNameSurname())) {
                System.out.println("His bus number : " + listAllBus.get(i).getNumberBus());
                System.out.println("His route : " + listAllBus.get(i).getNumberRoute());
                return;
            }
            if (i == listAllBus.size()- 1) {
                System.out.println("There is no such driver");
            }
        }
    }

    public static void gasolineCostsOnRoute(ArrayList<Route> listRoute) {
        double sum = 0;
        double allSum = 0;
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the number of the route");
            int numberRoute = in.nextInt();
            for (int i = 0; i < listRoute.size(); i++) {
                for (int j = 0; j < listRoute.get(i).getBusThisRoute().size(); j++) {
                    allSum += (listRoute.get(i).getLength() / 100) * listRoute.get(i).getBusThisRoute().get(j).getConsumptionGasoline();
                    if (numberRoute == listRoute.get(i).getNumber()) {
                        sum += (listRoute.get(i).getLength() / 100) * listRoute.get(i).getBusThisRoute().get(j).getConsumptionGasoline();
                    }
                }
            }
            System.out.println("The total costs of petrol  " + allSum);
            System.out.println("The cost of gasoline on the route '" + numberRoute + "' = " + sum);
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }

    }

    public static void menu() {
        System.out.println();
        System.out.println("a) добавление автобуса из парка в список выехавших на маршрут\n" +
                "b) исключение автобуса из списка выехавших на маршрут и возвращение его в парк \n" +
                "c) просмотр содержимого любого списка\n" +
                "d) добавление маршрута\n" +
                "e) добавление автобуса\n" +
                ") достаточность автобусов на заданном маршруте\n" +
                "g) поиск по фамилии водителя соответствующего ему автобуса и маршрута \n" +
                "h) определение затрат бензина на всех маршрутах и отдельно для каждого.\n" +
                "quit) выход");
    }

    public static void minBusesOnRoute(ArrayList<Route> listRoute) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the number of the route you want to check");
            int numberRoute = in.nextInt();
            for (int i = 0; i < listRoute.size(); i++) {
                if (numberRoute == listRoute.get(i).getNumber()) {
                    listRoute.get(i).adequacyBusesOnRoute();
                }
            }
        } catch (Exception e) {
            System.out.println(" Incorrect input try again later ");
        }
    }
}
