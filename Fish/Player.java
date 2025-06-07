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
    private boolean down_key_down = false;
    private boolean left_key_down = false;
    private boolean right_key_down = false;
    boolean facing_right = true;

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
                up_key_down = true;
                break;
            case KeyEvent.VK_DOWN:
                down_key_down = true;
                break;
            case KeyEvent.VK_LEFT:
                left_key_down = true;
                break;
            case KeyEvent.VK_RIGHT:
                right_key_down = true;
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
