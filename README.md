# brainfuck-interpretator-java
Simple Brainfuck language interpretator with tokenization written in java

## usage: 



```java
      String source = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
      IInterpretator bf = new BrainfuckInterpretator(System.in, System.out);
      bf.evaluate(source);
```     
