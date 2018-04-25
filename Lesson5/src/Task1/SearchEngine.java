package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    private static int ind=1;

    public String [] getTextFromURL(String URLname) throws IOException {
        URL website = new URL(URLname);
        URLConnection connection = website.openConnection();

        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(),"Cp1251"));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str=bf.readLine())!=null) {
            sb.append(str);
        }
        bf.close();
        str=sb.toString();

        String str1=str.replaceAll("[\\[\\]><\"=#!(){},|;&-'_:?]"," ");
        return str1.split(" ");
    }

    public String[] findURL(String[] str, String[] urls, String urlsStart){
        Pattern p2=Pattern.compile("\\/[\\w-\\/]+\\.htm$");

        for (int j=0; j<str.length; j++){
            Matcher m2=p2.matcher(str[j]);
            if ((m2.matches())&&(ind<urls.length)&&(urls[ind].equals(""))){
                urls[ind]=urlsStart+m2.group();
                ind++;
            }
        }
        return urls;
    }

    public HashMap <String, TreeMap<String, Integer>> getMostUsedWords(HashMap<String,TreeMap<String,Integer>> usedWords,
                                                                       String [] words, String url){
        Pattern p1=Pattern.compile("(?ui:[абвгдеёжзийклмнопрстуфхцчшщъыьэюя])+$");

        for (String a : words) {
            String word=a.replaceAll("[.]","");
            Matcher m1=p1.matcher(word);
            if ((m1.matches())&&(word.length()>3)){
                TreeMap<String,Integer> m;
                Integer freq=0;
                if (usedWords.containsKey(m1.group().toLowerCase())) {
                    m = usedWords.get(m1.group().toLowerCase());
                    if (m.containsKey(url))
                        freq = m.get(url);
                }
                else
                    m=new TreeMap<>();

                    m.put(url,(freq == 0) ? 1 : freq + 1);
                    usedWords.put(m1.group().toLowerCase(), m);
            }
        }
        return usedWords;
    }

    public void printMostUsedWords(HashMap <String, TreeMap <String, Integer>> usedWords, int count){
        LinkedHashMap<String,LinkedHashMap<String,Integer>> sortedUsedWords=sortUsedWords(usedWords);

        for (String word: sortedUsedWords.keySet()){
            if (count>0){
                System.out.println("\t"+word);
                LinkedHashMap<String,Integer> sortedM=sortedUsedWords.get(word);
                for (String url: sortedM.keySet()){
                    System.out.println(url+"\t"+sortedM.get(url));
                }
                count--;
            }
        }
    }

    public LinkedHashMap<String,LinkedHashMap<String,Integer>> sortUsedWords(HashMap<String,TreeMap<String,Integer>> usedWords){
        HashMap<String,LinkedHashMap<String,Integer>> sortedInsideUsedWords=new HashMap<>();
        for (String word: usedWords.keySet()){
            TreeMap <String,Integer> m=usedWords.get(word);
            LinkedHashMap<String,Integer> sortedM=new LinkedHashMap<>();
            int max=0;
            for (String url: m.keySet()){
                if (m.get(url)>max)
                    max=m.get(url);
            }

            for (int i=max; i>0; i--){
                for (String url:m.keySet()){
                    if (m.get(url)==i)
                        sortedM.put(url,m.get(url));
                }
            }
            sortedInsideUsedWords.put(word,sortedM);
        }

        LinkedHashMap<String,Integer> usedWordsCount=countUsedWords(sortedInsideUsedWords);

        LinkedHashMap<String,LinkedHashMap<String,Integer>> sortedUsedWords=new LinkedHashMap<>();
        for (String word:usedWordsCount.keySet()){
            if (sortedInsideUsedWords.containsKey(word))
                sortedUsedWords.put(word,sortedInsideUsedWords.get(word));
        }
        return sortedUsedWords;
    }

    public LinkedHashMap<String,Integer> countUsedWords(HashMap<String,LinkedHashMap<String,Integer>> usedWords){
        HashMap<String,Integer> usedWordsCount=new HashMap<>();
        for (String word: usedWords.keySet()){
            HashMap <String,Integer> m=usedWords.get(word);
            int find=0;
            for (String url: m.keySet()){
                find+=m.get(url);
            }
            usedWordsCount.put(word,find);
        }

        LinkedHashMap<String,Integer> sortedUsedWordsCount=new LinkedHashMap<>();
        int max=0;
        for (String word: usedWordsCount.keySet()){
            if (usedWordsCount.get(word)>max)
                max=usedWordsCount.get(word);
        }

        for (int i=max; i>0; i--){
            for (String word: usedWordsCount.keySet()){
                if (usedWordsCount.get(word)==i)
                    sortedUsedWordsCount.put(word,usedWordsCount.get(word));
            }
        }
        System.out.println(sortedUsedWordsCount);
        return sortedUsedWordsCount;
    }
}