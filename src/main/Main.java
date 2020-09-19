package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;

public class Main {

    public static void main(String[] args) {
	// write your code here
      String source = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
              ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
              "------.--------.>+.>.";
      IInterpretator bf = new BrainfuckInterpretator(System.in, System.out);
      bf.evaluate(source);
    }
}
