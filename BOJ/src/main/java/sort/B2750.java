package sort;

import java.util.Scanner;

public class B2750 {
    static int sort[], tmp[];
    public static void merge(int low, int mid, int high){
        int l = low;
        int r = mid;
        int t = low;
        while(l<mid && r<high){
            if(sort[l]<sort[r])
                tmp[t++] = sort[l++];
            else
                tmp[t++] = sort[r++];
        }
        while(l<mid)
            tmp[t++] = sort[l++];
        while(r<high)
            tmp[t++] = sort[r++];
        for(int i=low; i<high; i++)
            sort[i] = tmp[i];
    }
    public static void divide(int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            divide(low, mid);
            divide(mid+1, high);
            merge(low, mid, high);
        }
    }
    public static void bubble(int n){
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(sort[j]>sort[j+1]) {
                    int temp = sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1] = temp;
                }
            }
        }
    }
    public static void selection(int n){
        int temp, min;
        for(int i=0; i<n; i++){
            min = i;
            for(int j=i+1; j<n;j++){
                if(sort[j]<sort[min])
                    min = j;
            }
            temp = sort[i];
            sort[i] = sort[min];
            sort[min] = temp;
        }
    }
    public static void insertion(int n){
        int key,j;
        for(int i=1; i<n; i++){
            key = sort[i];
            for(j=i-1; j>=0 && sort[j]>key; j--){
                sort[j+1] = sort[j]; //move to right one by one
            }
            sort[j+1] = key;
        }
    }

    public static void quick(int left, int right){
        if(left>=right)
            return;
        int pivot = left;
        int i = left+1; int j = right;
        while(i<=j){
            while(i<=right && sort[i]<=sort[pivot])
                i++;
            while(j>left && sort[j]>=sort[pivot])
                j--;
            if(i>j){
                int temp = sort[j];
                sort[j] = sort[pivot];
                sort[pivot] = temp;
            }
            else {
                int temp = sort[i];
                sort[i] = sort[pivot];
                sort[pivot] = temp;
            }
        }
        quick(left, j-1);
        quick(j+1, right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sort = new int[n];
        for(int i=0; i<n; i++)
            sort[i] = sc.nextInt();
        quick(0,n-1);
        for(int i=0; i<n; i++)
            System.out.println(sort[i]);
        sc.close();
    }
}
