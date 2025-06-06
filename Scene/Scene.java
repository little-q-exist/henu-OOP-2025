package Scene;

public interface Scene {
    void onEnter();

    void onUpdate(long deltaTime);

    void onDraw();

    void onInput();

    void onExit();
}
