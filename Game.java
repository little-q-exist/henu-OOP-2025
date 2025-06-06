import javax.swing.JFrame;

import Scene.GameScene;
import Scene.MenuScene;
import Scene.SelectorScene;

public class Game extends JFrame {
    int width = 1440;
    int height = 900;
    final int FPS = 60;
    final String title = "¥Û”„≥‘–°”„";

    SceneManager sceneManager;

    Game() {
        sceneManager = new SceneManager();

        sceneManager.setCurrentScene(new MenuScene());
    }

    String gettitle() {
        return title;
    }

    int getFPS() {
        return FPS;
    }

    public void launch() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(gettitle());

        long lastTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            repaint();

        }
    }
}
