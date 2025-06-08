package src.Fish;

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

    Emeny(int WINDOW_width, int WINDOW_height) {
        spawPosition[] edges = spawPosition.values();
        int Index = random.nextInt(edges.length);
        spawPosition edge = edges[Index];
        switch (edge) {
            case left:
                facing_right = true;
                position.x = -WIDTH;
                position.y = random.nextInt(WINDOW_height - HEIGHT);
                break;
            case right:
                facing_right = false;
                position.x = WINDOW_width;
                position.y = random.nextInt(WINDOW_height - HEIGHT);
            default:
                break;
        }
    }

    abstract void onDraw();

    final public void onUpdate(long deltaTime) {
        move(deltaTime);
        // emenies own logic
    }

    private void move(long deltaTime) {
        Point currentposition = getPosition();
        currentposition.x += (facing_right ? 1 : -1) * SPEED * deltaTime;
        setPosition(currentposition);
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

    boolean checkCollide(Player player) {
        Point check_position = new Point(position.x + WIDTH / 2, position.y + HEIGHT / 2);
        boolean overlap_x = check_position.x >= player.getPosition().x
                && check_position.x <= player.getPosition().x + player.getPLAYER_WIDTH();
        boolean overlap_y = check_position.y >= player.getPosition().y
                && check_position.y <= player.getPosition().y + player.getPLAYER_HEIGHT();
        return overlap_x && overlap_y;
    }
}
