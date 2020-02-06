import java.util.ArrayList;
import java.util.List;

public class ParseResult {

    private List<Account> accounts;
    private List<String> notValidLines;

    public ParseResult(ArrayList<Account> accounts, List<String> notValidLines) {
        this.accounts =  accounts;
        this.notValidLines = notValidLines;
        List[] lists = {accounts, notValidLines};
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setNotValidLines(List<String> notValidLines) {
        this.notValidLines = notValidLines;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public List<String> getNotValidLines() {
        return notValidLines;
    }


}
