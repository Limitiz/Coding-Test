package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> heap = new ArrayList<>();

        while(n --> 0){
            int op = Integer.parseInt(br.readLine());

            //insert
            if(op > 0) {
                heap.add(op);

                int cur = heap.size()-1;
                int par = (cur-1)/2;

                while(true){
                    if(heap.get(par) <= heap.get(cur) || par == -1)
                        break;

                    int tmp = heap.get(par);
                    heap.set(par, heap.get(cur));
                    heap.set(cur, tmp);

                    cur = par;
                    par = (cur-1)/2;
                }
            }

            //print & remove
            else {
                if(heap.size() == 0) System.out.println(0);
                else{
                    //출력
                    System.out.println(heap.get(0));

                    //root 에 마지막 노드 가져옴
                    heap.set(0, heap.get(heap.size() - 1));
                    heap.remove(heap.size() - 1);

                    int cur = 0;
                    while(true) {
                        int left = (cur+1) * 2 - 1;
                        int right = (cur+1) * 2;

                        //왼쪽 자식 확인
                        if(left >= heap.size()) break;

                        int minVal = heap.get(left);
                        int minIdx = left;

                        //오른쪽 자식 확인
                        if(right < heap.size() && minVal > heap.get(right)){
                            minVal = heap.get(right);
                            minIdx = right;
                        }

                        //SWAP
                        if(heap.get(cur) > minVal){
                            heap.set(minIdx, heap.get(cur));
                            heap.set(cur, minVal);
                            cur = minIdx;
                        }
                        else break;
                    }
                }
            }
            status(heap);
        }
    }

    public static void status(List<Integer> list){
        System.out.println("\n====================");
        for(Integer i : list)
            System.out.print(i+" ");
    }
}
