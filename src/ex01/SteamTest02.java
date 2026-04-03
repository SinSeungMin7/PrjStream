package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteamTest02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "cherry", "abc");
		List<String> result = list.stream()
				              .filter( s -> s.startsWith("a") )
				              .collect( Collectors.toList() );
		               // filter "a" 로 시작하는것들만 걸러낸다
		               // 걸러진것들을 수집해서 List로 만든다
		System.out.println( result );

	}

}
