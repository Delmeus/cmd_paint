import javax.swing.*;

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
}
