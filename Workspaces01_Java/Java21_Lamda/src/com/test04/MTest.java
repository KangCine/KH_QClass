package com.test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest {
	
	public static void main(String[] args) {
		// createStream();
		// createCollection();
		pipeline();
	}
	
	private static void createStream() {
		// builder
		Stream<String> stream01 = Stream.<String>builder().add("홍길동").add("이순신").add("김선달").build();
		stream01.forEach(System.out::println);
		
		// empty
		Stream<String> stream02 = Stream.empty();
		System.out.println(stream02.toArray().length);
		
		// generate
		Stream<Integer> stream03 = Stream.generate(()->100).limit(3);
		stream03.forEach(System.out::println);
		
		// iterator
		Stream<Integer> stream04 = Stream.iterate(1,  i -> ++i).limit(5);
		stream04.forEach(System.out::println);
		
		// range
		IntStream range01 = IntStream.range(1, 5);
		range01.forEachOrdered(i -> System.out.print(i + " "));
		System.out.println();
		IntStream range02 = IntStream.rangeClosed(1,  5);
		range02.forEachOrdered(System.out::print);
	}
	
	private static void createCollection() {
		String[] arr = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		Stream<String> stream01 = Arrays.stream(arr);
		stream01.forEach(System.out::println);
		
		// List<String> list = Array.asList(arr);
		List<String> list01 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		list01.forEach(System.out::println);
		
		List<String> list02 = List.of("홍길동", "이순신", "김선달", "유재석", "강호동", "신동엽");
		list02.forEach(System.out::println);
	}
	
	private static void pipeline() {
		List<String> qclass = Arrays.asList("홍길동", "이순신", "김선달", "유재석", "강호동", "신동엽", "펭수", "조세호");
		List<String> dong = qclass.stream()
								  .filter(name -> name.contains("동"))
								  .sorted()
								  .collect(Collectors.toCollection(ArrayList::new));
		System.out.println(dong);
		
		// 이름이 두글자인 요소만 찾아서 새로운 arraylist에 저장해서 리턴하자.
		List<String> two = qclass.stream()
								 .filter(name -> name.length() == 2)
								 .sorted()
								 .collect(Collectors.toCollection(ArrayList::new));
		System.out.println(two);
		
		// 이름에 '동'이라는 글자가 있는 사람들을 찾아서 성만 그대로 두고, 
		// 이름 나머지는 *로 표시 (ex.홍**)하고 => map()
		// list에다가 담은 후에 전체 출력하자.
		qclass.stream()
			  .filter(name -> name.contains("동"))
			  .map(word -> word.replace(word.substring(1), "*".repeat(word.length() - 1)))
			  .collect(Collectors.toList())
			  .forEach(System.out::println);
		
		// lotto
		List<Integer> lotto = Stream.generate(() -> (int)(Math.random() * 45) + 1)
									.distinct()
									.limit(6)
									.sorted()
									.collect(Collectors.toCollection(ArrayList::new));
		lotto.forEach(i -> System.out.print(i + " "));
	}

}
