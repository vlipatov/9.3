import java.time.LocalDate;
import java.util.function.DoubleBinaryOperator;

public class Account {

//    private String type;
//    private String number;
//    private String currency;
//    private String operationDate;
//    private String reference;
    private String description;
    private String in;
    private String out;

    public Account(String description, String in, String out) { // пока что использую только 3 значения - операция, приход и расход, поэтому оставил только их
//        this.type = type;
//        this.number = number;
//        this.currency = currency;
//        this.operationDate = operationDate;
//        this.reference = reference;
        this.description = description;
        this.in = in;
        this.out = out;
    }
//    public String getReference() {
//        return reference;
//    }
//
//    public void getOperationDate() {
//        System.out.println(operationDate);
//    }

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

    public Double getOutcome() {
        double outcome = Double.parseDouble(out);
        return outcome;
    }

    public Double getIncome() {
        double income = Double.parseDouble(in);
        return income;
    }
}

