package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * @author Yhtyyar created on 19.09.2020
 */
public class BrainfuckInterpretator implements IInterpretator {

    private final InputStream input;
    private final PrintStream out;

    BrainfuckInterpretator(InputStream input, PrintStream out) {
        this.input = input;
        this.out = out;
    }

    @Override
    public void evaluate(String sourceCode) {
        try {
            new Interpreate(Tokenizer.tokenize(sourceCode), input, out).evaluate();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private static class Interpreate {
        private static final int MEMORY_SIZE = 30000;
        private final InputStream input;
        private final PrintStream out;

        private final List<Token> tokens;
        private int currTokenIndex;

        private char memory[];
        private int currCell;
        private int bracketsCount;

        Interpreate(List<Token> tokens, InputStream input, PrintStream out) {
            memory = new char[MEMORY_SIZE];
            this.input = input;
            this.out = out;
            this.tokens = tokens;
        }
        private void evaluate() throws IOException{
            for (currTokenIndex = 0; currTokenIndex < tokens.size(); ++currTokenIndex) {
                switch (tokens.get(currTokenIndex)) {
                    case NEXT_CELL: moveToNextCell(); break;
                    case PREV_CELL: moveToPreviosCell(); break;
                    case INC: incrementCurrCell(); break;
                    case DEC: decrementCurrCell(); break;
                    case PRINT: printCurrCell(); break;
                    case READ: readChar(); break;
                    case OPEN_BRACKET:
                        bracketsCount++;
                        if (memory[currCell] == (char)0){
                            moveUntilCloseBracket();
                        }
                        break;
                    case CLOSE_BRACKET:
                        bracketsCount--;
                        if (memory[currCell] != (char)0){
                            moveToOpenBracket();
                        }
                        break;
                }
            }
        }

        private void moveToNextCell() {
            currCell++;
        }

        private void moveToPreviosCell() {
            currCell--;
        }

        private void incrementCurrCell() {
            memory[currCell]++;
        }

        private void decrementCurrCell() {
            memory[currCell]--;
        }

        private void printCurrCell() {
            out.print(memory[currCell]);
        }

        private void readChar() throws IOException {
            memory[currCell] = (char)input.read();
        }

        private void checkForBracket() {
            switch (tokens.get(currTokenIndex)) {
                case OPEN_BRACKET: bracketsCount++; break;
                case CLOSE_BRACKET: bracketsCount--; break;
                default: break;
            }
        }
        private void moveUntilCloseBracket() {
            int neededBrackets = bracketsCount - 1;
            while (bracketsCount != neededBrackets){
                ++currTokenIndex;
                checkForBracket();
            }
        }

        private void moveToOpenBracket() {
            int neededBrackets = bracketsCount + 1;
            while (bracketsCount != neededBrackets) {
                --currTokenIndex;
                checkForBracket();
            }
        }

    }

}
