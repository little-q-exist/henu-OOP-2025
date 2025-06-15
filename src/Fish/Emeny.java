package src.Fish;

import src.Game;
import src.IMAGE;

import java.awt.Point;
import java.util.Random;

public abstract class Emeny {
    private Point position;
    private int WIDTH;
    private int HEIGHT;
    private int score;
    private double SPEED;
    private boolean isDead = false;
    private boolean Invincible;

    private boolean facing_right;

    private Random random = new Random();

    enum spawPosition {
        left,
        right
    }

    Emeny() {
        position = new Point();

        spawPosition[] edges = spawPosition.values();
        int Index = random.nextInt(edges.length);
        spawPosition edge = edges[Index];
        switch (edge) {
            case left:
                facing_right = true;
                position.x = -WIDTH;
                position.y = random.nextInt(Game.getWindowHeight() - HEIGHT);
                break;
            case right:
                facing_right = false;
                position.x = Game.getWindowWidth();
                position.y = random.nextInt(Game.getWindowHeight() - HEIGHT);
            default:
                break;
        }
    }

    abstract public IMAGE onDraw();

    final public void onUpdate(long deltaTime) {
        move(deltaTime);
        // emenies own logic
    }

    private void move(long deltaTime) {
        position.x += (facing_right ? 1 : -1) * SPEED * deltaTime;
    }

    public boolean checkDelete(boolean facing_right) {
        return isDead() || isOutOfBounds(facing_right);
    }

    private boolean isOutOfBounds(boolean facing_right) {
        boolean outOfBounds_x;
        if (facing_right) {
            outOfBounds_x = position.x > Game.getWindowWidth();
        } else {
            outOfBounds_x = position.x + WIDTH < 0;
        }
        return outOfBounds_x;
    }

    public Point getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public double getSPEED() {
        return SPEED;
    }

    public void setSPEED(double sPEED) {
        SPEED = sPEED;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int wIDTH) {
        WIDTH = wIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public boolean isInvincible() {
        return Invincible;
    }

    public void setInvincible(boolean invincible) {
        Invincible = invincible;
    }

    public boolean isFacing_right() {
        return facing_right;
    }

    boolean checkCollide(Player player) {
        int rect1X = position.x;
        int rect1Y = position.y;
        int rect1Width = WIDTH;
        int rect1Height = HEIGHT;
        int rect2X = player.getPosition().x;
        int rect2Y = player.getPosition().y;
        int rect2Width = player.getPLAYER_WIDTH();
        int rect2Height = player.getPLAYER_HEIGHT();

        return rect1X < rect2X + rect2Width &&
                rect1X + rect1Width > rect2X &&
                rect1Y < rect2Y + rect2Height &&
                rect1Y + rect1Height > rect2Y;
    }
}
