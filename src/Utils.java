package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Utils {
    public class Image extends JPanel {
        private BufferedImage image;
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

        public void loadImage(String imgPath, int x, int y, int imgWidth, int imgHeight) {
            try {
                image = ImageIO.read(new File(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            xPos = x;
            yPos = y;
            this.imgWidth = imgWidth;
            this.imgHeight = imgHeight;
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
