/*
Task1.
Создать консольное приложение, удовлетворяющее следующим требованиям:
1. Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
2. Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
3. Наследование должно применяться только тогда, когда это имеет смысл.
4. При кодировании должны быть использованы соглашения об оформлении кода java code convention.
5. Классы должны быть грамотно разложены по пакетам.
6. Работа с консолью или консольное меню должно быть минимальным.
7. Для хранения параметров инициализации можно использовать файлы.

Вариант 11.
Страхование. Определить иерархию страховых обязательств. Собрать из обязательств дериватив. Посчитать стоимость.
Провести сортировку обязательтсв в деривативе, соответствующее заданному диапазону параметров.

unit test + maven project
 */

import java.util.Scanner;

public class InsuranceMain {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        LifeInsurance lifeInsurance=new LifeInsurance();
        int command;

        do {
            lifeInsurance.showMenu();
            command=sc.nextInt();
            lifeInsurance.userOption(command);
        } while (command!=0);
    }
}
