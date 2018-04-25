/*
stack calculator + sin, cos, tan
 */
package Task1;

import java.util.*;

public class PolandNotation {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = sc.nextLine();

        ArrayList<String> expression=new ArrayList<>();
        Boolean correct=false;
        Calculator calculator=new Calculator();
        correct=calculator.toPolandNotation(input,expression,correct);
        if (correct==true)
            System.out.println("Ответ: "+calculator.calculate(expression));
    }

}

//7+(2*3-4*(7-2))+9     [7, 2, 3, *, 4, 7, 2, -, *, -, 9, +, +]         Ответ: [2.0]
//27+7*(3-56/(7+8))     [27, 7, 3, 56, 7, 8, +, /, -, *, +]             Ответ: [21.866666666666667]
//9-7*(45+2)/4+38*2     [9, 7, 45, 2, +, *, 4, /, 38, 2, *, +, -]       Ответ: [-149.25]
//93+(2*(7+75)/6)/1     [93, 2, 7, 75, +, *, 6, /, 1, /, +]             Ответ: [120.33333333333333]
//((2+4)*56+93)/3       [2, 4, +, 56, *, 93, +, 3, /]                   Ответ: [143.0]
//)99+66-+88(
//*33+9
//()4+3                 [4, 3, +]                                       Ответ: [7.0]
//sin(25+17)*34         [25, 17, +, sin, 34, *]                         Ответ: [22.750433993534166]
//25+cos15*22           [25, 15, cos, 22, *, +]                         Ответ: [46.250368711376794]
//24+(75*tan50)/22      [24, 75, 50, tan, *, 22, /, +]                  Ответ: [28.06279376381977]
//-7+(2*3-4*(7-2))+9    [-7, 2, 3, *, 4, 7, 2, -, *, -, 9, +, +]        Ответ: [-12.0]
