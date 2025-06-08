package src.Scene;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import src.Fish.Player;
import src.Fish.Emeny;
import src.Fish.Emeny_boss;
import src.Fish.Emeny_l;
import src.Fish.Emeny_m;
import src.Fish.Emeny_s;

public class GameScene implements Scene {

    private Random random = new Random();
    private SceneManager sceneManager = new SceneManager();
    private boolean debug;
    private boolean pause;
    private boolean gameOver = false;

    private Player player;
    private ArrayList<Emeny> emenies = new ArrayList<>();

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
            sceneManager.switchTo(new MenuScene());
        }
        System.out.println("UPDATING");
    }

    @Override
    public void onDraw() {
    }

    @Override
    public void onExit() {
        debug = false;
        pause = false;
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

    private long EmenyGeneratorCount = 0;

    void generateNewEmeny(ArrayList<Emeny> emenies, int MAX_INTERVAL, Emeny type) {
        int INTERVAL = random.nextInt(MAX_INTERVAL) + 1;
        if ((++EmenyGeneratorCount) % INTERVAL == 0) {
            emenies.add(type);
        }
    }
}
