package Fish;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {
    private Point position = new Point(100, 100);
    private int PLAYER_WIDTH;
    private int PLAYER_HEIGHT;
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

    public int getPLAYER_WIDTH() {
        return PLAYER_WIDTH;
    }

    public int getPLAYER_HEIGHT() {
        return PLAYER_HEIGHT;
    }

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

    public void onDraw() {
        int dir_x = (right_key_down - left_key_down);
        if (dir_x > 0) {
            facing_right = 1;
        } else if (dir_x < 0) {
            facing_right = 0;
        }
    }

    public void onUpdate(ArrayList<Emeny> emenies) {
        position.x += (right_key_down - left_key_down) * speed;
        position.y += (down_key_down - up_key_down) * speed;
        for (Emeny emeny : emenies) {
            if (emeny.checkCollide(this)) {
                isDead = true;
            }
        }
    }

}
