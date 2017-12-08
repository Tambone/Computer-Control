package Computer;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

public class Images {
    private File file = null;
    private String path = "";
    private BufferedImage image = null;
    private int numScreens = 0;
    private GraphicsDevice[] screens;
    private Rectangle[] bounds;


    public static int[][] readImage(BufferedImage image) {

        int pixelsX = image.getWidth();
        int pixelsY = image.getHeight();
        int[][] pixels = new int[pixelsY][pixelsX];
        for(int yPos = image.getMinTileY(); yPos < pixelsY; yPos++) {
            for(int xPos = image.getMinTileX(); xPos < pixelsX; xPos++) {
                pixels[yPos][xPos] = image.getRGB(xPos,yPos);
            }
        }
        return pixels;
    }
    public static BufferedImage readURL(String link) {
        BufferedImage image = null;

        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
        }

        return image;
    }

    private void setNumScreens() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        numScreens = screens.length;
        this.screens = screens;
    }
    private Rectangle getScreenBounds(GraphicsDevice screen) {
        return screen.getDefaultConfiguration().getBounds();
    }
}
