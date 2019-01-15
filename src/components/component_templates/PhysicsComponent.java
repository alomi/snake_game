package components.component_templates;

import entities.Entity;
import main.GamePanel;

public abstract class PhysicsComponent extends Component {

    public abstract void update(Entity object, GamePanel world);
}
