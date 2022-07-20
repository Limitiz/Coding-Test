package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042 {
    static int n, m, k, s;
    static long[] num, tree;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new long[n];
        for(int i=0; i<n; i++) num[i] = Long.parseLong(br.readLine());

        s = 1;
        while(s < n) s *= 2;

        tree = new long[s*2];
    }

    static void initBU(){
        //leaf에 값 반영
        for(int i=0; i<n; i++) tree[s+i] = num[i];

        //내부 노드 채우기
        for(int i= s-1; i>0; i--)
            tree[i] = tree[i*2] + tree[i*2 +1];
    }

    static long queryTD(int left, int right, int node, int queryLeft, int queryRight){
        //연관없음 -> 결과에 영향이 없는 값 반환
        if(queryLeft > right || queryRight < left) return 0;

        //판단 가능 -> 현재 노드 값 반환
        else if(queryLeft <= left && queryRight >= right) return tree[node];

        //판단 불가 -> 자식에게 위임(자식에서 올라온 합을 반환)
        else{
            int mid = (left+right)/2;
            long resultL = queryTD(left, mid, node*2, queryLeft, queryRight);
            long resultR = queryTD(mid+1, right, node*2+1, queryLeft, queryRight);
            return resultL + resultR;
        }
    }

    static void updateTD(int left, int right, int node, int target, long diff){
        //연관없음
        if(target < left || target > right) return;

        //연관있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        tree[node] += diff;
        if(left != right){ //내부 노드
            int mid = (left+right)/2;
            updateTD(left, mid, node*2, target, diff);
            updateTD(mid+1, right, node*2+1, target, diff);
        }
    }

    static long queryBU(int queryLeft, int queryRight){
        //leaf 에서 left, right 설정
        int left = s + queryLeft - 1;
        int right = s + queryRight -1;
        long sum = 0;

        while(left <= right) {
            //좌측 노드가 홀수면 현재 노드값 사용 -> 한칸 옆으로
            if(left % 2 == 1) sum += tree[left++];
            //우측 노드가 짝수면 현재 노드 값 사용하고 한칸 옆으로
            if(right % 2 == 0) sum += tree[right++];
            //좌측, 우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        
        return sum;
    }

    static void updateBU(int target, long val){
        //leaf에서 target 찾기
        int node = s + target - 1;
        //val 반영
        tree[node] = val;
        //root에 도달할때까지 부모에 값 반영
        node /= 2;
        while(node > 0){
            tree[node] = tree[node * 2] + tree[node * 2 +1];
            node /= 2;
        }
    }
}
