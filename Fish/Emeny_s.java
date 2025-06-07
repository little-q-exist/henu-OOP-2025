package Fish;

import java.awt.Point;

public class Emeny_s extends Emeny {

    private final int SPEED = 10;

    @Override
    void onDraw() {
    }

    @Override
    void onUpdate() {
        Point currentposition = getPosition();
        currentposition.x += (facing_right ? 1 : -1) * SPEED;
        setPosition(currentposition);
    }

}
