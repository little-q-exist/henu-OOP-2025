package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IMAGE extends JPanel {
    private BufferedImage image = null;
    private int xPos;
    private int yPos;
    private int imgWidth;
    private int imgHeight;

    public BufferedImage getImage() {
        return image;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setProperties(int xPos, int yPos, int imgWidth, int imgHeight) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    public void loadImage(String imgPath) {
        File file = new File(imgPath);
        System.out.println("Loading path:" + file.getAbsolutePath());
        System.out.println(file.exists());

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
