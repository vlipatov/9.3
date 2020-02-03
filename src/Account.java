import java.time.LocalDate;

public class Account {

    private String type;
    private String number;
    private String currency;
    private String operationDate;
    private String reference;
    private String description;
    private String in;
    private String out;

    public String getOut() {
        return out;
    }

    public Account(String type, String number, String currency, String operationDate, String reference, String description, String in, String out)
    {
        this.type = type;
        this.number = number;
        this.currency = currency;
        this.operationDate = operationDate;
        this.reference = reference;
        this.description = description;
        this.in = in;
        this.out = out;
    }
    public void getOperationDate() {
        System.out.println(operationDate);
    }
    public String getDescription() {
        return description;
    }



}
