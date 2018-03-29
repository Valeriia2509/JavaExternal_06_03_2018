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
 */
package Task1;

import java.util.Scanner;

public class VehicleMain {
    private static Scanner sc=new Scanner(System.in);
    private static int n=15;
    public static void main(String[] args){
        Vehicle [] vehicles=new Vehicle[n];
        vehicles[0]=new Car(10000, 200, 2009,50,35);
        vehicles[1]=new Car(8000, 170, 2002,17,78);
        vehicles[2]=new Car(12000, 240, 2010,89,110);
        vehicles[3]=new Car(50000, 280, 2014,-50,-5);
        vehicles[4]=new Car(11000, 180, 2015,-35,12);
        vehicles[5]=new Plane(100000000, 850, 2010, 7, 120, -15,72);
        vehicles[6]=new Plane(200000000, 900, 2012,5, 180,67,153);
        vehicles[7]=new Plane(400000000, 950, 2015,7, 220, 17,-117);
        vehicles[8]=new Plane(700000000, 960, 2016, 10, 150, 35,80);
        vehicles[9]=new Plane(500000000, 870, 2014,12, 250, 13,-189);
        vehicles[10]=new Ship(13000000, 50, 2013, "Hong Kong", 300,22,114);
        vehicles[11]=new Ship(35000000, 65, 2008,"Rotterdam", 500, 51,4);
        vehicles[12]=new Ship(80000000, 70, 2009, "Dubai",250, 25,55);
        vehicles[13]=new Ship(20000000, 55, 2017,"Hamburg",800, 53,10);
        vehicles[14]=new Ship(65000000, 65, 2016, "Kelang",650, 3,101);

        menu(vehicles);
    }

    public static void menu(Vehicle [] veh){
        int command=1;

        while (command>0) {
            System.out.println("*** Меню ***" + "\n" + "1 Вывести информацию о средствах передвижения");
            System.out.println("2 Задать координаты средства передвижения");
            System.out.println("3 Вывести координаты средства передвижения");
            System.out.println("4 Задать параметры средства передвижения");
            System.out.println("5 Вывести параметры средства передвижения");
            System.out.println("6 Вывести средство передвижения с наибольшей ценой");
            System.out.println("7 Найти механизм год выпуска 2000-2005 с  скоростью выше 150 км\\ч, и наименьшей ценой");
            System.out.println("8 Из Масива Vehicle получить масив Car не старше 5 лет");
            System.out.println("9 Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
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
                    break;
                }
                case 4:{
                    Vehicle veh1=chooseVehicle(veh);
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
                    Vehicle veh1=biggestPrice(veh);
                    System.out.println(veh1);
                    break;
                }
                case 7:{
                    Vehicle veh1=yearSpeedPrice(veh);
                    System.out.println(veh1);
                    break;
                }
                case 8:{
                    Vehicle [] cars=new Car[n];
                    vehicles5years(veh,cars,"Task1.Car");
                    printVehicles(cars);
                    break;
                }
                case 9:{
                    Vehicle[] ships=new Ship[n];
                    vehicles5years(veh,ships,"Task1.Ship");
                    sortingPrice(ships);
                    printVehicles(ships);
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Команда не верна");
                }

            }

            System.out.println();
        }

    }

    public static Vehicle chooseVehicle(Vehicle [] veh){
        int x=0;
        while ((x<=0)||(x>15)) {
            System.out.println("Выберите средство передвижения (от 1 до 15):");
            x=sc.nextInt();
        }
        return veh[x-1];
    }

    public static Vehicle biggestPrice(Vehicle [] veh){
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

    public static Vehicle yearSpeedPrice(Vehicle[] veh){
        int minPrice=biggestPrice(veh).getPrice();
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

    public static void vehicles5years(Vehicle [] veh, Vehicle [] veh1, String class1){
        int ind=0;

        for (int i=0; i<veh.length; i++) {
            if ((class1).equals(veh[i].getClass().getName())) {
                if ((2018 - veh[i].getYear()) <= 5) {
                    veh1[ind] = veh[i];
                    ind++;
                }
            }
        }
    }

    public static void sortingPrice(Vehicle[] veh){
        Vehicle x;
        int m=0;
        for (int i=0; i<n; i++){
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

    public static void printVehicles(Vehicle[] veh){
        int i=0;
        while ((i<n)&&(veh[i]!=null)){
            System.out.println(veh[i].toString());
            i++;
        }
    }
}
