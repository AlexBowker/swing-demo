import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Demo Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        window.add(board);
        window.addKeyListener(board);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
