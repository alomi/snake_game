package components.component_templates;

import gameobjects.GameObject;
import main.GamePanel;

public abstract class PhysicsComponent {

    public abstract void update(GameObject object, GamePanel world);
}
