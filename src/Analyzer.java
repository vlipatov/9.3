import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {
    static Map<String, BigDecimal> outcomes = new HashMap<String, BigDecimal>();
    static BigDecimal sumIncome = new BigDecimal(0);
    static BigDecimal sumOutcome = new BigDecimal(0);
    static DecimalFormat formatter = new DecimalFormat("###,###.###");

    public Analyzer(List<Account> accounts) {
        for (Account account : accounts) {
            sumIncome = sumIncome.add(account.getIncome());
            sumOutcome = sumOutcome.add(account.getOutcome());
            if (!outcomes.containsKey(account.getDescription())) {
                outcomes.put(account.getDescription(), account.getOutcome());
            }
            if (outcomes.containsKey(account.getDescription())) {
                if (!outcomes.containsValue(account.getOutcome()))
                    outcomes.put(account.getDescription(), (outcomes.get(account.getDescription()).add(account.getOutcome())));
            }
        }
        Analyzer.printSumIncome();
        Analyzer.printMovements();
        Analyzer.printSumOutcome();
    }
    public static void printSumOutcome() {
        System.out.println("=================================================================");
        System.out.println("Всего поступило на счет - " + formatter.format(sumIncome) + " руб.");
    }
    public static void printSumIncome() {
        System.out.println("=================================================================");
        System.out.println("Всего потрачено  - " + formatter.format(sumOutcome) + " руб.");
    }
    public static void printMovements() {
        System.out.println("=================================================================");
        System.out.println("Расходы : ");
        for (Map.Entry entry : outcomes.entrySet()) {
            System.out.println(entry.getKey() + "- " + formatter.format(entry.getValue()) + " руб.");
        }
    }
    public static BigDecimal getSumIncome() {
        return sumIncome;
    }

    public static BigDecimal getSumOutcome() {
        return sumOutcome;
    }



}
