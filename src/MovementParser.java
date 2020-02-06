import com.sun.source.tree.ParenthesizedTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovementParser {
    ArrayList<Account> accounts = new ArrayList<>();
    List<String> notValidLines = new ArrayList<>();
    private final int DESCRIPTION_INDEX = 5;
    private final int INCOME_INDEX = 6;
    private final int OUTCOME_INDEX = 7;
    private final int CORRECT_LENGTH = 8;
    private final int INCORRECT_LENGTH = 9;


    public MovementParser(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        notValidLines.add(lines.get(0));
        lines.remove(0);
        for (String line : lines) {
            String[] fragments = line.split(",");
            if (fragments.length == CORRECT_LENGTH) {
                accounts.add(new Account(
                        fragments[DESCRIPTION_INDEX],
                        fragments[INCOME_INDEX],
                        fragments[OUTCOME_INDEX]));
            } else if (fragments.length == INCORRECT_LENGTH) {  // проверка для того чтобы побороть кавычки в столбце расходов
                String outcome = fragments[OUTCOME_INDEX].replaceAll("\"", "")
                        + "."
                        + fragments[CORRECT_LENGTH].replaceAll("\"", "");
                accounts.add(new Account(
                        fragments[DESCRIPTION_INDEX],
                        fragments[INCOME_INDEX],
                        outcome));
            }
        }
    }

    public ParseResult getParseResult() {
        ParseResult parseResult = new ParseResult(accounts, notValidLines);
        return parseResult;
    }
}
