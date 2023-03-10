import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        IntStream.range(0, 1).forEach(i -> list.add(input));
        System.out.println("В тексте " + Pattern.compile("\\s+")
                .splitAsStream(input).filter(string -> !string.isEmpty()).count() + " слов");
        list.stream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted((e1, e2) -> {
                    int val = e1.getValue().compareTo(e2.getValue()) * -1;
                    if (val == 0) {
                        val = e1.getKey().compareTo(e2.getKey());
                    }
                    return val;
                })
                .forEach(e -> System.out.println(e.getValue() + " - " + e.getKey()));
    }
}

