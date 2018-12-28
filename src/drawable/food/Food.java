package drawable.food;

import drawable.Drawable;

import java.awt.*;
import java.util.Random;

public class Food implements Drawable {

    public int x, y, width;
    private boolean alive;

    public Food(int x, int y, int width, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        alive = false;
    }

    public void update() {
        if (!alive)
            spawn();

    }

    public void despawn() {
        alive = false;
    }

    public void spawn() {
        Random random = new Random();
        x = random.nextInt(30 - 1) * 30;
        y = random.nextInt(30 - 1) * 30;

        alive = true;
    }

    public void draw(Graphics g) {
        if (alive) {
            g.setColor(Color.green);
            g.fillRect(x, y, width, width);
        }

    }
}
