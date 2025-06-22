package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IMAGE extends JPanel {
    private BufferedImage image = null;
    private int xPos = 0;
    private int yPos = 0;
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

    public int getImgWidth() {
        return imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
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
        } else {
            imgWidth = image.getWidth();
            imgHeight = image.getHeight();
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

    public void flipImage() {
        BufferedImage flipped = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        Graphics2D g = flipped.createGraphics();

        AffineTransform transform = new AffineTransform();
        transform.translate(imgWidth, 0);
        transform.scale(-1, 1);
        g.setTransform(transform);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        image = flipped;
    }

}
