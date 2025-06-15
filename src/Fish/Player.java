package src.Fish;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import src.Game;
import src.IMAGE;
import src.ResourcesManager;

public class Player {
    private Point position = new Point(Game.getWindowWidth() / 2, Game.getWindowHeight() / 2);
    private int PLAYER_HEIGHT = 50;
    private final double SizePercent = 163 / 133.0;
    private int PLAYER_WIDTH = (int) (PLAYER_HEIGHT * SizePercent);

    private final double MIN_SPEED = 0.5f;
    private final double MAX_SPEED = 1.1f;
    private double speed = MAX_SPEED;
    private int up_key_down = 0;
    private int down_key_down = 0;
    private int left_key_down = 0;
    private int right_key_down = 0;
    private int facing_right = 1;
    private boolean isDead = false;
    private int score = 2;

    private boolean debug = false;

    private IMAGE playerImage;

    public int getScore() {
        return score;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void setDead() {
        isDead = true;
    }

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

    public void setSize(int Height) {
        PLAYER_HEIGHT = Height;
        PLAYER_WIDTH = (int) (PLAYER_HEIGHT * SizePercent);
    }

    public void onKeyPressed(KeyEvent e) {
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

    public void onKeyReleased(KeyEvent e) {
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

    public IMAGE onDraw() {
        int dir_x = (right_key_down - left_key_down);
        if (dir_x > 0) {
            facing_right = 1;
        } else if (dir_x < 0) {
            facing_right = 0;
        }
        playerImage = ResourcesManager.getInstance().getImage((facing_right == 1 ? "playerRight" : "playerLeft"));
        playerImage.setProperties(position.x, position.y, PLAYER_WIDTH, PLAYER_HEIGHT);
        if (playerImage == null) {
            System.out.println("Playerimage null");
        }
        return playerImage;
    }

    public void onUpdate(ArrayList<Emeny> emenies, long deltaTime) {
        position.x += (right_key_down - left_key_down) * speed * deltaTime;
        position.y += (down_key_down - up_key_down) * speed * deltaTime;

        if (position.x < 0)
            position.x = 0;
        if (position.y < 0)
            position.y = 0;
        if (position.x + PLAYER_WIDTH > Game.getWindowWidth())
            position.x = Game.getWindowWidth() - PLAYER_WIDTH;
        if (position.y + PLAYER_HEIGHT > Game.getWindowHeight())
            position.y = Game.getWindowHeight() - PLAYER_HEIGHT;

        synchronized (emenies) {
            for (Emeny emeny : emenies) {
                if (emeny.checkCollide(this)) {
                    if (score < emeny.getScore() || emeny.isInvincible()) {
                        setDead();
                    } else {
                        score++;
                        if (score >= 15) {
                            setSize(120);
                        } else if (score >= 8) {
                            setSize(90);
                        }
                        if (speed > MIN_SPEED) {
                            speed -= 0.05f;
                        }
                        emeny.setDead();
                    }
                }
            }
        }

        if (debug) {
            if (right_key_down == 1 || down_key_down == 1 || left_key_down == 1 || up_key_down == 1) {
                System.out.println("playerPosition :" + position.x + "," + position.y);
                System.out.println("playerSpeed :" + speed);
            }
        }
    }

}
