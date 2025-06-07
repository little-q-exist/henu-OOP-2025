package Scene;

import java.awt.event.KeyEvent;

import Fish.Player;

public class GameScene implements Scene {

    private boolean debug;
    private boolean pause;

    private Player player;

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
    public void onExit() {
    }

    @Override
    public void handleKeyPress(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        switch (KeyCode) {
            case KeyEvent.VK_Q:
                debug = !debug;
                break;
            case KeyEvent.VK_SPACE:
                pause = !pause;
                break;
            default:
                break;
        }
        if (KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_DOWN || KeyCode == KeyEvent.VK_LEFT
                || KeyCode == KeyEvent.VK_RIGHT) {
            player.onInput(e);
        }
    }

    @Override
    public void handleKeyRelease(KeyEvent e) {
    }
}
