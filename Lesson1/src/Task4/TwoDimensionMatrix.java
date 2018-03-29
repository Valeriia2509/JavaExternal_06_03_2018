/*
Дана целочисленная прямоугольная матрица.
1. Упорядочить столбцы по убыванию среднего значения.
2. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 */
package Task4;

public class TwoDimensionMatrix {
    public static void main(String[] args) {
        int n=5;
        int m=10;
        int [][] array=new int[n][m];
        fillArray(array);
        printArray(array);
        System.out.println();
        biggestColumnAverageSorting(array);
        printArray(array);
        System.out.println();
        shortestRowRepeatSorting(array);
        printArray(array);
    }

    public static void fillArray(int [][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++)
                arr[i][j]=(int)(Math.random()*10);
        }
    }

    public static void printArray(int [][] arr){
        for (int i[]:arr){
            for (int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
    }

    public static void biggestColumnAverageSorting(int [][] arr){
            int n=arr.length;
            int m=arr[0].length;
            double [] aver=new double[m];

            for (int j = 0; j < m; j++) {
                for (int i=0; i<n; i++){
                    aver[j]=aver[j]+arr[i][j];
                }
                aver[j]=aver[j]/n;
            }

            for (int i=0; i<m; i++)
                System.out.print(aver[i]+" ");
        System.out.println();
        System.out.println();

            double x;
            for (int i=0; i<m-1; i++) {
                for (int j=i+1; j<m;j++){
                    if ((aver[j]-aver[i])>0){
                        x=aver[j];
                        aver[j]=aver[i];
                        aver[i]=x;

                        int y;
                        for (int l=0; l<n; l++){
                            y=arr[l][j];
                            arr[l][j]=arr[l][i];
                            arr[l][i]=y;
                        }
                    }
            }
        }
    }

    public static void shortestRowRepeatSorting(int [][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int [] rep=new int[n];

        for (int i=0; i<n; i++) {
            int repElem=arr[i][0];
            int repN=1;
            rep[i]=1;
            for (int j=1; j < m; j++) {
                if (repElem==arr[i][j]) {
                    repN++;
                    if (repN>rep[i]) {
                        rep[i] = repN;
                    }
                }
                else{
                    repElem=arr[i][j];
                    repN=1;
                }
            }
        }

        for (int i=0; i<n; i++)
            System.out.print(rep[i]+" ");
        System.out.println();
        System.out.println();

        int x;
        for (int i=0; i<n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rep[j] < rep[i]) {
                    x = rep[j];
                    rep[j] = rep[i];
                    rep[i] = x;

                    for (int l = 0; l < m; l++) {
                        x = arr[j][l];
                        arr[j][l] = arr[i][l];
                        arr[i][l] = x;
                    }
                }
            }
        }
    }
}
