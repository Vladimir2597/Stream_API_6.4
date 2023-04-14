import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in,"UTF-8");
        String str = scanner.nextLine();
        Map<String,Long> map_res = Arrays.stream(str.toLowerCase().split("[^а-яa-z0-9]+")).collect(Collectors.groupingBy(s->s, Collectors.counting()));
        System.out.println(map_res);
        map_res.entrySet().stream()
                .sorted( (e1,e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey())
                                                                         : e2.getValue().compareTo(e1.getValue())
                        )
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }
}