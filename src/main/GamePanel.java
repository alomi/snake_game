package main;

import components.PointsComponent;
import components.component_templates.StateSpaceComponent;
import components.food_components.FoodRenderComponent;
import components.player_components.PlayerInputComponent;
import components.player_components.PlayerKeyboardComponent;
import components.player_components.PlayerPhysicsComponent;
import components.player_components.PlayerRenderComponent;
import contants.Direction;
import entities.Apple;
import entities.Entity;
import entities.Snake;
import util.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static contants.Constants.*;
import static contants.Direction.*;

public class GamePanel extends JPanel implements Runnable {
    private Snake snake;
    private Apple apple;
    private ArrayList<Entity> gameObjects;

    GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(new KeyHandler(this));

        gameObjects = new ArrayList<>();
        createObjects();

        Thread thread = new Thread(this);
        thread.start();
    }

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

    private void createObjects() {
        snake = new Snake(new StateSpaceComponent(900 / 2, 900 / 2, 30, Direction.UP),
                new PlayerInputComponent(), new PlayerPhysicsComponent(),
                new PlayerRenderComponent(new Color(161, 63, 80)),
                new PlayerKeyboardComponent(new HashMap<>() {{
                    put(KeyEvent.VK_A, LEFT);
                    put(KeyEvent.VK_D, RIGHT);
                    put(KeyEvent.VK_W, UP);
                    put(KeyEvent.VK_S, DOWN);
                }}), new PointsComponent(), 3);



        apple = new Apple(new StateSpaceComponent(0, 30, 20, Direction.NONE),
                new FoodRenderComponent(new Color(167, 231, 153)), 1);


        gameObjects.add(snake);
        gameObjects.add(apple);
    }

    private void update() {
        for (Entity obj : gameObjects)
            obj.update(this);
    }

    public void paintComponent(Graphics g) {
        drawBg(g);
        drawGrid(g);

        for (Entity obj : gameObjects)
            obj.draw(g);
    }

    private void drawBg(Graphics g) {
        g.setColor(new Color(118, 118, 121));
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    private void drawGrid(Graphics g) {
        g.setColor(new Color(127, 128, 131));

        for (int i = 0; i < ROWS; i++) {
            g.drawLine(0, i * ROWS, SCREEN_WIDTH, i * ROWS);
            g.drawLine(i * COLS, 0, i * COLS, SCREEN_HEIGHT);
        }
    }

    public void keyPressed(int k) {
        snake.keyPressed(k);
    }

    public void handleCollision(StateSpaceComponent state) {
        if (state.getX() < 0)
            state.setX(SCREEN_WIDTH);

        else if (state.getX() >= SCREEN_WIDTH)
            state.setX(0);

        if (state.getY() < 0)
            state.setY(SCREEN_HEIGHT);

        else if (state.getY() >= SCREEN_HEIGHT)
            state.setY(0);

        if (apple.equalPosition(state)) {
            state.grow();
            apple.despawn();
        }
    }
}