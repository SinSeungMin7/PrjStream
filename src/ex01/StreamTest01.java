package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest01 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banna", "cherry");
		Optional<String> result = list.stream()
				         .filter( s -> s.startsWith("a") )
				         .findFirst();
		       // list 를 stream 으로 변환
		       // 필터링 단계 : 문자열 s 가 "a"로 시작하는지 확인 조건에 맞으면 통과
		       // findFirst : 필터링된 데이터들 중 가장 첫번째 요소를 집는다
		if ( result.isPresent() ) { // 값이 존재하면 true, 없으면 false
			System.out.println(result.get());
		}
	}

}
