package components.component_templates;

import java.awt.*;

public abstract class RenderComponent {

    protected Color color;

    public RenderComponent(Color color) {
        this.color = color;
    }

    public abstract void draw(StateSpaceComponent state, Graphics g);
}
