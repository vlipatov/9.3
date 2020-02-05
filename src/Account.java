import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.DoubleBinaryOperator;

public class Account {

    private String description;
    private float income;
    private float outcome;

    public Account(String description, String income, String outcome) {
        this.description = description;
        this.income = Float.valueOf(income);
        this.outcome = Float.valueOf(outcome);
    }

    public String getDescription() {
        String formattedDescription = null;
        int reverse = description.indexOf("/");
        int straight = description.indexOf("\\");
        if(reverse != -1) {
            formattedDescription = description.substring(reverse+1);  // так как у ячеек в таблице фикс. длина, обрезаю сабстрингом
            formattedDescription = formattedDescription.substring(0,41);
        }
        else if(straight != -1)
        {
            formattedDescription = description.substring(straight+1);
            formattedDescription = formattedDescription.substring(0,41);
        }
        return formattedDescription;
    }

    public float getOutcome() {
        return outcome;
    }

    public float getIncome() {
        return income;
    }
}

