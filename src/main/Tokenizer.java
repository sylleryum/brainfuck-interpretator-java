package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yhtyyar created on 19.09.2020
 */

public class Tokenizer {

    public static List<Token> tokenize(String source) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < source.length(); ++i) {
            Token token = null;
            switch (source.charAt(i)) {
                case '>' : token = Token.NEXT_CELL; break;
                case '<' : token = Token.PREV_CELL; break;
                case '+' : token = Token.INC; break;
                case '-' : token = Token.DEC; break;
                case '.' : token = Token.PRINT; break;
                case ',' : token = Token.READ; break;
                case '[' : token = Token.OPEN_BRACKET; break;
                case ']' : token = Token.CLOSE_BRACKET; break;
            }
            tokens.add(token);
        }
        return tokens;
    }

}

