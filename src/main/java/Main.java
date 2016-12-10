import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		List<String> msgJapanese = Arrays.asList("やぎにい", 
												 "うなすけ", 
												 "やぎすけ", 
												 "アドベントカレンダー", 
												 "2016-12-10", 
												 "首を突っ込む", 
                								"やっていき");

		List<String> msgEnglish = Arrays.asList("yagi2", 
												"unasuke", 
												"yagisuke",  
												"advent-calendar",
												"2016-12-10", 
												"kubi wo tukkomu", 
												"yatteiki");
		
		System.out.println(".forEach");
		msgJapanese.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("\n.forEach Lambda");
		msgJapanese.forEach(str -> System.out.println(str));
		
		System.out.println("\n.forEach toUpperCase");
		List<String> msgEnglishUppercase = new ArrayList<>();
		msgEnglish.forEach(str -> msgEnglishUppercase.add(str.toUpperCase()));
		msgEnglishUppercase.forEach(str -> System.out.println(str));
		
		System.out.println("\nStream toUpperCase");
		msgEnglish.stream().map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
		
		System.out.println("\nStream toUpperCase reference method");
		msgEnglish.stream().map(String::toUpperCase).forEach(str -> System.out.println(str));
	
		System.out.println("\nStream filter");
		msgJapanese.stream().filter(str -> str == "うなすけ").forEach(str -> System.out.println(str));

		System.out.println("\nStream filter num");
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		num.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(String.valueOf(n)));
		
		System.out.println("\nStream count");
		System.out.println(String.valueOf(
				num.stream().filter(n -> n % 2 == 0).count()
				));
		
		System.out.println("Stream min, max");
		Random rnd = new Random();
		System.out.println(String.valueOf(
				num.stream().map(n -> rnd.nextInt(101)).max(Integer::compare)
				.orElse(-1)));
		
		System.out.println(String.valueOf(
				num.stream().map(n -> rnd.nextInt(101)).min(Integer::compare)
				.orElse(-1)));
		
		System.out.println("Stream findFirst findAny");
		System.out.println(String.valueOf(
				msgJapanese.stream().map(str -> str + "ちゃん").findFirst()
				.orElse("")));
		
		System.out.println(String.valueOf(
				
				msgJapanese.stream().map(str -> str + "さん").findAny()
				.orElse("")));
	}
}
