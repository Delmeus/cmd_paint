import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
  public static void main(String[] args) throws Exception {
	// create a CharStream that reads from standard input
//	CharStream input = CharStreams.fromStream(System.in);

	CharStream input = CharStreams.fromString("draw \"A\" square (10, 20) size 6 color blue");
//  	CharStream input = CharStreams.fromString("color \"a\" red");

	// create a lexer that feeds off of input CharStream
	CmdPaintLexer lexer = new CmdPaintLexer(input);

	// create a buffer of tokens pulled from the lexer
	CommonTokenStream tokens = new CommonTokenStream(lexer);

	// create a parser that feeds off the tokens buffer
	CmdPaintParser parser = new CmdPaintParser(tokens);

	// start parsing at the program rule
	ParseTree tree = parser.program();
	// System.out.println(tree.toStringTree(parser));

	// create a visitor to traverse the parse tree
	Painter visitor = new Painter();
	System.out.println(visitor.visit(tree));
  }
}