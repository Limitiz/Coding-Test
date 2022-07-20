package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jwelery[] jweleries = new Jwelery[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            jweleries[i] = new Jwelery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jweleries, Comparator.comparingInt(Jwelery::getWeight));
        PriorityQueue<Jwelery> heap = new PriorityQueue(Comparator.comparingInt(Jwelery::getPrice).reversed());

        int[] bag = new int[k];
        for(int i=0; i<k; i++)
            bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag);

        //보석넣기 (heap + two pointer)
        int jIdx = 0;
        long result = 0;
        //남은 가방중 가장 작은 가방
        for(int i=0; i<bag.length; i++){
            while(jIdx < n && jweleries[jIdx].weight <= bag[i])
                heap.add(jweleries[jIdx++]);
            if(!heap.isEmpty())
                result += heap.poll().price;
        }

        System.out.println(result);
    }
}

class Jwelery{
    int weight;
    int price;

    public Jwelery(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Jwelery{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
