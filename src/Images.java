import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Images {
    File file;
    String path;
    BufferedImage image;
    private int numScreens = 0;
    private GraphicsDevice[] screens;
    private Rectangle[] bounds;
    public Images(String path) throws  IOException{
        this.path = path;
        file = new File(path);
        image = ImageIO.read(file);
    }
    public int[] readImage() {
        int pixelCount = 0;
        int pixelsX = image.getWidth();
        int pixelsY = image.getHeight();
        int[] pixels = new int[pixelsX * pixelsY];
        for(int yPos = image.getMinTileY(); yPos < pixelsY; yPos++) {
            for(int xPos = image.getMinTileX(); xPos < pixelsX; xPos++) {
                pixels[pixelCount] = image.getRGB(xPos,yPos);
                pixelCount++;
            }
        }
        return pixels;
    }

    private void getNumScreens() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        numScreens = screens.length;
        this.screens = screens;
    }
    private Rectangle getScreenBounds(GraphicsDevice screen) {
        return screen.getDefaultConfiguration().getBounds();
    }
}
