package Fish;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class Player extends Fish {
    private Point position;
    private Point size;
    private final int MIN_SPEED = 10;
    private final int MAX_SPEED = 20;
    private int speed;
    private boolean up_key_down = false;

    public Point getPosition() {
        return position;
    }

    public Point getSize() {
        return size;
    }

    @Override
    public void onInput(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        switch (KeyCode) {
            case KeyEvent.VK_UP:

                break;

            default:
                break;
        }
    }

    @Override
    public void onDraw() {

    }

    @Override
    public void onUpdate() {

    }
}
