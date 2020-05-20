import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Brick extends JPanel {
    BufferedImage BrickImage;

    public Brick(int x, int y){
        try {
            BrickImage = ImageIO.read(new File("src\\Pics\\Brick.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x,y,28,28);
        this.setVisible(true);
    }
//    public void choosePlace();
}
