package Fish;

import java.awt.Point;
import java.util.Random;

public abstract class Emeny {
    private Point position;
    private int WIDTH;
    private int HEIGHT;
    private int score;
    private int SPEED;
    boolean facing_right;
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

    final void onUpdate() {
        move();
    }

    private void move() {
        Point currentposition = getPosition();
        currentposition.x += (facing_right ? 1 : -1) * SPEED;
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

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int sPEED) {
        SPEED = sPEED;
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
