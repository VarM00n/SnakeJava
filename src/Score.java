import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Score extends JPanel {
private int score = 0;
private String scoreForDisplay;
BufferedImage SnakeIcon;
    public Score(){
        try {
            SnakeIcon = ImageIO.read(new File("res\\Pics\\SnakeBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(10,445,136,77);
        scoreForDisplay = "Score: " + Integer.toString(score);
        this.setVisible(true);
    }
    void changeScore(int scor){
        scoreForDisplay = "Score: " + Integer.toString(scor);
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