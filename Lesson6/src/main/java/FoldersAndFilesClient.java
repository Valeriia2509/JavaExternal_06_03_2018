/*
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
к задаче по бд добавить
1 Валидацию XML по XSD схеме
2 три парсера через фабрику
CRUD database to XML
 */

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class FoldersAndFilesClient {
    private Scanner sc=new Scanner(System.in);
    private FoldersAndFilesDAO dao=new FoldersAndFilesDAO();

    public static void main(String[] args) {
        new FoldersAndFilesClient();
    }

    public FoldersAndFilesClient(){
        workWithDatabase();
    }

    public void workWithDatabase() {
        int command=0;
        while (true) {
            System.out.println("*** Меню ***" );
            System.out.println("1 Вывести информацию о папках");
            System.out.println("2 Вывести информацию о файлах");
            System.out.println("3 Добавить новую папку");
            System.out.println("4 Добавить новый файл");
            System.out.println("5 Удалить папку");
            System.out.println("6 Удалить файл");
            System.out.println("7 Показать файлы в папке");
            System.out.println("0 Выйти из меню");
            System.out.println();
            System.out.print("Выберите вариант: ");

            command = Integer.valueOf(sc.next());

            switch (command) {
                case 1: {
                    print(dao.getFolders());
                    break;
                }
                case 2: {
                    print(dao.getFiles());
                    break;
                }
                case 3:{
                    dao.addFolder(askNewFolder());
                    break;
                }
                case 4:{
                    dao.addFile(askNewFile());
                    break;
                }
                case 5:{
                    System.out.print("Введите имя папки: ");
                    String name=sc.next();
                    dao.deleteFolder(name);
                    break;
                }
                case 6:{
                    System.out.print("Введите индекс: ");
                    int id=sc.nextInt();
                    dao.deleteFile(id);
                    break;
                }
                case 7:{
                    System.out.print("Введите имя папки: ");
                    String folderName=sc.next();
                    print(dao.findFilesInFolder(folderName));
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

    public Folder askNewFolder(){
        System.out.print("Введите индекс: ");
        int id=sc.nextInt();
        System.out.print("Введите имя: ");
        String name=sc.next();
        return new Folder(id,name);
    }

    public File askNewFile(){
        System.out.print("Введите индекс: ");
        int id=sc.nextInt();
        System.out.print("Введите имя: ");
        String name=sc.next();
        System.out.print("Введите формат: ");
        String format=sc.next();
        System.out.print("Введите дату последнего изменения (1999-01-01): ");
        String d=sc.next();
        java.sql.Date modified=java.sql.Date.valueOf(d);
        System.out.print("Введите имя папки: ");
        String foldername=sc.next();

        return new File(id,name,format,modified,foldername);
    }

    public void print(List<?> list){
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
