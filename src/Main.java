import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data/movementList.csv"));
        ArrayList<Account> accounts = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            String[] fragments = line.split(",");
            if (fragments.length == 8) {
                accounts.add(new Account(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        fragments[6],
                        fragments[7]));
            } else if (fragments.length == 9) {
                String outcome = fragments[7].replaceAll("\"", "")
                        + "."
                        + fragments[8].replaceAll("\"", "");
                accounts.add(new Account(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        fragments[6],
                        outcome));
            }
        }

        Map<String, Double> outcomes = new HashMap<String, Double>();
        for (Account account : accounts) {
            if (!outcomes.containsKey(account.getDescription())) {
                outcomes.put(account.getDescription(), account.getOutcome());
            }
            if (outcomes.containsKey(account.getDescription())) {
                if(!outcomes.containsValue(account.getOutcome()))
                outcomes.put(account.getDescription(), (outcomes.get(account.getDescription()).doubleValue()
                                + account.getOutcome()));
            }
        }
        for (Map.Entry entry : outcomes.entrySet()) {
            System.out.println(entry.getKey() + "------ " + entry.getValue() + " руб.");
        }



    }
}
