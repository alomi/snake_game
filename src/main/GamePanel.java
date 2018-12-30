package main;

import components.food_components.FoodRenderComponent;
import components.player_components.PlayerInputComponent;
import components.player_components.PlayerKeyboardComponent;
import components.player_components.PlayerPhysicsComponent;
import components.player_components.PlayerRenderComponent;
import components.component_templates.StateSpaceComponent;
import gameobjects.Apple;
import contants.Direction;
import gameobjects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static contants.Constants.*;


public class GamePanel extends JPanel implements Runnable, KeyListener {
    //private Snake snake;
    private Snake snake;
    private Apple apple;
    private boolean moved = false;

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        snake = new Snake(new StateSpaceComponent(900 / 2, 900 / 2, 30, Direction.UP),
                new PlayerInputComponent(), new PlayerPhysicsComponent(),
                new PlayerRenderComponent(new Color(161, 63, 80)),
                new PlayerKeyboardComponent());

        apple = new Apple(new StateSpaceComponent(0, 0, 20, Direction.NONE),
                new FoodRenderComponent(new Color(167, 231, 153)));

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
        apple.update(this);
        snake.update(this);
    }

    public void paintComponent(Graphics g) {
        drawBg(g);
        drawGrid(g);

        apple.draw(g);
        snake.draw(g);

        moved = false;
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

    public void handleCollision(StateSpaceComponent state) {
        if (apple.stateSpace.xpos[0] == state.xpos[0] && apple.stateSpace.ypos[0] == state.ypos[0]) {
            state.grow();
            apple.despawn();
        }

        if (state.xpos[0] < 0)
            state.xpos[0] = SCREEN_WIDTH;

        else if (state.xpos[0] >= SCREEN_WIDTH)
            state.xpos[0] = 0;

        if (state.ypos[0] < 0)
            state.ypos[0] = SCREEN_HEIGHT;

        else if (state.ypos[0] >= SCREEN_HEIGHT)
            state.ypos[0] = 0;
    }
}