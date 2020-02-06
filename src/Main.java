import java.io.IOException;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        MovementParser parser = new MovementParser(Paths.get("data/movementList.csv"));
        Analyzer analyzer = new Analyzer(parser.getParseResult().getAccounts());
    }
}
