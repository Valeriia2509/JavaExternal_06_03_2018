import java.util.ArrayList;

public class Line {
    private String thisLine;

    public Line(String line){
        thisLine=line;
    }

    public String getLine(){
        return thisLine;
    }

    public void replaceMaxSubline(char firstSymbol, char lastSymbol){
        int first=-1;
        int last=-1;

        for (int i=0; i<thisLine.length(); i++){
            if ((first>=0)&&(thisLine.charAt(i)==lastSymbol))
                last = i;
            if ((first<0)&&(thisLine.charAt(i)==firstSymbol))
                first = i;
        }

        if (last>0){
            StringBuilder sb=new StringBuilder(thisLine);
            sb.replace(first,last+1,"");
            thisLine=sb.toString();
        }
    }
}
