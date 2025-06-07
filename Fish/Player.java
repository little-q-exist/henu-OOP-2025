package Fish;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class Player extends Fish {
    private Point position = new Point(100, 100);
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
        int KeyID = e.getID();
        if (KeyID == KeyEvent.KEY_PRESSED) {
            handleKeyPress(e);
        } else if (KeyID == KeyEvent.KEY_RELEASED) {
            handleKeyRelease(e);
        }

    }

    void handleKeyPress(KeyEvent e) {
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

    void handleKeyRelease(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        switch (KeyCode) {
            case KeyEvent.VK_UP:
                up_key_down = false;
                break;
            case KeyEvent.VK_DOWN:
                down_key_down = false;
                break;
            case KeyEvent.VK_LEFT:
                left_key_down = false;
                break;
            case KeyEvent.VK_RIGHT:
                right_key_down = false;
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
        position.x += ((int) right_key_down - (int) left_key_down) * speed;
    }
}
