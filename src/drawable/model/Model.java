package drawable.model;

import java.awt.*;

public abstract class Model {

    private int x;
    private int y;

    int[] xpos;
    int[] ypos;

    int size;
    Color color;

    Model(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    Model(int [] xpos, int[] ypos, int size, Color color) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.color = color;
        this.size = size;
    }

    public void draw(Graphics g, int n) {
        g.setColor(color);
        drawShape(g, n);
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setXpos(int[] xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int[] ypos){
        this.ypos = ypos;
    }

    protected void drawShape(Graphics g){};
    protected void drawShape(Graphics g, int i){};
}
