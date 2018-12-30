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


        for (int i = 0; i < state.length; i++) {
            g.setColor(color);

            if (i == 0)
                g.setColor(color.brighter());

            g.fillRect(state.xpos[i], state.ypos[i], state.size, state.size);
        }
    }
}
