package Scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public abstract class Scene {

    protected JPanel scenePanel;

    Scene() {
        scenePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                onDraw(g);
            }
        };
    }

    abstract void onEnter();

    abstract void onUpdate(long deltaTime);

    abstract void onDraw(Graphics g);

    abstract void onExit();

    abstract void onKeyPressed(KeyEvent e);

    abstract void onKeyReleased(KeyEvent e);

    public JPanel getScenePanel() {
        return scenePanel;
    }
}
