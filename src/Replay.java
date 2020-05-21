import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Replay extends JPanel {
    BufferedImage SnakeIcon;

    public Replay(int x, int y, int lvl){
        try {
            SnakeIcon = ImageIO.read(new File("src\\Pics\\Replay.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x,y,70,70);
        this.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}