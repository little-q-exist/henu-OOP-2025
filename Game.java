import javax.swing.JFrame;

import Scene.MenuScene;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
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
            long deltaTime = (currentTime - lastTime);
            lastTime = currentTime;

            sceneManager.onUpdate(deltaTime);
            sceneManager.onDraw();

            if (deltaTime < 1000 / FPS) {
                try {
                    Thread.sleep((1000 / FPS) - deltaTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // ª÷∏¥÷–∂œ◊¥Ã¨
                    System.err.println("Game loop interrupted: " + e.getMessage());
                    break;
                }
            }
        }
    }
}
