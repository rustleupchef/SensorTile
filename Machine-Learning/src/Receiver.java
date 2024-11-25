import java.io.File;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Receiver {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        while (true) {
            try {
                if (args.length == 0) {
                    Socket socket = new Socket(getVal(0), Integer.valueOf(getVal(1)));
                    byte[] buffer = new byte[1024];
                    int bufferint = socket.getInputStream().read(buffer);
                    String write = new String(buffer, 0, bufferint);
                    JOptionPane.showMessageDialog(frame, "You got a visitor");
                    socket.close();
                }
                else {
                    Socket socket = new Socket(args[0], Integer.valueOf(args[1]));
                    byte[] buffer = new byte[1024];
                    int bufferint = socket.getInputStream().read(buffer);
                    String write = new String(buffer, 0, bufferint);
                    JOptionPane.showMessageDialog(frame, "You got a visitor");
                    socket.close();

                }
            } catch (Exception e) {System.out.println(e.getMessage());}   
        }
    }

    private static String getVal (int index) throws Exception {
        String text = "";
        Scanner scanner = new Scanner(new File("Details.txt"));
        while (scanner.hasNextLine()) {
            text += scanner.nextLine() + "\n";
        }
        return text.split("\n")[index];
    }
}
