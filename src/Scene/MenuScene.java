package Scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.Game;
import main.IMAGE;
import main.ResourcesManager;

public class MenuScene extends Scene {

    private SceneManager sceneManager;

    private IMAGE backgroundImage;

    private int WINDOW_width = Game.getWindowWidth();
    private int WINDOW_height = Game.getWindowHeight();

    public MenuScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void onEnter() {
        backgroundImage = ResourcesManager.getInstance().getImage("menuBackground");
    }

    @Override
    public void onUpdate(long deltaTime) {
    }

    @Override
    public void onDraw(Graphics g) {
        g.drawImage(backgroundImage.getImage(), backgroundImage.getxPos(), backgroundImage.getyPos(),
                WINDOW_width, WINDOW_height, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Press ANY key to Enter", WINDOW_width / 2, WINDOW_height / 2);
    }

    @Override
    public void onExit() {
        backgroundImage = null;
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        sceneManager.switchTo(new GameScene(sceneManager));
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }
}
