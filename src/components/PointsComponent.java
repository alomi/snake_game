package components;

import entities.Entity;

import java.awt.*;

import static contants.Constants.SCREEN_WIDTH;

public class PointsComponent {

    public void draw(Entity object, Graphics g){
        // TODO : OM objekt är nära öka alfa på färgen

        g.setColor(new Color(138, 138, 142,70));
        g.fillRect(SCREEN_WIDTH / 2 - 150, 0, 300, 50);
    }
}
