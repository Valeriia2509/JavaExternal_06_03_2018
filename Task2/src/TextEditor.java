import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class TextEditor {

    public String readText(String file){
        String text="";
        BufferedReader bf;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(file),"CP1251"));
            StringBuilder sb = new StringBuilder();
            while((text=bf.readLine())!=null) {
                sb.append(text);
            }
            text=sb.toString();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    public String replaceTabsAndSpaces(String te){
        String t= te.replaceAll("\t"," ");
        StringBuilder text=new StringBuilder(t);
        int firstSpace=0;

        for (int i=0;i<text.length();i++){
            if ((text.charAt(i)==' ')&&(firstSpace==0)){
                firstSpace=i;
            }
            if ((text.charAt(i)!=' ')&&(firstSpace!=0)){
                if ((i-1-firstSpace)>1){
                    text.replace(firstSpace,i," ");
                    i=firstSpace+1;
                }
                firstSpace=0;
            }
        }

        return text.toString();
    }

    public ArrayList<Line> trimToLines(String text) {
        ArrayList<Line> lines=new ArrayList<>();

        int lineLength=0;
        for (int i=0; i<text.length();i++){
            if ((text.charAt(i)==' ')&&(lineLength==0)){}
            else{
                lineLength++;
                if ((text.charAt(i)=='.')||(text.charAt(i)=='?')||(text.charAt(i)=='!')){
                    if (lineLength>=10){
                        lines.add(new Line(text.substring(i-lineLength+1,i+1)));
                    }
                    lineLength=0;
                }
            }
        }
        return lines;
    }

    public ArrayList<Line> replaceMaxSublines(ArrayList<Line> lines, char firstSymbol, char lastSymbol) {
        for (int i=0; i<lines.size(); i++){
            lines.get(i).replaceMaxSubline(firstSymbol,lastSymbol);
        }
        return lines;
    }

    public void printLines(ArrayList<Line> lines, int first, int last) {
        if ((first>last)||(last>lines.size()))
            System.out.println("Неверно введены значения диапазона для печати");
        else{
            for (int i=first; i<last+1; i++ )
                System.out.println(lines.get(i).getLine());
        }
    }
}
