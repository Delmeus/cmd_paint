import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String filename;
		if (args.length == 1)
			filename = args[0];
        else {
            filename = null;
        }
        SwingUtilities.invokeLater(() -> {
			new PainterFrame(filename);
		});
	}
//		Painter visitor = new Painter();
//		if (args.length > 1){
//			String filename = args[0];
//			try (BufferedReader reader = new BufferedReader(new FileReader(filename));
//				 Scanner inputScanner = new Scanner(System.in)) {
//				System.out.println("Reading commands from file: " + filename + "\nPress enter to take a step");
//				String line;
//				while ((line = reader.readLine()) != null) {
//					if (!line.trim().isEmpty()) {
//						System.out.print("[Press Enter for next command] ");
//						inputScanner.nextLine();
//						System.out.println("> " + line);
//						processCommand(line, visitor);
//					}
//				}
//			} catch (Exception e) {
//				System.err.println("Error reading file: " + e.getMessage());
//			}
//		} else if (args.length > 0) {
//			String filename = args[0];
//			try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//				System.out.println("Reading commands from file: " + filename + "\nStarting in 2 seconds");
//				String line;
//				Thread.sleep(2000);
//				System.out.println("Starting drawing");
//				while ((line = reader.readLine()) != null) {
//					if (!line.trim().isEmpty()) {
//						System.out.println("> " + line);
//						processCommand(line, visitor);
//						Thread.sleep(500);
//					}
//				}
//			} catch (Exception e) {
//				System.err.println("Error reading file: " + e.getMessage());
//			}
//		}
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("CmdPaint Interactive Mode. Type 'exit' or close the window to quit.");
//
//		while (true) {
//			System.out.print("> ");
//			String inputLine = scanner.nextLine();
//
//			if (inputLine.equalsIgnoreCase("exit")) {
//				System.out.println("Exiting CmdPaint.");
//				break;
//			}
//
//			processCommand(inputLine, visitor);
//		}
//
//		scanner.close();
//	}
//
//	private static void processCommand(String command, Painter visitor) {
//		try {
//			CharStream input = CharStreams.fromString(command);
//			CmdPaintLexer lexer = new CmdPaintLexer(input);
//			CommonTokenStream tokens = new CommonTokenStream(lexer);
//			CmdPaintParser parser = new CmdPaintParser(tokens);
//
//			ParseTree tree = parser.program();
//			visitor.visit(tree);
//		} catch (Exception e) {
//			System.err.println("Error processing command: " + e.getMessage());
//		}
//	}
}
