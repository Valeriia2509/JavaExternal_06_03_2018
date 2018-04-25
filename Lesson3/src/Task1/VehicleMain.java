/*
Создать абстрактный класс Vehicle. На его основе реализовать классы Plane, Car, Ship.
Классы должны иметь возможность задавать и получать координаты, параметры средств передвижения (цена, скорость, год выпуска).
Для самолета должна быть определена высота, для самолета и корабля - количество пассажиров. Для корабля - порт приписки.
Написать программу, создающую список объектов этих классов в динамической памяти.
Программа должна содержать меню, позволяющее осуществить проверку всех методов классов.
1. Vehicle с наибольшей ценой
2. Найти механизм год выпуска 2000-2005 с  скоростью выше 150 км\ч, и наименьшей ценой
3. Из Масива Vehicle получить масив Car не старше 5 лет
4. Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию
5. Добавить машину Амфибию, БетМобиль
6. добавляем 3 интерфейса IFly, ISwim, IMove
7. Создать 3 последовательности  IFly, ISwim, IMove
8. в рамках каждой последовательности упорядочить по скорости
9. методы Мин Макс
10. добавить к механизмам детали. Один статический один иннер
 */

package Task1;

import java.util.Scanner;

public class VehicleMain {
    private static Scanner sc=new Scanner(System.in);
    private static String[] engines = {BatMobile.Engine.vehicleEngine(),AmphibiousVehicle.Engine.vehicleEngine(),
            Plane.Engine.vehicleEngine(),Ship.Engine.vehicleEngine(),Car.Engine.vehicleEngine()};

    public static void main(String[] args){
        Vehicle [] vehicles=new Vehicle[0];
        Vehicle.BodyShape[] bodyShapes=new Vehicle.BodyShape[0];

        Car car1=new Car(50,35,10000,200,2009);
        Vehicle.BodyShape car1bodyShape=car1.new BodyShape("белый","седан");
            vehicles=addElement(vehicles, car1);
            bodyShapes=addElement(bodyShapes,car1bodyShape);
        Car car2=new Car(17,78,8000,170,2002);
        Vehicle.BodyShape car2bodyShape=car2.new BodyShape("красный","хэтчбек");
            vehicles=addElement(vehicles, car2);
            bodyShapes=addElement(bodyShapes,car2bodyShape);
        Car car3=new Car(89,110,12000,240,2010);
        Vehicle.BodyShape car3bodyShape=car3.new BodyShape("синий","универсал");
            vehicles=addElement(vehicles, car3);
            bodyShapes=addElement(bodyShapes,car3bodyShape);
        Car car4=new Car(-50,-5,50000,280,2014);
        Vehicle.BodyShape car4bodyShape=car4.new BodyShape("черный","кабриолет");
            vehicles=addElement(vehicles, car4);
            bodyShapes=addElement(bodyShapes,car4bodyShape);
        Car car5=new Car(-35,12,11000,180, 2015);
        Vehicle.BodyShape car5bodyShape=car5.new BodyShape("желтый","пикап");
            vehicles=addElement(vehicles, car5);
            bodyShapes=addElement(bodyShapes,car5bodyShape);

        Plane plane1=new Plane(-15,72,100000000,850,2010,7,120);
        Vehicle.BodyShape plane1bodyShape=plane1.new BodyShape("белый",false);
            vehicles=addElement(vehicles, plane1);
            bodyShapes=addElement(bodyShapes,plane1bodyShape);
        Plane plane2=new Plane(67,153,200000000,900,2012,5,180);
        Vehicle.BodyShape plane2bodyShape=plane2.new BodyShape("белый",false);
            vehicles=addElement(vehicles, plane2);
            bodyShapes=addElement(bodyShapes,plane2bodyShape);
        Plane plane3=new Plane(17,-117,400000000,950,2015,7,220);
        Vehicle.BodyShape plane3bodyShape=plane3.new BodyShape("серый",true);
            vehicles=addElement(vehicles, plane3);
            bodyShapes=addElement(bodyShapes,plane3bodyShape);
        Plane plane4=new Plane(35,80,700000000,960,2016,10,150);
        Vehicle.BodyShape plane4bodyShape=plane4.new BodyShape("белый",true);
            vehicles=addElement(vehicles, plane4);
            bodyShapes=addElement(bodyShapes,plane4bodyShape);
        Plane plane5=new Plane(13,-189,500000000,870,2014,12,250);
        Vehicle.BodyShape plane5bodyShape=plane5.new BodyShape("серый",true);
            vehicles=addElement(vehicles, plane5);
            bodyShapes=addElement(bodyShapes,plane5bodyShape);


        Ship ship1=new Ship(22,114,"Hong Kong",13000000,50,2013,300);
        Vehicle.BodyShape ship1bodyShape=ship1.new BodyShape("синий",3,10);
            vehicles=addElement(vehicles, ship1);
            bodyShapes=addElement(bodyShapes,ship1bodyShape);
        Ship ship2=new Ship(51,4,"Rotterdam",35000000,65,2008,500);
        Vehicle.BodyShape ship2bodyShape=ship2.new BodyShape("серый",5, 12);
            vehicles=addElement(vehicles, ship2);
            bodyShapes=addElement(bodyShapes,ship2bodyShape);
        Ship ship3=new Ship(25,55,"Dubai",80000000,70,2009,250);
        Vehicle.BodyShape ship3bodyShape=ship3.new BodyShape("белый",2,8);
            vehicles=addElement(vehicles, ship3);
            bodyShapes=addElement(bodyShapes,ship3bodyShape);
        Ship ship4=new Ship(53,10,"Hamburg",20000000,55,2017,800);
        Vehicle.BodyShape ship4bodyShape=ship4.new BodyShape("белый",5,15);
            vehicles=addElement(vehicles, ship4);
            bodyShapes=addElement(bodyShapes,ship4bodyShape);
        Ship ship5=new Ship(3,101,"Kelang",65000000,65,2016,650);
        Vehicle.BodyShape ship5bodyShape=ship5.new BodyShape("белый",4,12);
            vehicles=addElement(vehicles, ship5);
            bodyShapes=addElement(bodyShapes,ship5bodyShape);

        AmphibiousVehicle amphibiousVehicle1=new AmphibiousVehicle(77,11,500000,200,2015);
        Vehicle.BodyShape amphibiousVehicle1bodyShape=amphibiousVehicle1.new BodyShape("белый","пикап",true);
            vehicles=addElement(vehicles, amphibiousVehicle1);
            bodyShapes=addElement(bodyShapes,amphibiousVehicle1bodyShape);
        BatMobile batMobile1=new BatMobile(30,-45,33000000,400,2016);
        Vehicle.BodyShape batMobile1bodyShape=batMobile1.new BodyShape("белый","купе",true, true);
            vehicles=addElement(vehicles, batMobile1);
            bodyShapes=addElement(bodyShapes,batMobile1bodyShape);

        IMove [] moveVehicles=new IMove[0];
        IFly [] flyVehicles=new IFly[0];
        ISwim [] swimVehicles=new ISwim[0];
        menu(vehicles, moveVehicles,flyVehicles,swimVehicles,bodyShapes);
    }

    public static void menu(Vehicle [] veh, IMove [] moveVehicles, IFly [] flyVehicles, ISwim [] swimVehicles, Vehicle.BodyShape[] bodyShapes){
        int command;

        while (true) {
            System.out.println("*** Меню ***" );
            System.out.println("1 Вывести информацию о средствах передвижения");
            System.out.println("2 Задать координаты средства передвижения");
            System.out.println("3 Вывести координаты средства передвижения");
            System.out.println("4 Задать параметры средства передвижения");
            System.out.println("5 Вывести параметры средства передвижения");
            System.out.println("6 Вывести средство передвижения с наибольшей ценой");
            System.out.println("7 Найти механизм год выпуска 2000-2005 с  скоростью выше 150 км\\ч, и наименьшей ценой");
            System.out.println("8 Из Масива Vehicle получить масив Car не старше 5 лет");
            System.out.println("9 Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
            System.out.println("10 Отсортировать Vehicles по скоростям");
            System.out.println("11 Vehicles с минимальными скоростями");
            System.out.println("12 Vehicles с максимальными скоростями");
            System.out.println("13 Вывести информацию о типах двигателей Vehicles");
            System.out.println("14 Вывести информацию о деталях Vehicles");
            System.out.println("0 Выйти из меню");

            command = sc.nextInt();

            switch (command) {
                case 1: {
                    printVehicles(veh);
                    break;
                }
                case 2: {
                    Vehicle veh1 = chooseVehicle(veh);
                    veh1.setVehicleCoordinates(sc);
                    System.out.println(veh1);
                    break;
                }
                case 3:{
                    Vehicle veh1=chooseVehicle(veh);
                    veh1.getVehicleCoordinates();
                    System.out.println();
                    break;
                }
                case 4:{
                    Vehicle veh1=chooseVehicle(veh);
                    System.out.println(veh1);
                    veh1.setVehicleParameters(sc);
                    System.out.println(veh1);
                    break;
                }
                case 5:{
                    Vehicle veh1=chooseVehicle(veh);
                    veh1.getVehicleParameters();
                    System.out.println();
                    break;
                }
                case 6:{
                    Vehicle veh1=biggestPriceVehicle(veh);
                    System.out.println(veh1);
                    break;
                }
                case 7:{
                    Vehicle veh1=year2000to2005MinSpeedLess150Price(veh);
                    System.out.println(veh1);
                    break;
                }
                case 8:{
                    carsNot5yearsOlder(veh);
                    break;
                }
                case 9: {
                    shipsNot5yearsOlder(veh);
                    break;
                }
                case 10:{
                    System.out.println("По суше:");
                    printVehicles(moveSpeedSorted(veh,moveVehicles));
                    System.out.println("В воде:");
                    printVehicles(swimSpeedSorted(veh,swimVehicles));
                    System.out.println("В полете:");
                    printVehicles(flySpeedSorted(veh,flyVehicles));
                    break;
                }
                case 11:{
                    minSpeedVehicles(veh,moveVehicles,swimVehicles,flyVehicles);
                    break;
                }
                case 12:{
                    maxSpeedVehicles(veh,moveVehicles,swimVehicles,flyVehicles);
                    break;
                }
                case 13:{
                    getEngines(veh);
                    break;
                }
                case 14:{
                    printDetailInformation(bodyShapes);
                    break;
                }
                case 0:{
                    return;
                }
                default: {
                    System.out.println("Команда не верна");
                }
            }
            System.out.println();
        }
    }

    private static void printDetailInformation(Vehicle.BodyShape[] bodyShapes) {
        for (int i=0; i<bodyShapes.length; i++){
            System.out.println((i+1)+". "+bodyShapes[i].getDetailInformation());
        }
    }


    public static void getEngines(Vehicle []veh){
        for (int i=0;i<veh.length; i++) {
            if (veh[i] instanceof BatMobile) {
                System.out.println(i+1+". "+engines[0]);
                continue;
            }
            if (veh[i] instanceof AmphibiousVehicle) {
                System.out.println(i+1+". "+engines[1]);
                continue;
            }
            if (veh[i] instanceof Plane) {
                System.out.println(i+1+". "+engines[2]);
                continue;
            }
            if (veh[i] instanceof Ship) {
                System.out.println(i+1+". "+engines[3]);
                continue;
            }
            if (veh[i] instanceof Car) {
                System.out.println(i+1+". "+engines[4]);
                continue;
            }
        }
    }

    public static void maxSpeedVehicles(Vehicle[] veh, IMove[] moveVehicles, ISwim[] swimVehicles, IFly[] flyVehicles){
        moveVehicles=moveSpeedSorted(veh,moveVehicles);
        swimVehicles=swimSpeedSorted(veh,swimVehicles);
        flyVehicles=flySpeedSorted(veh,flyVehicles);

        System.out.println("По суше:");
        if ((moveVehicles[0]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)moveVehicles[0];
            System.out.println(veh1);
        }
        else{
            System.out.println("Не средство передвижения");
        }

        System.out.println("В воде:");
        if ((swimVehicles[0]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)swimVehicles[0];
            System.out.println(veh1);
        }
        else {
            System.out.println("Не средство передвижения");
        }

        System.out.println("В полете:");
        if ((flyVehicles[0]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)flyVehicles[0];
            System.out.println(veh1);
        }
        else {
            System.out.println("Не средство передвижения");
        }
    }

    public static void minSpeedVehicles(Vehicle[] veh, IMove[] moveVehicles, ISwim[] swimVehicles, IFly[] flyVehicles){
        moveVehicles=moveSpeedSorted(veh,moveVehicles);
        swimVehicles=swimSpeedSorted(veh,swimVehicles);
        flyVehicles=flySpeedSorted(veh,flyVehicles);

        System.out.println("По суше:");
        if ((moveVehicles[moveVehicles.length-1]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)moveVehicles[moveVehicles.length-1];
            System.out.println(veh1);
        }
        else{
            System.out.println("Не средство передвижения");
        }

        System.out.println("В воде:");
        if ((swimVehicles[swimVehicles.length-1]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)swimVehicles[swimVehicles.length-1];
            System.out.println(veh1);
        }
        else {
            System.out.println("Не средство передвижения");
        }

        System.out.println("В полете:");
        if ((flyVehicles[flyVehicles.length-1]) instanceof Vehicle){
            Vehicle veh1=(Vehicle)flyVehicles[flyVehicles.length-1];
            System.out.println(veh1);
        }
        else {
            System.out.println("Не средство передвижения");
        }
    }


    public static IMove[]  moveSpeedSorted(Vehicle[] veh, IMove[] moveVehicles) {

        for (int i=0;i<veh.length;i++){
            if (veh[i] instanceof IMove)
                moveVehicles=addElement(moveVehicles, (IMove)veh[i]);
        }

        IMove x;
        for (int i=0; i<moveVehicles.length-1; i++){
            for (int j=i+1;j<moveVehicles.length;j++){
                if (moveVehicles[i].move()<moveVehicles[j].move()){
                    x=moveVehicles[i];
                    moveVehicles[i]=moveVehicles[j];
                    moveVehicles[j]=x;
                }
            }
        }
        return moveVehicles;
    }

    public static ISwim[] swimSpeedSorted(Vehicle[] veh,ISwim[] swimVehicles) {

        for (int i=0;i<veh.length;i++){
            if (veh[i] instanceof ISwim)
                swimVehicles=addElement(swimVehicles, (ISwim)veh[i]);
        }

        ISwim x;
        for (int i=0; i<swimVehicles.length-1; i++){
            for (int j=i+1;j<swimVehicles.length;j++){
                if (swimVehicles[i].swim()<swimVehicles[j].swim()) {
                    x=swimVehicles[i];
                    swimVehicles[i]=swimVehicles[j];
                    swimVehicles[j]=x;
                }
            }
        }
        return swimVehicles;
    }

    public static IFly[] flySpeedSorted(Vehicle[] veh, IFly[] flyVehicles) {

        for (int i=0;i<veh.length;i++){
            if (veh[i] instanceof IFly)
                flyVehicles=addElement(flyVehicles, (IFly)veh[i]);
        }

        IFly x;
        for (int i=0; i<flyVehicles.length-1; i++){
            for (int j=i+1;j<flyVehicles.length;j++){
                if (flyVehicles[i].fly()<flyVehicles[j].fly()) {
                    x=flyVehicles[i];
                    flyVehicles[i]=flyVehicles[j];
                    flyVehicles[j]=x;
                }
            }
        }
        return flyVehicles;
    }

    public static Vehicle chooseVehicle(Vehicle [] veh){
        int x=0;
        while ((x<=0)||(x>veh.length)) {
            System.out.println("Выберите средство передвижения (от 1 до "+veh.length+"):");
            x=sc.nextInt();
        }
        return veh[x-1];
    }

    public static Vehicle biggestPriceVehicle(Vehicle [] veh){
        int highestPrice=0;
        int ind=0;
        for (int i=0; i<veh.length; i++){
            if (highestPrice<veh[i].getPrice()) {
                highestPrice = veh[i].getPrice();
                ind=i;
            }
        }
        return veh[ind];
    }

    public static Vehicle year2000to2005MinSpeedLess150Price(Vehicle[] veh){
        int minPrice=biggestPriceVehicle(veh).getPrice();
        int ind=0;

        for (int i=0; i<veh.length; i++){
            if ((veh[i].getYear()>=2000)&&(veh[i].getYear()<=2005)){
                if (veh[i].getSpeed()>150){
                    if (veh[i].getPrice()<minPrice){
                        minPrice=veh[i].getPrice();
                        ind=i;
                    }
                }
            }
        }
        return veh[ind];
    }

    public static void carsNot5yearsOlder(Vehicle [] veh){
        Car [] cars=new Car[veh.length];
        int ind=0;

        for (int i=0; i<veh.length; i++) {
            if (veh[i] instanceof Car) {
                if ((2018 - veh[i].getYear()) <= 5) {
                    cars [ind] = (Car) veh[i];
                    ind++;
                }
            }
        }

        printVehicles(cars);
    }

    public static void shipsNot5yearsOlder(Vehicle [] veh){
        Ship [] ships=new Ship[veh.length];
        int ind=0;

        for (int i=0; i<veh.length; i++) {
            if (veh[i] instanceof Ship) {
                if ((2018 - veh[i].getYear()) <= 5) {
                    ships [ind] = (Ship) veh[i];
                    ind++;
                }
            }
        }

        sortingMaxPrice(ships);
        printVehicles(ships);
    }

    public static void sortingMaxPrice(Vehicle[] veh){
        Vehicle x;
        int m=0;
        for (int i=0; i<veh.length; i++){
            if (veh[i]!=null)
                m++;
        }
        for (int i=0; i<m-1; i++){
            for (int j=1;j<m; j++){
                if (veh[j].getPrice()>veh[i].getPrice()){
                    x=veh[j];
                    veh[j]=veh[i];
                    veh[i]=x;
                }
            }
        }
    }

    public static void printVehicles(Object[] array){
        int i=0;
        while ((i<array.length)&&(array[i]!=null)){
            if (array[i] instanceof Vehicle) {
                System.out.println((i + 1) + ". " + array[i].toString());
                i++;
            }
            else {
                System.out.println("Не средтво передвижения");
            }
        }
    }

    public static Vehicle [] addElement(Vehicle[] arr, Vehicle x){
        Vehicle[] array=new Vehicle[arr.length+1];

        for (int i=0; i<arr.length; i++)
            array[i] = arr[i];
        array[array.length-1]=x;
        return array;
    }

    public static IMove [] addElement(IMove[] arr, IMove x){
        IMove[] array=new IMove[arr.length+1];

        for (int i=0; i<arr.length; i++)
            array[i] = arr[i];
        array[array.length-1]=x;
        return array;
    }

    public static IFly [] addElement(IFly[] arr, IFly x){
        IFly[] array=new IFly[arr.length+1];

        for (int i=0; i<arr.length; i++)
            array[i] = arr[i];
        array[array.length-1]=x;
        return array;
    }

    public static ISwim [] addElement(ISwim[] arr, ISwim x){
        ISwim[] array=new ISwim[arr.length+1];

        for (int i=0; i<arr.length; i++)
            array[i] = arr[i];
        array[array.length-1]=x;
        return array;
    }

    public static Vehicle.BodyShape [] addElement(Vehicle.BodyShape[] arr, Vehicle.BodyShape x){
        Vehicle.BodyShape[] array=new Vehicle.BodyShape[arr.length+1];

        for (int i=0; i<arr.length; i++)
            array[i] = arr[i];
        array[array.length-1]=x;
        return array;
    }
}
