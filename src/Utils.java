package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Utils {
    public static class IMAGE extends JPanel {
        private BufferedImage image = null;
        private int xPos;
        private int yPos;
        private int imgWidth;
        private int imgHeight;

        public int getxPos() {
            return xPos;
        }

        public int getyPos() {
            return yPos;
        }

        public void loadImage(String imgPath) {
            try {
                image = ImageIO.read(new File(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image == null) {
                System.err.println("Failed to load image.");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, xPos, yPos, imgWidth, imgHeight, this);
            } else {
                System.err.println("Image is null.");
            }
        }

    }
}
