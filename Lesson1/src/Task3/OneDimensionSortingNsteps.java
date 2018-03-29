//В одномерном массиве сначала положительные потом отрицательные за О(n).

package Task3;

public class OneDimensionSortingNsteps {
    public static void main(String[] args) {
        int n=10;
        int [] array=new int[n];
        for (int i=0; i<array.length; i++)
            array[i]=(int)(Math.random()*100)-50;

        for (int el: array)
            System.out.print(el+" ");
        System.out.println();

        int last=n-1;
        int x;
        for (int i=0; i<last+1; i++) {
            if (array[i]<0){
                x=array[i];
                array[i]=array[last];
                array[last]=x;

                while(array[last]<0){
                    last--;
                    if (array[last]>=0){
                        x=array[last];
                        array[last]=array[i];
                        array[i]=x;
                    }
                }
            }
        }


        for (int el: array)
            System.out.print(el+" ");
        System.out.println();

    }

}
