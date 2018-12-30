package components.food_components;

import components.component_templates.RenderComponent;
import components.component_templates.StateSpaceComponent;

import java.awt.*;

public class FoodRenderComponent extends RenderComponent {

    public FoodRenderComponent(Color color) {
        super(color);
    }

    @Override
    public void draw(StateSpaceComponent state, Graphics g) {
        g.setColor(color);
        g.fillOval(state.xpos[0] + state.size / 4,
                state.ypos[0] + state.size / 4,
                state.size, state.size);
    }
}
