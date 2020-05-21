import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LostText extends JPanel {
    private int score = 0;
    private String scoreForDisplay;
    BufferedImage SnakeIcon;
    public LostText(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\SnakeBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(85,10,130,60);
        scoreForDisplay = "You Lost";
        this.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
        g.setFont(new Font("Holstein", Font.BOLD, 20));
        g.drawString(scoreForDisplay, 20,50);
    }
}