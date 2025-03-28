import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Painter visitor = new Painter();

		System.out.println("CmdPaint Interactive Mode. Type 'exit' or close the window to quit.");

		while (true) {
			System.out.print("> ");
			String inputLine = scanner.nextLine();

			if (inputLine.equalsIgnoreCase("exit")) {
				System.out.println("Exiting CmdPaint.");
				break;
			}

			processCommand(inputLine, visitor);
		}

		scanner.close();
	}

	private static void processCommand(String command, Painter visitor) {
		try {
			CharStream input = CharStreams.fromString(command);
			CmdPaintLexer lexer = new CmdPaintLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CmdPaintParser parser = new CmdPaintParser(tokens);

			ParseTree tree = parser.program();
			visitor.visit(tree);
		} catch (Exception e) {
			System.err.println("Error processing command: " + e.getMessage());
		}
	}
}
