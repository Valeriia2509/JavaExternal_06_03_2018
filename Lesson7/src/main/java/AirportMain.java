import java.util.ArrayList;

/*
Разработать многопоточное приложение.
Использовать возможности, предоставляемые пакетом java.util.concurrent.
Не использовать слово synchronized.
Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
Использовать возможности ООП.
Не использовать графический интерфейс. Приложение должно быть кон-
сольным.

Вариант 11.  Аэропорт. Посадка/высадка пассажиров может осуществляться через конечное
число терминалов и наземным способом через конечное число трапов. Самолеты
бывают разной вместимости и дальности полета. Организовать функционирова-
ние аэропорта, если пунктов назначения 4–6, и зон дальности 2–3.

 */
public class AirportMain {
    public static void main(String[] args) throws InterruptedException {
        final Airport airport=new Airport();
        final ArrayList<City> routes=new ArrayList<City>();
        final ArrayList<Plane> planes = new ArrayList<Plane>();

        try {
            routes.add(new City("Лондон",2000,1));
            routes.add(new City("Париж", 2200,2));
            routes.add(new City("Милан", 1800,3));
            routes.add(new City("Варшава",780,4));
            routes.add(new City("Будапешт",1000,5));
        }
        catch (ParametersException e){
            e.printStackTrace();
        }

        try {
            planes.add(new Plane(airport, 2500, 200));
            planes.add(new Plane(airport, 5000, 180));
            planes.add(new Plane(airport, 4200, 220));
            planes.add(new Plane(airport, 3000, 210));
            planes.add(new Plane(airport, 3200, 160));
        }
        catch (ParametersException e){
            e.printStackTrace();
        };
        for (int i=0;i<routes.size(); i++){
            planes.get(i).setRoute(routes.get(i));
        }

        for (Plane plane: planes) {
            if (plane.getRoute()!=null)
                plane.start();
            Thread.sleep(200);
        }
    }
}