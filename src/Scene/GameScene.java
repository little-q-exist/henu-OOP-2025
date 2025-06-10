package src.Scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import src.Fish.Player;
import src.Game;
import src.IMAGE;
import src.ResourcesManager;
import src.Fish.Emeny;
import src.Fish.Emeny_boss;
import src.Fish.Emeny_l;
import src.Fish.Emeny_m;
import src.Fish.Emeny_s;

public class GameScene extends Scene {

    private Random random = new Random();
    private SceneManager sceneManager;
    private boolean debug;
    private boolean pause;
    private boolean gameOver = false;

    private Player player;
    private ArrayList<Emeny> emenies = new ArrayList<>();

    public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void onEnter() {
        debug = false;
        pause = false;
        gameOver = false;
        player = new Player();
    }

    enum EmenyType {
        small,
        medium,
        large
    }

    @Override
    public void onUpdate(long deltaTime) {
        player.onUpdate(emenies, deltaTime);
        Iterator<Emeny> it = emenies.iterator();

        while (it.hasNext()) {
            Emeny emeny = it.next();
            emeny.onUpdate(deltaTime);
            if (emeny.checkDelete()) {
                it.remove();
            }
        }

        EmenyType[] EmenyTypes = EmenyType.values();
        int Index = random.nextInt(EmenyTypes.length);
        EmenyType EmenyType = EmenyTypes[Index];
        switch (EmenyType) {
            case small:
                generateNewEmeny(emenies, 20, new Emeny_s());
                break;
            case medium:
                generateNewEmeny(emenies, 10, new Emeny_m());
                break;
            case large:
                generateNewEmeny(emenies, 5, new Emeny_l());
                break;
            default:
                break;
        }

        generateNewEmeny(emenies, 200, new Emeny_boss());

        if (player.isDead()) {
            gameOver = true;
        }
        if (gameOver) {
            // sceneManager.switchTo(new MenuScene(sceneManager));
        }
    }

    private IMAGE playerImage;
    private IMAGE backGroundImage = ResourcesManager.getInstance().getImage("backGround");

    @Override
    public void onDraw(Graphics g) {
        playerImage = player.onDraw();
        g.drawImage(backGroundImage.getImage(), backGroundImage.getxPos(), backGroundImage.getyPos(),
                Game.getWindowWidth(),
                Game.getWindowHeight(), null);
        g.drawImage(playerImage.getImage(), playerImage.getxPos(), playerImage.getyPos(), playerImage.getImgWidth(),
                playerImage.getImgHeight(), null);
    }

    @Override
    public void onExit() {
        debug = false;
        pause = false;
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
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
            player.onKeyPressed(e);
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if (KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_DOWN || KeyCode == KeyEvent.VK_LEFT
                || KeyCode == KeyEvent.VK_RIGHT) {
            player.onKeyReleased(e);
        }
    }

    private long EmenyGeneratorCount = 0;

    void generateNewEmeny(ArrayList<Emeny> emenies, int MAX_INTERVAL, Emeny type) {
        int INTERVAL = random.nextInt(MAX_INTERVAL) + 1;
        if ((++EmenyGeneratorCount) % INTERVAL == 0) {
            emenies.add(type);
        }
    }
}
