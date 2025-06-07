package Scene;

import java.awt.event.KeyEvent;

public interface Scene {
    void onEnter();

    void onUpdate(long deltaTime);

    void onDraw();

    default void onInput(KeyEvent e) {
        int KeyID = e.getID();
        if (KeyID == KeyEvent.KEY_PRESSED) {
            handleKeyPress(e);
        } else if (KeyID == KeyEvent.KEY_RELEASED) {
            handleKeyRelease(e);
        }
    }

    void onExit();

    void handleKeyPress(KeyEvent e);

    void handleKeyRelease(KeyEvent e);

}
