import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class Snake extends JFrame implements ActionListener{

int x = 0, xVel = 28;
int y = 172, yVel = 28;
BufferedImage background;
SnakeBox [] snakeBox = new SnakeBox[3];

    public Snake(){
        super("Snake");
        setSize(560, 420);
        setLayout(null);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\Projekty\\Snake-Java\\SnakeJava\\src\\Pics\\SnakeBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
        initializeSnake();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveSnake();
            }
        }, 500, 500);
    }
    public void repaint(){

    }

    public void initializeSnake(){
        x = 252;
        y = 280;
        for(int i = 0; i < snakeBox.length; i++){
            snakeBox[i] = new SnakeBox(252, 280 + i*28);
            add(snakeBox[i]);
        }
    }
    public void moveSnake(){
        for(int i = 0; i < snakeBox.length; i++){
            snakeBox[i].setX(snakeBox[i].getX());
            snakeBox[i].setY(snakeBox[i].getY() - 28);
            snakeBox[i].changePlace(snakeBox[i].getX(), snakeBox[i].getY());
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawImage(background, 0,0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
