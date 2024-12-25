package Heap;

public class HeapSort {

    public static void main(String[] args) {
        
        int a[]={12,11,13,5,6,7};

        sort(a);

        for(int i : a){
            System.out.print(i+" ");
        }
    }

    public static void sort(int[] a){
        int n = a.length;
        for(int i = n/2-1; i >=0; i--){
            heapify(a,n,i);
        }

        for(int i = n-1; i >=0; i--){
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            heapify(a,i,0);
        }
    
    }
    

    public static void heapify(int[] a, int n, int i){
        int smallest = i;    
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && a[left] < a[smallest]){
            smallest = left;
        }

        if(right < n && a[right] < a[smallest]){ 
            smallest = right;
        }

        if(smallest != i){
            //swap
            int t = a[i];
            a[i] = a[smallest];
            a[smallest] = t;
            heapify(a, n, smallest);
        }

        
    }

}
