import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        double sumIncome = 0;
        DecimalFormat formatter = new DecimalFormat("###,###.###");
        List<String> lines = Files.readAllLines(Paths.get("data/movementList.csv"));
        ArrayList<Account> accounts = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            String[] fragments = line.split(",");
            if (fragments.length == 8) {
                accounts.add(new Account(
                        fragments[5],
                        fragments[6],
                        fragments[7]));
            } else if (fragments.length == 9) {  // проверка для того чтобы побороть кавычки в столбце расходов
                String outcome = fragments[7].replaceAll("\"", "")
                        + "."
                        + fragments[8].replaceAll("\"", "");
                accounts.add(new Account(
                        fragments[5],
                        fragments[6],
                        outcome));
            }
        }
        /**---------==========------Для суммирования расходов создал HashMap-------------------------*/
        Map<String, Double> outcomes = new HashMap<String, Double>();
        for (Account account : accounts) {
            sumIncome += account.getIncome();
            if (!outcomes.containsKey(account.getDescription())) {
                outcomes.put(account.getDescription(), account.getOutcome());
            }
            if (outcomes.containsKey(account.getDescription())) {
                if(!outcomes.containsValue(account.getOutcome()))
                outcomes.put(account.getDescription(), (outcomes.get(account.getDescription())
                                + account.getOutcome()));
            }
        }
        System.out.println("========================================================================================");
        System.out.println("Всего поступило на счет - " + formatter.format(sumIncome) + " руб.");
        System.out.println("========================================================================================");
        System.out.println("Расходы : ");
        for (Map.Entry entry : outcomes.entrySet()) {
            System.out.println(entry.getKey() + "- " + formatter.format(entry.getValue()) + " руб.");
        }
    }
}
