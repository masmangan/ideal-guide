import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestExample {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("input.txt");
        ExampleLexer lexer = new ExampleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExampleParser parser = new ExampleParser(tokens);

        ParseTree tree = parser.prog();  
        System.out.println(tree.toStringTree(parser));
    }
}