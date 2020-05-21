import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logo extends JPanel {
    BufferedImage SnakeIcon;

    public Logo(){
        try {
            SnakeIcon = ImageIO.read(new File("src\\Pics\\LogoForMenu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(12*28,16*28 + 10,50,50);
        this.setVisible(true);
    }

    public Logo(int i, int i1) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}