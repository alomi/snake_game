package components.player_components;

import components.component_templates.RenderComponent;
import components.component_templates.StateSpaceComponent;

import java.awt.*;

public class PlayerRenderComponent extends RenderComponent {


    public PlayerRenderComponent(Color color) {
        super(color);
    }

    @Override
    public void draw(StateSpaceComponent state, Graphics g) {

        int[] xpos = state.getXpos();
        int[] ypos = state.getYpos();

        for (int i = 0; i < state.getLength(); i++) {
            g.setColor(color);

            if (i == 0)
                g.setColor(color.brighter());

            g.fillRect(xpos[i], ypos[i], state.getSize(), state.getSize());
        }
    }
}
