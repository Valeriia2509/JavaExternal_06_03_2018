# JavaExternal_06_03_2018
HomeWork

Lesson1

Task1. Вывести на экран прямоугольник, прямоугольный треугольник, равнобедренный треугольник и ромб.
Task2. Упорядочить одномерный масиве вначале отрицательные по возрастанию, затем положительные по убыванию.
Task3. В одномерном массиве сначала положительные потом отрицательные за О(n).
Task4. Дана целочисленная прямоугольная матрица.
        1. Упорядочить столбцы по убыванию среднего значения.
        2. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
Task5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
        ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
        менты по спирали: первая строка, последний столбец, последняя строка в
        обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
        менты второй строки и т. д.; последним выводится центральный элемент
         матрицы.
        
Lesson2
 
Cоздать динамический массив из разных фигур и вывести информацию на экран
создать класс Polygon для описания фигур разной размерности
сериализовать фигуры  3 точки 3 линии и 1 треугольник
сделать 3 файла с сериализованим polygon который будет описывать 3 разные фигуры
и десериализовать отобразить на екран

Lesson3

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

Lesson4

stack calculator + sin, cos, tan

Lesson5

написать поисковый сервис
по указаному слову найти все URL упорядоченые по возрастанию частоты слова
по произвольному URL перейти и спомощью регулярного выражения найти 20 URL каждому указываете ключевые слова с частотами

Lesson6
Разработать программу, обеспечивающую ввод и редактирование
информации об объектах в соответствии с заданной предметной областью.
Информация об объектах должна храниться в отдельной базе данных. Доступ к
данным осуществляется с использованием средств JDBC или ODBC.
Вариант 11
Предметная область Файловая система
Объекты Папки, Файлы
Примечание Имеется множество папок
(независимых друг от друга). Для
каждой папки определено множество файлов.
1 DAO
2 log4j INFO ERROR
2.1 info на консоль
2.2 info в файл историю запуска
3 connection pool для соединения
4 транзакции с вариантом изоляции
5 сделать несколько savePoint

Lesson7

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

Task1

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

Task2

Создать программу обработки текста учебника по программированию с использованием классов:
Символ, Слово, Предложение, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции
и последовательности пробелов одним пробелом.
11. В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся
заданными символами.
