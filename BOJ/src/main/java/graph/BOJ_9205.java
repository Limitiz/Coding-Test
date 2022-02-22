package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class Point{
     int x,y;
     Point(int x, int y){
         this.x = x;
         this.y = y;
     }
 }
 public class BOJ_9205 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(br.readLine());
         while(t-->0){
             //입력받기 (Point 클래스 사용)
             int n = Integer.parseInt(br.readLine());

             StringTokenizer st = new StringTokenizer(br.readLine());
             Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

             Point[] mart = new Point[n];
             for(int i=0; i<n; i++){
                 st = new StringTokenizer(br.readLine());
                 mart[i] =new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
             }

             st = new StringTokenizer(br.readLine());
             Point goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

             //맥주가 충분하면 그냥 가기
             //맥주가 불충분하면 편의점 들리기
             int last = -1;
             while(true) {
                 if (Math.abs(goal.x - cur.x) + Math.abs(goal.y - cur.y) <= 1000) { //50m당 맥주1병이니까
                     System.out.println("happy");
                     System.exit(0);
                 }
                 else {
                     int i;
                     for (i = n - 1; i > last; i--) {
                         int distance = Math.abs(mart[i].x - cur.x) + Math.abs(mart[i].y-cur.y);
                         if(distance <= 1000){
                             cur.x = mart[i].x;
                             cur.y = mart[i].y;
                             break;
                         }
                     }

                     if(i == last) {
                         System.out.println("sad");
                         System.exit(0);
                     } else last = i;

                 }
             }
         }
     }
 }

