package twoPointer;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class B1253 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Integer> v = new Vector<>();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            v.add(num);
        }
        int count = 0;
        Collections.sort(v);

        int a, b, sum;
        for(int i=0; i<n; i++){ //why i=2 is wrong? --> 0 0 0 (0+0 = 0)
            a = 0; b = n-1;
            while(a<b){
                sum = v.get(a) + v.get(b);
                if(sum < v.get(i))
                    a++;
                else if(sum > v.get(i))
                    b--;
                else{
                    if(i != a && i != b){ //can't include itself
                        count++;
                        break;
                    }
                    if(a == i)
                        a++;
                    if(b == i)
                        b--;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
