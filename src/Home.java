import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home extends JPanel {
    BufferedImage SnakeIcon;

    public Home(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\Home.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(24*28,16*28 + 10,40,49);
        this.setVisible(true);

    }
    public Home(int x, int y){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\Home.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x,y,40,49);
        this.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}