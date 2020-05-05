import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {
    BufferedImage background;

    public Board(){
        setLayout(null);
        try {
            background = ImageIO.read(new File("D:\\Projekty\\Snake-Java\\SnakeJava\\src\\Pics\\SnakeBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0,0, null);
    }
}
