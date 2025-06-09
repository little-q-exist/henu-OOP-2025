package src.Scene;

import java.awt.event.KeyEvent;

public interface Scene {
    void onEnter();

    void onUpdate(long deltaTime);

    void onDraw();

    void onExit();

    void onKeyPressed(KeyEvent e);

    void onKeyReleased(KeyEvent e);
}
