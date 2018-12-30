package drawable.food;

import drawable.Drawable;
import java.awt.*;
import java.util.Random;

public class Food implements Drawable {

    public int x, y, width;
    private boolean alive;
    private Color color;

    public Food(int x, int y, int width, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
        alive = false;
    }

    public void update() {
        if (!alive)
            spawn();

    }

    public void despawn() {
        alive = false;
        x = -30;
    }

    public void spawn() {
        Random random = new Random();
        x = random.nextInt(30 - 1) * 30;
        y = random.nextInt(30 - 1) * 30;

        alive = true;
    }

    public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x + width / 4, y + width / 4, width, width);
    }
}
