package Fish;

import java.awt.Point;

public abstract class Emeny {
    private Point position;
    private int WIDTH;
    private int HEIGHT;
    private int score;
    boolean facing_right = true;

    abstract void onDraw();

    abstract void onUpdate();

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

    boolean checkCollide(Player player) {
        Point check_position = new Point(position.x + WIDTH / 2, position.y + HEIGHT / 2);
        boolean overlap_x = check_position.x >= player.getPosition().x
                && check_position.x <= player.getPosition().x + player.getPLAYER_WIDTH();
        boolean overlap_y = check_position.y >= player.getPosition().y
                && check_position.y <= player.getPosition().y + player.getPLAYER_HEIGHT();
        return overlap_x && overlap_y;
    }
}
