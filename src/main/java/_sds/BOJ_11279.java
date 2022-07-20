package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> heap = new ArrayList<>();
        heap.add(0);

        while(n --> 0){
            int op = Integer.parseInt(br.readLine());

            //insert
            if(op > 0){
                heap.add(op);

                int cur = heap.size()-1;
                int par = cur/2;

                while(heap.get(par) < heap.get(cur) && par != 0){
                    int tmp = heap.get(par);
                    heap.set(par, heap.get(cur));
                    heap.set(cur, tmp);

                    cur = par;
                    par = cur/2;
                }
            }

            //print & remove
            else{
                if(heap.size() == 1) System.out.println(0);
                else{
                    System.out.println(heap.get(1));

                    heap.set(1, heap.get(heap.size()-1));
                    heap.remove(heap.size() - 1);

                    int cur = 1;
                    while(true){
                        int left = cur*2;
                        int right = cur*2 +1;

                        if(left >= heap.size()) break;

                        int maxVal = heap.get(left);
                        int maxIdx = left;

                        if(right < heap.size() && maxVal < heap.get(right)){
                            maxVal = heap.get(right);
                            maxIdx = right;
                        }

                        //SWAP (자식이 부모보다 클 경우)
                        if(heap.get(cur) < maxVal){
                            heap.set(maxIdx, heap.get(cur));
                            heap.set(cur, maxVal);
                            cur = maxIdx;
                        }else break;
                    }
                }
            }
            //status(heap);
        }
    }

    public static void status(List<Integer> list){
        System.out.println("\n====================");
        for(Integer i : list)
            System.out.print(i+" ");
    }
}
