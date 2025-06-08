package Fish;

import java.awt.Point;

public class Emeny_s extends Emeny {

    private final int SPEED = 10;

    Emeny_s(int WINDOW_width, int WINDOW_height) {
        super(WINDOW_width, WINDOW_height);
    }

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
