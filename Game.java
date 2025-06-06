import javax.swing.JFrame;

public class Game extends JFrame {
    int width = 1440;
    int height = 900;
    final int FPS = 60;
    final String title = "¥Û”„≥‘–°”„";

    Game() {

    }

    String gettitle() {
        return title;
    }

    public void launch() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(gettitle());

        while (true) {

            repaint();

        }
    }
}
