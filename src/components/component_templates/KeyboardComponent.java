package components.component_templates;

import gameobjects.GameObject;

public abstract class KeyboardComponent {

    public abstract void keyPressed(GameObject object, int k);

    public void keyReleased(GameObject object, int k) { }
}
