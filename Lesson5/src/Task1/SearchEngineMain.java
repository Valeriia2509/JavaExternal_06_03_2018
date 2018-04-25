/*
написать поисковый сервис
по указаному слову найти все URL упорядоченые по возрастанию частоты слова
по произвольному URL перейти и спомощью регулярного выражения найти 20 URL каждому указываете ключевые слова с частотами
 */

package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngineMain {

    public static void main (String [] args)throws IOException{
        HashMap<String, TreeMap<String,Integer>> mostUsedWords = new HashMap<>();
        String [] urls=new String [150];
        String urlsStart="http://www.stihi-rus.ru";
        urls[0]="http://www.stihi-rus.ru/World/Shekspir/";
        SearchEngine search=new SearchEngine();
        for (int i=1; i<urls.length; i++)
            urls[i]="";
        String [] str;
        for (int i=0; i<urls.length; i++){
            if (urls[i]!=null){
                try{
                    str=search.getTextFromURL(urls[i]);
                    urls=search.findURL(str,urls,urlsStart);
                    mostUsedWords=search.getMostUsedWords(mostUsedWords, str, urls[i]);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
       search.printMostUsedWords(mostUsedWords,20);
    }


}
