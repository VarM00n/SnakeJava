import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Name extends JPanel {
    BufferedImage SnakeIcon;

    public Name(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\SnakeLogo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(6*28,4*28,392,168);
        this.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}
