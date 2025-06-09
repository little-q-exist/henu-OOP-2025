package src.Scene;

import java.awt.event.KeyEvent;

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
        if (currentScene == null)
            return;

        currentScene.onUpdate(deltaTime);
    }

    public void onDraw() {
        if (currentScene == null)
            return;
        currentScene.onDraw();
    }

    public void keyPressed(KeyEvent e) {
        currentScene.onKeyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        currentScene.onKeyReleased(e);
    }
}
