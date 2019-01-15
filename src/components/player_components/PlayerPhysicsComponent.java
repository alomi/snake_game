package components.player_components;

import components.component_templates.PhysicsComponent;
import components.component_templates.StateSpaceComponent;
import entities.Entity;
import main.GamePanel;

public class PlayerPhysicsComponent extends PhysicsComponent {

    @Override
    public void update(Entity object, GamePanel world) {

        StateSpaceComponent state = object.getStateSpace();

        world.handleCollision(state);

        for (int i = 1; i < state.getLength(); i++) {
            if (state.sameState(0, i))
                object.kill();
        }
    }
}
