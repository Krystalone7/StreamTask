import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Darya");
        strings.add("Artem");
        strings.add("Julia");
        strings.add("Grigoriy");
        List<String> sorted = strings.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}
