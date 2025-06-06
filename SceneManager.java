import Scene.Scene;

public class SceneManager {
    Scene currentScene = null;

    public void setCurrentScene(Scene scene) {
        currentScene = scene;
        currentScene.onEnter();
    }

    public void switchTo(Scene scene) {
        currentScene.onExit();
        currentScene = scene;
        currentScene.onEnter();
    }

    public void onUpdate(long deltaTime) {
        currentScene.onUpdate(deltaTime);
    }

    public void onDraw() {
        currentScene.onDraw();
    }

    public void onInput() {
        currentScene.onInput();
    }
}
