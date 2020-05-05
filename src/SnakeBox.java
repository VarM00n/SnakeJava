import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SnakeBox extends JPanel {
   BufferedImage SnakeIcon;
   int x, y;
   boolean initiated = false;

    public SnakeBox(int x, int y){
        this.x = x;
        this.y = y;
        try {
            SnakeIcon = ImageIO.read(new File("D:\\Projekty\\Snake-Java\\SnakeJava\\src\\Pics\\Snake.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x,y,28,28);
        this.setVisible(true);
    }

    public void changePlace(int x, int y){
        this.x = x;
        this.y = y;
        this.setBounds(this.x, this.y, 28, 28);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);


    }
}
