package components.component_templates;

import contants.Direction;

import static contants.Constants.SCREEN_WIDTH;

public class StateSpaceComponent {

    public int[] xpos;
    public int[] ypos;
    public int size;
    public int length;
    public Direction direction;

    public StateSpaceComponent(int x, int y, int size, Direction direction){
        xpos = new int[SCREEN_WIDTH];
        ypos = new int[SCREEN_WIDTH];

        xpos[0] = x;
        ypos[0] = y;

        length++;

        this.size = size;
        this.direction = direction;
    }

    public void grow(){
        xpos[length + 1] = xpos[length] + size;
        ypos[length + 1] = ypos[length] + size;
        length++;
    }

}
