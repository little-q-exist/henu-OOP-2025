package src.Scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

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

    private final int MAX_EMENIES = 15;

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
        large,
        boss
    }

    @Override
    public void onUpdate(long deltaTime) {
        player.onUpdate(emenies, deltaTime);
        Iterator<Emeny> it = emenies.iterator();

        while (it.hasNext()) {
            Emeny emeny = it.next();
            emeny.onUpdate(deltaTime);
            if (emeny.checkDelete(emeny.isFacing_right())) {
                it.remove();
            }
        }

        generateNewEmenies();

        // generateNewEmeny(emenies, 200, new Emeny_boss());

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
        synchronized (emenies) {
            for (Emeny emeny : emenies) {
                IMAGE emenyImage = emeny.onDraw();
                g.drawImage(emenyImage.getImage(), emenyImage.getxPos(), emenyImage.getyPos(), emenyImage.getImgWidth(),
                        emenyImage.getImgHeight(), null);
            }
        }
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
                System.out.println("DEBUG MODE");
                break;
            case KeyEvent.VK_SPACE:
                pause = !pause;
                System.out.println("PAUSED");
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
    private final int Emeny_sGenerateINTERVAL = 250;
    private final int Emeny_mGenerateINTERVAL = 500;
    private final int Emeny_lGenerateINTERVAL = 1500;
    private final int Emeny_bossGenerateINTERVAL = 5000;

    void generateNewEmenies() {
        EmenyGeneratorCount++;

        if (EmenyGeneratorCount % Emeny_sGenerateINTERVAL == 0) {
            generateNewEmeny(EmenyType.small);
        }
        if (EmenyGeneratorCount % Emeny_mGenerateINTERVAL == 0) {
            generateNewEmeny(EmenyType.medium);
        }
        if (EmenyGeneratorCount % Emeny_lGenerateINTERVAL == 0) {
            generateNewEmeny(EmenyType.large);
        }
        if (EmenyGeneratorCount % Emeny_bossGenerateINTERVAL == 0) {
            generateNewEmeny(EmenyType.boss);
        }
        if (EmenyGeneratorCount > Emeny_bossGenerateINTERVAL + 100) {
            EmenyGeneratorCount = 0;
        }
    }

    // 所有敌人生成共享同一个计时器，每个敌人都有自己的时间，到了时间才new，加入列表和画出图像
    void generateNewEmeny(EmenyType type) {

        if (emenies.size() >= MAX_EMENIES) {
            return;
        }

        switch (type) {
            case small:
                Emeny emeny_s = new Emeny_s();

                System.out.println(emeny_s.getPosition());

                emenies.add(emeny_s);
                break;
            case medium:
                Emeny emeny_m = new Emeny_m();
                emenies.add(emeny_m);
                break;
            case large:
                Emeny emeny_l = new Emeny_l();
                emenies.add(emeny_l);
                break;
            case boss:
                Emeny emeny_boss = new Emeny_boss();
                emenies.add(emeny_boss);
                break;
        }

    }
}
