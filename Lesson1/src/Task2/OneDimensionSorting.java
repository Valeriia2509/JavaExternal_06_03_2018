/*
Упорядочить одномерный масиве вначале отрицательные повозрастанию
   затем положительные по убыванию.
 */
package Task2;

public class OneDimensionSorting {
    public static void main(String[] args) {
        int n=20;
        int [] array=new int[n];
        for (int i=0; i<array.length; i++)
            array[i]=(int)(Math.random()*100)-50;

        for (int el: array)
            System.out.print(el+" ");
        System.out.println();

        int last=n-1;
        int x;
        for (int i=0; i<last+1; i++) {
            if (array[i]>=0){
                x=array[i];
                array[i]=array[last];
                array[last]=x;

                while(array[last]>=0){
                    last--;
                    if (array[last]<0){
                        x=array[last];
                        array[last]=array[i];
                        array[i]=x;
                    }
                }
            }
        }

        for (int i=0;i<last;i++){
            for (int j=i; j<last+1; j++){
                if (Math.abs(array[i])>Math.abs(array[j])){
                    x=array[i];
                    array[i]=array[j];
                    array[j]=x;
                }
            }
        }

        for (int i=last+1;i<n-1;i++){
            for (int j=i; j<n; j++){
                if (array[i]<array[j]){
                    x=array[i];
                    array[i]=array[j];
                    array[j]=x;
                }
            }
        }

        for (int el: array)
            System.out.print(el+" ");
        System.out.println();

    }
}
