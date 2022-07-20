package _sds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args){
        Item i1 = new Item(1,3,1);
        Item i2 = new Item(1,2,3);
        Item i3 = new Item(1,1,2);

        List<Item> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);

        System.out.println(list);

        //1) Comparable 사용
        Collections.sort(list);
        System.out.println(list);

        //2) Comparator 사용
        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp); //Comparable은 무시되고 comp가 적용됨
        System.out.println(list);

        //3) Getter 사용
        //복잡한 경우에는 추천하지 않음 (중간에 reversed 가 섞여있는 경우도 추천안함)
        Collections.sort(list, Comparator.comparingInt(Item::getB).thenComparingInt(Item::getC));
        System.out.println(list);
    }
}

class Item implements Comparable<Item> {
    int a, b, c;

    public Item(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Item{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    //b값 기준으로 정렬
    @Override
    public int compareTo(Item o){
        return o.b - b;
        //return Integer.compare(b, o.b);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
