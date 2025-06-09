package src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Utils extends JPanel {
    public class ImageUtils {
        private BufferedImage image;

        public ImageUtils(String imgPath) {
            try {
                image = ImageIO.read(new File(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
