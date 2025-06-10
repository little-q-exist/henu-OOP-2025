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

    private final Map<String, IMAGE> images = new HashMap<>();

    void loadResource(String key, String path) {
        IMAGE img = new IMAGE();
        img.loadImage(path);
        images.put(key, img);
    }

    public void loadResources() {
        loadResource("backGround", "src\\res\\background.jpg");
        loadResource("player", "src\\res\\playerFish.png");
    }

    public IMAGE getImage(String key) {
        IMAGE img = images.get(key);

        if (img == null || img.getImage() == null) {
            System.out.println("NULL");
        }
        return images.get(key);
    }
}
