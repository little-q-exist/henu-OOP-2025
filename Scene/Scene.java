package Scene;

import java.awt.event.KeyEvent;

public interface Scene {
    void onEnter();

    void onUpdate(long deltaTime);

    void onDraw();

    void onInput();

    void onExit();

    void handleKeyPress(KeyEvent e);

    void handleKeyRelease(KeyEvent e);

}
