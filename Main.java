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
            puts();
            System.out.println("Выбирите команду :");
            String out = put.nextLine();
            switch (out) {
                case "a":
                    setStatusBusOnRoute(listBusInPark, listBusOnRoute);
                    break;
                case "b":
                    setStatusBusInPark(listBusInPark, listBusOnRoute);
                    break;
                case "c":
                    viewListAllBus(listAllBus);
                    viewListBusInParK(listBusInPark);
                    viewListBusOnRoute(listBusOnRoute);
                    viewListRoute(listRoute);
                    break;
                case "d":
                    addListRoute(listRoute);
                    break;
                case "e":
                    addListBus(listAllBus);
                    break;
                case "f":
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

            }
        }


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

    public static void searchDriver(ArrayList<Bus> listAllBus){
        Scanner str = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя водителя которого хотите найти ");
        String name = str.nextLine();
        for(int i = 0; i < listAllBus.size(); i++) {
            if (name.equals(listAllBus.get(i).getNameSurname())) {
                System.out.println("Его автобус с номером: " + listAllBus.get(i).getNumberBus());
                System.out.println("Его маршрут: " + listAllBus.get(i).getNumberRoute());
            }
        }
    }

    public static void gasolineCosts(ArrayList<Route> listRoute) {
        double sum=0;
        for (int i = 0; i < listRoute.size(); i++) {
            for(int j = 0; j < listRoute.get(i).getBusThisRoute().size(); j++)
                sum += (listRoute.get(i).getLength()/100)*listRoute.get(i).getBusThisRoute().get(j).getConsumptionGasoline();
        }
        System.out.println("Общие затраты на бензин " + sum);
    }

    public static void gasolineCostsOnRoute(ArrayList<Route> listRoute) {
        double sum=0;
        double allSum=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Выбирите номер маршрута");
        int abc = in.nextInt();
        for (int i = 0; i < listRoute.size(); i++) {
            for (int j = 0; j < listRoute.get(i).getBusThisRoute().size(); j++) {
                allSum += (listRoute.get(i).getLength()/100)*listRoute.get(i).getBusThisRoute().get(j).getConsumptionGasoline();
                if (abc == listRoute.get(i).getNumber()) {
                    sum += (listRoute.get(i).getLength()/100)*listRoute.get(i).getBusThisRoute().get(j).getConsumptionGasoline();
                }
            }
        }
        System.out.println("Общие затраты на бензин  " + allSum);
        System.out.println("Затраты на бензин на маршруте '" + abc + "' = " + sum);

    }

    public static void puts() {
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
}
