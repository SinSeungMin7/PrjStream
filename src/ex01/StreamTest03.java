package ex01;

import java.util.Arrays;
import java.util.List;

public class StreamTest03 {

	public static void main(String[] args) {
		
//		Integer []            arr = {1,2,3,4,5};
//		List <Integer> stream = Arrays.asList( 1, 2, 3, 4, 5 ); 
//		System.out.println( stream );
		
		List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6 );
		int sum = numbers.stream() // 작업을 걸때마다 
				.reduce( 0, Integer::sum ); // reduce 0 은 초기값 0을 부여한것, 정적(Static) 메소드 호출 
		// Integer 클래스의 정적 매서드 sum (int a, int b) : Integer.sum(int a, int b)
		// 람다식 : (a, b) -> a + b
		System.out.println( sum );
		
		List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5 );
		int sum2 = list.stream() 
				.reduce( 0, ( a, b ) -> a + b ); // 람다식
		System.out.println(sum2);
	}

}
