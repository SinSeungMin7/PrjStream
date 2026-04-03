package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}


public class StreamTest04 {

	public static void main(String[] args) {
		// int [] 
		// -> IntStream       : Arrays.stream(arr) : int type의 Stream
		// -> Stream<Integer> : .boxed()           : int -> Integer
		// -> List<Integer>   : .toList()      
		
		// 1) int []
		int [] arr = { 1, 2, 3, 4, 5 };
		
		// 2) int[] -> List<integer>
		List<Integer>list = Arrays.stream(arr)
				            	  .boxed()
				            	  .toList();
		
		System.out.println( "원본 List: " + list );
		
		// 3) 전체 합계
		// mapToInt : Stream 안에 있는 내용을 하나씩 꺼내서 변경 
		// Integer::intValue : int <- Integer
		// Integer.valueOf(int) : int -> Integer
		int sum = list.stream()
				      .mapToInt(Integer::intValue)
				      .sum();
		
		System.out.println("합계 sum: " + sum);
		
		// 4) filter : 짝수만 추출
		List<Integer> evenList = list.stream()
				                     .filter( n -> n % 2 == 0 )
				                     .toList();
		System.out.println( "짝수 목록: " + evenList);
		
		// 5) map : 모든 데이터를 10배로 변환
		List<Integer> mappedList = list.stream()
				                       .map( n -> n * 10 )
				                       .toList(); //stream list -> arraylist변환
		System.out.println("배열 10배: " + mappedList);
		
		// 6) filter + map + sum
		double result1 = list.stream()
		    .filter( n -> n >= 3)
		    .map(n -> n * n )
		    .mapToDouble(Integer :: doubleValue)
		    .average() // Optional<double>을 리턴한다
		    .orElse(0.0); // average() 가 null 이면 0.0을 출력하라
		     // Optional<Double>  : 결과가 null 될수없다
		    // 만약 null이면 .orElse(0.0) 추가해서 0.0으로 만들어줘야한다
		   // .sum() 하기위해 Integer -> int 로 변환
//		    .sum(); // 결과는 int
		System.out.println("최종결과" + result1);
		
		// 7) forEach
//		Stream<String> stream = Stream.of("apple","banana","cherry","durian");
		String []       fruits = {"apple","banana","cherry","durian","apple"};
		List<String> fruitList = Arrays.asList(fruits); // 배열을 arrayList로 바꾸는방법
		fruitList.stream()
			     .limit(3)   // 작업대상 갯수를 제한
		     	 .distinct() // 중복제거
				 .sorted()   // 정렬해서
				 .forEach(fruit -> 
				 System.out.println(fruit.toUpperCase())
				);
		// 8) forEach
		List<Person> people = Arrays.asList(
				new Person("John", 25),
				new Person("Jane", 30),
				new Person("Bob", 25),
				new Person("Alice", 30)
				);
				Map<Integer, List<Person>> result = people.stream().collect
				(Collectors.groupingBy(Person::getAge));
				System.out.println(result);
	}
}
		
		
		
		