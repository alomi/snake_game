package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("B4NG");
        setResizable(false);
        setLayout(new BorderLayout());
        add(new GamePanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void run() {
        setVisible(true);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();

    }
}
