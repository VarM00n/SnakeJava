import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fruit extends JPanel {
    BufferedImage SnakeIcon;
    int x;
    int y;
    public Fruit(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\Snake.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x,y,28,28);
        this.setVisible(true);
    }
//    public void choosePlace();
}
