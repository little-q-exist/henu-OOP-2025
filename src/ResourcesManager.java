package src;

import java.util.HashMap;
import java.util.Map;

public class ResourcesManager {
    private static final ResourcesManager resourcesManager = new ResourcesManager();

    private ResourcesManager() {
    };

    public static ResourcesManager getInstance() {
        return resourcesManager;
    }

    private static Map<String, IMAGE> images = new HashMap<>();

    void loadResource(String key, String path) {
        IMAGE img = new IMAGE();
        img.loadImage(path);
        images.put(key, img);
    }

    public void loadResources() {
        loadResource("backGround", "res\\background.jpg");
        loadResource("player", "res\\playerFish.png");
    }

    public IMAGE getImage(String key) {
        if (images.get(key) == null) {
            System.out.println("NULL");
        }
        return images.get(key);
    }
}
