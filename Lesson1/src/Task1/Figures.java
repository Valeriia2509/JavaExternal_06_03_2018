package Task1;

public class Figures {

    public static void main(String[] args) {
        Figures.rectangle(4,8);
        System.out.print("\n");
        Figures.rigthTriangle(7);
        System.out.print("\n");
        Figures.equilateralTriangle(9);
        System.out.print("\n");
        Figures.rhombus(9);
    }

    public static void rectangle(int a, int b){

        for (int i=0; i<a; i++){
            for (int j=0; j<b; j++){
                if (((i==0)||(i==a-1))||((j==0)||(j==b-1)))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    public static void rigthTriangle(int a){

        int i=0;
        while (i<a){
            int j=0;
            while (j<a){
                if (((i==a-1))||((j==0)||(j==i)))
                    System.out.print("* ");
                else
                    System.out.print("  ");
                j++;
            }
            i++;
            System.out.print("\n");
        }
    }

    public static void equilateralTriangle(int a){

        for (int i=0; i<a/2+1; i++){
            for (int j=0; j<a; j++){
                if ((i==a/2)||(j==(a/2-i)||(j==(a/2+i))))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    public static void rhombus(int a){

        for (int i=0; i<a/2+1; i++){
            for (int j=0; j<a; j++){
                if ((j==(a/2-i)||(j==(a/2+i))))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }

        for (int i=a/2-1; i>=0; i--){
            for (int j=0; j<a; j++){
                if ((j==(a/2-i)||(j==(a/2+i))))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
