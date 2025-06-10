package src;

import java.util.HashMap;
import java.util.Map;

import src.Utils.IMAGE;

public class ResourcesManager {
    private static Map<String, IMAGE> images = new HashMap<>();

    public static void loadResource(String key, String path) {
        IMAGE img = new IMAGE();
        img.loadImage(path);
        images.put(key, img);
    }

    public static void loadResources() {
        loadResource("backGround", "src\\res\\background.jpg");
        loadResource("player", "src\\res\\playerFish.png");
    }
}
