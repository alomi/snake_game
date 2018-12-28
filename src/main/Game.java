package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;

    public Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("B4NG");
        setResizable(false);
        setLayout(new BorderLayout());
        add(new GamePanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void run(){
        setVisible(true);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();

    }
}
