import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hard extends JPanel {
    BufferedImage SnakeIcon;

    public Hard(){
        try {
            SnakeIcon = ImageIO.read(new File("src\\Pics\\Hard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(16*28,16*28 + 3,136,77);
        this.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}