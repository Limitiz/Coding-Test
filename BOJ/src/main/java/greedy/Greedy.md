# Greedy

<aside>
💡 매 순간 가장 좋아 보이는 것만 선택하고 나중에 미칠 영향은 고려하지 않는 방식
→ 존나 욕심쟁이 방법 = GREEDY!

</aside>

### 등장 배경

- 어떤 문제를 해결하는데 가장 확실한 방법은 **모든 경우의 수**를 구해보는 것이다
- 하지만 이러한 방법은 너무 큰 시간복잡도와 공간복잡도를 발생시킨다
- 그렇다면 각 단계마다 모든 경우의 수를 고려하지 않고
**최적의 선택만** 해나가면 어떨까!! → 이것이 **Greedy** 알고리즘이다.

### 정당성 문제

- 각 단계마다 최적의 선택을 했다고 해서 그것이 전체 문제에 대한 최적의 답이라고 할 수 있을까?
- 정당성 문제때문에 Greedy를 사용할 수 없는 경우

![Untitled](Greedy%202e73e/Untitled.png)

각 단계에서 가장 큰 숫자를 골랐지만

Greedy의 결과가 Best의 답이 아니였다.

- 그리디 알고리즘은 이러한 정당성의 문제를 증명해야 한다.

### 조건

**탐욕적 선택 속성**

- 각 단계에서 탐욕적으로 내리는 선택은 항상 최적해로 가는 길 중 하나다
- 즉, 탐욕적 선택을 해서 손해보는 일이 없어야 한다.

**최적 부분 구조**

- 부분 문제의 최적해가 전체 문제의 최적해를 만들 수 있어야한다.
- 즉, 전체 문제의 안에는 여러 단계가 존재하고, 이 여러 단계 내의 하나 하나의 단계에 대해 최적해가 도출되어야 한다는 것이다.

### Greedy Algorithm은 어떻게 해야 잘풀까

답은 양치기이다.

- 발상적인 문제들이 많기 때문에 여러 문제를 풀면서 발상법을 익혀 나가야한다.
- 보통 기준에 따라 가장 좋은 것을 선택하기 때문에 정렬 과 많이 쓰이기도 한다
- 따라서 다양한 정렬 (알고리즘보다는) 방법을 알아놓자

---

### 💡 TIP! 정렬 알고리즘 없이 정렬하는 법

**내장함수 사용하기**

- `Arrays.sort(배열명);` : 배열을 오름차순 정렬해주는 Arrays 클래스의 내장 함수
- `Collections.sort(컬렉션명);` : List, Set과 같은 Collection을 오름차순 정렬해주는 Collection 클래스의 내장 함수
- 역순으로 정렬하기 
`Arrays.sort(배열명, Comparator.reverseOrder());`
`Collections.sort(컬렉션명, Comparator.reverseOrder());`
- <참고용> Collection 종류
    
    ![Untitled](Greedy%202e73e/Untitled%201.png)
    
    - 참고로 Map은 Collection으로 분류하지 않습니다.
    
    [[Java] 컬렉션 프레임워크(Collections Framework)](https://livenow14.tistory.com/31)
    
    Collection 프레임워크에 대한 자세한 설명 + 왜 Map은 Collection으로 분류하지 않는지에 대한 설명 참고
    

**Comparable 인터페이스 사용하기**

- 정렬 수행시 기본적으로 적용되는 정렬 기준이 되는 함수(compareTo)를 정의하는 인터페이스
- 보통 클래스를 정의할때 같이 많이 쓴다.
- Comparable 인터페이스를 상속받게 하면 인스턴스들이 compareTo 메소드에 따라 정렬된다

```java
class 클래스명 implements Comparable<클래스명>{
		int num;

		@Override
		public int compareTo(Object o){
				return this.num - o.num; //음수 or 0 - 내가 먼저, 양수 - o가 먼저
		}
}
```

- 간단하게 말하면 return 음수|0 → 내가 먼저 정렬됨 / return 양수 → o가 먼저 정렬됨
- campareTo 함수의 원리
    - 현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
    - 현재 객체 == 파라미터로 넘어온 객체: 0 리턴
    - 현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
    
    ```java
    class Point implements Comparable<Point>{
    		int age;
    
    		@Override //compareTo의 원리
    		public int compareTo(Object o){
    				// 자기자신의 age가 o의 age보다 크다면 양수 반환 -> o가 
    				if(this.age > o.age) return 1;
    		
    				// 자기 자신의 age와 o의 age가 같다면 0 반환
    				else if(this.age == o.age) return 0;
    	
    				// 자기 자신의 age가 o의 age보다 작다면 음수 반환
    				else return -1; 
    		}
    }
    ```
    
    음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
    
    ```java
    @Override 
    public int compareTo(Object o){
    		return this.age - o.age; //오름차순 정렬
    		//this < o 이면 음수 리턴이므로 작은것이 앞으로 가는 오름차순 정렬
    }
    
    @Override 
    public int compareTo(Object o){
    		return o.age - this.age; //내림차순 정렬
    		//this < o 이면 양수 리턴이므로 작은것이 뒤로 가는 내림채순 정렬
    }
    ```
    

**Comparator 클래스 사용하기**

- 정렬 가능한 클래스들의 기본 정렬 기준과 다르게 정렬하고 싶을 때 사용
- 보통 내장함수와 함께 익명 클래스로 많이 쓴다.
- compare 함수의 사용법은 Comparable 인터페이스의 compareTo 함수 사용법과 같다

```java
//클래스 정의해서 사용하기 (잘 안씀)
Comparator<Point> myComparator = new Comparator<Point>() {
  @Override
  public int compare(Point p1, Point p2) { 위와 동일 }
};

Collections.sort(arr, myComparator);

//익명 클래스로 사용하기 (보통  이 방식을 가장 많이 씀)
Collections.sort(arr, new Comparator<Object>{
		@Override
	  public int compare(Object o1, Object o2) { 
				return o1 - o2; //음수 or 0 - o1이 먼저, 양수 - o2가 먼저
		}
});
```

- 예시

❗ 그럼 원시타입(int, double 등등)을 정렬하고 싶을 때는 어떻게 합니까 ❗

- 이럴때 Wrapper Class를 쓰시면 됩니다.
