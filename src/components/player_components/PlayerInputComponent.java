package components.player_components;

import components.component_templates.InputComponent;
import components.component_templates.StateSpaceComponent;
import entities.Entity;

public class PlayerInputComponent extends InputComponent {

    @Override
    public void update(Entity object) {

        StateSpaceComponent state = object.getStateSpace();

        for (int z = state.getLength(); z > 0; z--) {
            state.setXpos(z, z - 1);
            state.setYpos(z, z - 1);
        }

        state.move();
    }
}
