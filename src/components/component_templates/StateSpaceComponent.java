package components.component_templates;

import contants.Direction;

import static contants.Constants.SCREEN_WIDTH;

public class StateSpaceComponent {

    private int[] xpos;
    private int[] ypos;
    private int size;
    private int length;
    private Direction direction;

    public StateSpaceComponent(int x, int y, int size, Direction direction) {
        xpos = new int[SCREEN_WIDTH];
        ypos = new int[SCREEN_WIDTH];

        xpos[0] = x;
        ypos[0] = y;

        length++;

        this.size = size;
        this.direction = direction;
    }

    public void grow() {
        xpos[length + 1] = xpos[length] + size;
        ypos[length + 1] = ypos[length] + size;
        length++;
    }

    public int[] getXpos(){
        return xpos;
    }

    public int[] getYpos(){
        return ypos;
    }

    public int getX(){
        return xpos[0];
    }

    public int getY(){
        return ypos[0];
    }

    public int getSize(){
        return size;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength(){
        return length;
    }

    public void setX(int x){
        xpos[0] = x;
    }

    public void setY(int y){
        ypos[0] = y;
    }

    public void setXpos(int at, int to){
        xpos[at] = xpos[to];
    }

    public void setYpos(int at, int to) {
        ypos[at] = ypos[to];
    }

    public void move() {
        switch (direction) {
            case RIGHT:
                xpos[0] += size;
                break;

            case LEFT:
                xpos[0] -= size;
                break;

            case DOWN:
                ypos[0] += size;
                break;

            case UP:
                ypos[0] -= size;
                break;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean sameState(int a, int b) {
        return xpos[a] == xpos[b] && ypos[a] == ypos[b];
    }

    public boolean samePosition(StateSpaceComponent other){
        return xpos[0] == other.getX() && ypos[0] == other.getY();
    }

    public boolean sameDirection(StateSpaceComponent other){
        return direction == other.direction;
    }

    public boolean equals(StateSpaceComponent other){
        return sameDirection(other) && samePosition(other);
    }

    public void setLength(int length) {
        this.length = length;
    }
}
