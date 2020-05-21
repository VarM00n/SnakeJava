import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EasyEnchanced extends JPanel {
    BufferedImage SnakeIcon;

    public EasyEnchanced(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\EasyEnchanced.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(0,0,744,448);
        setVisible(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}
