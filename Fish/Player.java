package Fish;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class Player extends Fish {
    private Point position = new Point(100, 100);
    private Point size;
    private final int MIN_SPEED = 10;
    private final int MAX_SPEED = 20;
    private int speed;
    private int up_key_down = 0;
    private int down_key_down = 0;
    private int left_key_down = 0;
    private int right_key_down = 0;
    int facing_right = 1;
    private boolean isDead = false;

    public boolean isDead() {
        return isDead;
    }

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
                up_key_down = 1;
                break;
            case KeyEvent.VK_DOWN:
                down_key_down = 1;
                break;
            case KeyEvent.VK_LEFT:
                left_key_down = 1;
                break;
            case KeyEvent.VK_RIGHT:
                right_key_down = 1;
                break;
            default:
                break;
        }
    }

    void handleKeyRelease(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        switch (KeyCode) {
            case KeyEvent.VK_UP:
                up_key_down = 0;
                break;
            case KeyEvent.VK_DOWN:
                down_key_down = 0;
                break;
            case KeyEvent.VK_LEFT:
                left_key_down = 0;
                break;
            case KeyEvent.VK_RIGHT:
                right_key_down = 0;
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
        int direction = right_key_down - left_key_down;
        position.x += (right_key_down - left_key_down) * speed;
        position.y += (down_key_down - up_key_down) * speed;
    }
}
