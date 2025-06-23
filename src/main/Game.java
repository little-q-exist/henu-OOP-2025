package main;

import javax.swing.JFrame;

import Scene.MenuScene;
import Scene.SceneManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    static final int WINDOW_width = 1440;
    static final int WINDOW_height = 900;
    final int FPS = 60;
    final String title = "¥Û”„≥‘–°”„";

    private SceneManager sceneManager;

    private BackGroundMusic bgm;

    Game() {
        sceneManager = new SceneManager(this);
    }

    public String gettitle() {
        return title;
    }

    public int getFPS() {
        return FPS;
    }

    public static int getWindowWidth() {
        return WINDOW_width;
    }

    public static int getWindowHeight() {
        return WINDOW_height;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        sceneManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        sceneManager.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // reserved for type input
    }

    public void launch() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(WINDOW_width, WINDOW_height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(gettitle());

        this.addKeyListener(this);
        this.requestFocus();

        ResourcesManager.getInstance().loadBgm();
        bgm = ResourcesManager.getInstance().getBgm();
        bgm.loop();

        ResourcesManager.getInstance().loadResources();

        long lastTime = System.currentTimeMillis();

        sceneManager.setCurrentScene(new MenuScene(sceneManager));

        while (true) {
            long currentTime = System.currentTimeMillis();
            long deltaTime = (currentTime - lastTime);
            lastTime = currentTime;

            sceneManager.onUpdate(deltaTime);

            add(sceneManager.getScenePanel());

            this.revalidate();
            this.repaint();

            if (deltaTime < 1000 / FPS) {
                try {
                    Thread.sleep((1000 / FPS) - deltaTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Game loop interrupted: " + e.getMessage());
                    break;
                }
            }
        }
    }
}
