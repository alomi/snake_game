package drawable.model;

import java.awt.*;

public class SnakeModel extends Model{


    public SnakeModel(int[] xpos, int[] ypos, int size, Color color) {
        super(xpos, ypos, size, color);
    }

    @Override
    protected void drawShape(Graphics g, int n) {
        for (int i = 0; i < n; i++) {
            g.setColor(color);
            if (i == 0) {
                g.setColor(color.brighter());
            }
            g.fillRect(xpos[i], ypos[i], size, size);
        }
    }


}
