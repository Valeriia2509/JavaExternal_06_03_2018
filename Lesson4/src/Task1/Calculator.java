package Task1;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    public static Map<String, Integer> operators= new HashMap<String, Integer>();
    static{
        operators.put("+",1);
        operators.put("-",1);
        operators.put("*",2);
        operators.put("/",2);
        operators.put("(",0);
        operators.put(")",3);
        operators.put("sin",4);
        operators.put("cos",4);
        operators.put("tan",4);
        operators.put("-sin",4);
        operators.put("-cos",4);
        operators.put("-tan",4);
    }


    public static Boolean toPolandNotation(String input, ArrayList<String> expression, Boolean correct){
        Stack<String> resultOperators=new Stack<>();
        int bracketsOpened=0;
        boolean type2inStack=false;
        boolean numberTurn=true;
        boolean unaryMinusTurn=true;
        String unaryMinus=null;

        for (int i=0; i<input.length(); i++){
            char signC =input.charAt(i);
            String signS=String.valueOf(input.charAt(i));

            if (Character.isDigit(signC)) {
                if (numberTurn==false){
                    System.out.println("Неверно введено выражение");
                    return false;
                }

                String number=String.valueOf(signC);
                while (((i+1)<input.length())&&(Character.isDigit(input.charAt(i+1)))){
                    i++;
                    number+=input.charAt(i);
                }
                if (unaryMinus!=null){
                    number=unaryMinus+number;
                }
                expression.add(number);
                numberTurn=false;
                unaryMinusTurn=false;
                unaryMinus=null;
            }

            if (((signS.equals("s"))||(signS.equals("c"))||(signS.equals("t")))&&((i+2)<input.length())){
                String signS2=String.valueOf(input.charAt(i+1))+String.valueOf(input.charAt(i+2));
                if (((signS+signS2).equals("sin"))||((signS+signS2).equals("cos"))||((signS+signS2).equals("tan")))
                    signS+=signS2;
                numberTurn=false;
                unaryMinusTurn=false;
                i+=2;
            }

            if (operators.containsKey(signS)){
                int num=operators.get(signS);
                switch (num) {
                    case 1: {
                        if ((numberTurn==true)&&((signS.equals("+"))||(unaryMinusTurn==false))){
                            System.out.println("Неверно введено выражение");
                            return false;
                        }
                        if ((unaryMinusTurn==true)&&(signS.equals("-"))){
                            unaryMinus="-";
                            continue;
                        }
                        if (type2inStack==true)  {
                            if (!resultOperators.peek().equals(")")){
                                expression.add(resultOperators.peek());
                            }
                            resultOperators.pop();
                            type2inStack=false;
                        }
                        numberTurn=true;
                        unaryMinusTurn=false;
                        break;
                    }
                    case 2:{
                        if (numberTurn==true){
                            System.out.println("Неверно введено выражение");
                            return false;
                        }
                        if (type2inStack==true){
                            if (!resultOperators.peek().equals(")")){
                                expression.add(resultOperators.peek());
                            }
                            resultOperators.pop();
                        }
                        else
                            type2inStack=true;
                        numberTurn=true;
                        unaryMinusTurn=false;
                        break;
                    }
                    case 0:{
                        type2inStack=false;
                        unaryMinusTurn=true;
                        bracketsOpened++;
                        break;
                    }
                    case 3:{
                        if (bracketsOpened<=0){
                            System.out.println("Неверно введено выражение");
                            return false;
                        }
                        while ((!resultOperators.isEmpty())&&(operators.get(resultOperators.lastElement())>0)){
                            if (!resultOperators.peek().equals(")")){
                                expression.add(resultOperators.peek());
                            }
                            resultOperators.pop();
                        }
                        resultOperators.pop();
                        while ((!resultOperators.isEmpty())&&(operators.get(resultOperators.lastElement())>1)){
                            if (!resultOperators.peek().equals(")")){
                                expression.add(resultOperators.peek());
                            }
                            resultOperators.pop();
                        }
                        type2inStack=false;
                        unaryMinusTurn=false;
                        bracketsOpened--;
                        break;
                    }
                    case 4:{
                        if (numberTurn==true){
                            System.out.println("Неверно введено выражение");
                            return false;
                        }
                        if (unaryMinus!=null){
                            signS=unaryMinus+signS;
                        }
                        numberTurn=true;
                        type2inStack=true;
                        unaryMinusTurn=false;
                        unaryMinus=null;
                        break;
                    }
                }
                resultOperators.push(signS);
            }
        }

        if (bracketsOpened!=0){
            System.out.println("Неверно введено выражение");
            return false;
        }
        else {
            while (!resultOperators.isEmpty()){
                if (!resultOperators.peek().equals(")")){
                    expression.add(resultOperators.peek());
                }
                resultOperators.pop();
            }
            correct=true;
            System.out.println(expression.toString());
            return true;
        }

    }

    public static String calculate(ArrayList<String> expression){
        Stack<Double> result=new Stack<>();

        for (int i=0; i<expression.size(); i++){
            String x=expression.get(i);
            if (operators.containsKey(x)){
                double a=result.pop();
                if (x.equals("+")) result.push(result.pop()+a);
                if (x.equals("-")) result.push(result.pop()-a);
                if (x.equals("*")) result.push(result.pop()*a);
                if (x.equals("/")) result.push(result.pop()/a);
                if (x.equals("sin")) result.push(Math.sin(a/57.2958));
                if (x.equals("cos")) result.push(Math.cos(a/57.2958));
                if (x.equals("tan")) result.push(Math.tan(a/57.2958));
                if (x.equals("-sin")) result.push(0-Math.sin(a/57.2958));
                if (x.equals("-cos")) result.push(0-Math.cos(a/57.2958));
                if (x.equals("-tan")) result.push(0-Math.tan(a/57.2958));
            }
            else
                result.push(Double.valueOf(expression.get(i)));
        }
        return result.toString();
    }
}
