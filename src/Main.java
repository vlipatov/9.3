import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data/movementList.csv"));
//        lines.stream().forEach(System.out::println);

        ArrayList<Account> accounts = new ArrayList<>();
        for(String line : lines) {
            String[] fragments = line.split(",");
            if(fragments.length == 8) {
                accounts.add(new Account(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        fragments[6],
                        fragments[7]));
            }
            }




    }


}
