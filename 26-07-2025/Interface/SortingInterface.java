public class SortingInterface{
    public static void main(String[] args) {


        int arr[] = {64,34,25,12,22,11,90};

        BubbleSort b = new BubbleSort();
        InsertionSort i = new InsertionSort();
        
        b.sort(arr);
        i.sort(arr);
    }
}



interface Sortable {

    public void sort(int[]arr);



}


class BubbleSort implements Sortable {


    public void sort(int[]arr){

          System.out.println("BUBBLE SORT STARTING ...");


        int n = arr.length;
        boolean swapped = false;
        for(int i=0;i<n-1;i++){

            for(int j=0;j<n-i-1;j++){

                if(arr[j] > arr[j + 1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swapped = true;
                    }

            }

            if(!swapped) break;


        }

                 for(int a : arr){
            System.out.print(a+" ");
         }

         System.err.println("");



    }


   

}

class InsertionSort implements Sortable{

    public void sort(int[]arr){

 System.out.println("INSERTION SORT STARTING ...");

        int n = arr.length;
        
        for(int i=1;i<n;i++){
            int key = arr[i];

            int j = i-1;

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }

            arr[j+1] = key;


        }

                for(int a : arr){
            System.out.print(a+" ");
         }

         System.err.println("");



    }


}