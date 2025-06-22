package main;

import java.util.HashMap;
import java.util.Map;

public class ResourcesManager {
    private static final ResourcesManager resourcesManager = new ResourcesManager();

    private ResourcesManager() {
    };

    public static ResourcesManager getInstance() {
        return resourcesManager;
    }

    private final Map<String, IMAGE> images = new HashMap<>();

    void loadResource(String key, String path, boolean flipped) {
        IMAGE img = new IMAGE();
        img.loadImage(path);
        if (flipped) {
            img.flipImage();
        }
        images.put(key, img);
    }

    public void loadResources() {
        loadResource("menuBackground", "src\\res\\_background5.jpg", false);
        loadResource("backGround", "src\\res\\background.jpg", false);
        loadResource("playerLeft", "src\\res\\playerFish.png", false);
        loadResource("playerRight", "src\\res\\playerFish.png", true);
        loadResource("Emeny_sLeft", "src\\res\\fish1.png", false);
        loadResource("Emeny_sRight", "src\\res\\fish1.png", true);
        loadResource("Emeny_mLeft", "src\\res\\fish2.png", false);
        loadResource("Emeny_mRight", "src\\res\\fish2.png", true);
        loadResource("Emeny_lLeft", "src\\res\\fish3.png", false);
        loadResource("Emeny_lRight", "src\\res\\fish3.png", true);
        loadResource("Emeny_bossLeft", "src\\res\\shark.png", false);
        loadResource("Emeny_bossRight", "src\\res\\shark.png", true);
    }

    public IMAGE getImage(String key) {
        IMAGE img = images.get(key);

        if (img == null || img.getImage() == null) {
            System.out.println(key + "NULL");
        }
        return images.get(key);
    }
}
