package main;

import static org.junit.jupiter.api.Assertions.*;
class BrainfuckInterpretatorTest {

    static void evaluate_no_error(){
        String source = "";
        IInterpretator bf = new BrainfuckInterpretator(System.in, System.out);
        bf.evaluate(source);
        System.out.println((char)41);
    }
}