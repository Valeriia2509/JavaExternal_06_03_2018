/*
Создать программу обработки текста учебника по программированию с использованием классов:
Символ, Слово, Предложение, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции
и последовательности пробелов одним пробелом.

11. В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся
заданными символами.
*/

import java.util.ArrayList;

public class BookReaderMain {
    public static void main (String [] args){
        TextEditor editor=new TextEditor();
        String text;
        ArrayList<Line> lines=new ArrayList<>();

        text=editor.readText("C:\\Users\\Valeriia\\Documents\\JavaExternal_06_03_2018\\Suhov_Osnovy-programmirovaniya-na-Java_RuLit_Net.txt");
        System.out.println(text);

        text=editor.replaceTabsAndSpaces(text);
        System.out.println(text);
        System.out.println();

        lines=editor.trimToLines(text);
        editor.printLines(lines,0,5);
        System.out.println();

        lines=editor.replaceMaxSublines(lines, 'а', 'а');
        editor.printLines(lines,0,5);
    }
}
