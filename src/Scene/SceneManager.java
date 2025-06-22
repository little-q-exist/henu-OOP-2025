package Scene;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class SceneManager {
    private Scene currentScene = null;

    public void setCurrentScene(Scene scene) {
        currentScene = scene;
        currentScene.onEnter();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void switchTo(Scene scene) {
        if (currentScene != null) {
            currentScene.onExit();
        }
        currentScene = scene;
        currentScene.onEnter();
    }

    public void onUpdate(long deltaTime) {
        if (currentScene == null) {
            System.err.println("Scene is null.");
            return;
        }

        currentScene.onUpdate(deltaTime);
    }

    public void keyPressed(KeyEvent e) {
        if (currentScene == null) {
            System.err.println("Scene is null.");
            return;
        }
        currentScene.onKeyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        if (currentScene == null) {
            System.err.println("Scene is null.");
            return;
        }
        currentScene.onKeyReleased(e);
    }

    public JPanel getScenePanel() {
        return currentScene.getScenePanel();
    }
}
