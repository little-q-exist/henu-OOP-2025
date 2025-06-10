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
    private final int MAX_EMENIES = 50;

    private SceneManager sceneManager;
    private boolean debug;
    private boolean pause;
    private boolean gameOver = false;

    private Player player;
    private ArrayList<Emeny> emenies = new ArrayList<>();
    private ArrayList<IMAGE> emenyImages = new ArrayList<>();

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

        if (emenies.size() < MAX_EMENIES) {
            EmenyType[] EmenyTypes = EmenyType.values();
            int Index = random.nextInt(EmenyTypes.length);
            EmenyType EmenyType = EmenyTypes[Index];
            synchronized (emenyImages) {
                switch (EmenyType) {
                    case small:
                        Emeny emeny_s = new Emeny_s();
                        generateNewEmeny(emenies, 2000, 3500, emeny_s);
                        emenyImages.add(emeny_s.onDraw());
                        break;
                    case medium:
                        Emeny emeny_m = new Emeny_m();
                        generateNewEmeny(emenies, 3000, 5000, emeny_m);
                        emenyImages.add(emeny_m.onDraw());
                        break;
                    case large:
                        Emeny emeny_l = new Emeny_l();
                        generateNewEmeny(emenies, 5000, 7500, emeny_l);
                        emenyImages.add(emeny_l.onDraw());
                        break;
                    default:
                        break;
                }
            }
        }

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
        synchronized (emenyImages) {
            for (IMAGE emenyImage : emenyImages) {
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

    void generateNewEmeny(ArrayList<Emeny> emenies, int MIN_INTERVAL, int MAX_INTERVAL, Emeny type) {
        int INTERVAL = random.nextInt(MAX_INTERVAL) + MIN_INTERVAL;
        if ((++EmenyGeneratorCount) % INTERVAL == 0) {
            emenies.add(type);
        }
    }
}
