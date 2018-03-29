/*
Дана квадратная матрица A порядка M (M — нечетное число). Начи-
ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
менты по спирали: первая строка, последний столбец, последняя строка в
обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
менты второй строки и т. д.; последним выводится центральный элемент
матрицы.
 */
package Task5;

public class Snail {
    public static void main(String[] args) {
        int m=5;
        int [][] array=new int[m][m];

        for (int i=0; i<m; i++){
            for (int j=0;j<m; j++){
                array[i][j]=(int)(Math.random()*10);
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }

        System.out.println();

        int j=0;
        int n=m;
        while (n/2>0){

            for (int i=j; i<n-1; i++){
                System.out.print(array[j][i]+" ");
            }

            for (int i=j;i<n-1;i++){
                System.out.print(array[i][n-1]+" ");
            }

            for (int i=n-1; i>j; i--){
                System.out.print(array[n-1][i]+" ");
            }

            for (int i=n-1;i>j; i--){
                System.out.print(array[i][j]+" ");
            }
            j++;
            n--;
        }
        System.out.print(array[m/2][m/2]);
    }
}
