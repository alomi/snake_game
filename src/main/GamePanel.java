package main;

import drawable.Drawable;
import drawable.food.Food;
import drawable.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

import static contants.Constants.*;


public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Snake snake;
    private Food food;
    private ArrayList<Drawable> gameObjects;
    private boolean moved = false;

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        snake = new Snake(900 / 2, 900 / 2, 30, Color.red);
        food = new Food(0, 0, 30, Color.green);

        gameObjects = new ArrayList<>();
        gameObjects.add(snake);
        gameObjects.add(food);

        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        int FPS = 10;
        long start, elapsed, wait, targetTime;
        targetTime = 1000 / FPS;


        while (true) {
            update();
            repaint();

            start = System.nanoTime();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;

            if (wait <= 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        food.update();

        if (snake.isAlive())
            snake.update(food);
    }

    public void paintComponent(Graphics g) {
        drawBg(g);
        drawGrid(g);

        for (Drawable d : gameObjects) {
            d.draw(g);
        }

        moved = false;
    }

    private void drawBg(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    private void drawGrid(Graphics g) {
        g.setColor(new Color(225, 226, 231));

        for (int i = 0; i < ROWS; i++) {
            g.drawLine(0, i * ROWS, SCREEN_WIDTH, i * ROWS);
            g.drawLine(i * COLS, 0, i * COLS, SCREEN_HEIGHT);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!moved)
            snake.keyPressed(e.getKeyCode());

        moved = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //drawable.snake.keyReleased(e.getKeyCode());
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
}