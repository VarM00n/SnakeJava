import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Name extends JPanel {
    BufferedImage SnakeIcon;

    public Name(){
        try {
            SnakeIcon = ImageIO.read(new File("D:\\Projekty\\Snake-Java\\SnakeJava\\src\\Pics\\Name.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(200,250,150,75);
        this.setVisible(true);
    }
//    public void choosePlace();
}
