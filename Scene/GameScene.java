package Scene;

import java.awt.event.KeyEvent;

public class GameScene implements Scene {

    private boolean debug;
    private boolean pause;

    @Override
    public void onEnter() {
        debug = false;
        pause = false;
    }

    @Override
    public void onUpdate(long deltaTime) {
    }

    @Override
    public void onDraw() {
    }

    @Override
    public void onInput(KeyEvent e) {
    }

    @Override
    public void onExit() {
    }

    @Override
    public void handleKeyPress(KeyEvent e) {

    }

    @Override
    public void handleKeyRelease(KeyEvent e) {
    }
}
