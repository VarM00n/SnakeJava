import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {
    BufferedImage background;

    public Board(){
        try {
            background = ImageIO.read(new File("src\\Pics\\SnakeBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0,0, null);
    }
}
