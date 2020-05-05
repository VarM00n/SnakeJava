import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    /**
     * Where to go 0 - top, 1 - right, 2 - bot, 3 - left
     */
int direction;
    public Snake(){
        super("Snake");
        setSize(560, 420);
        setLayout(null);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\Projekty\\Snake-Java\\SnakeJava\\src\\Pics\\SnakeBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_UP:
                        direction = 0;
                        break;
                    case KeyEvent.VK_DOWN:
                        direction  = 2;
                        break;
                    case KeyEvent.VK_LEFT:
                        direction = 3;
                        break;
                    case KeyEvent.VK_RIGHT :
                        direction = 1;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        this.addKeyListener(listener);
        setVisible(true);
        initializeSnake();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveSnake();
                System.out.println(direction);
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
        Position tempPos = goUp(snakeBox[0]);
        for(int i = 1; i < snakeBox.length; i++){
            tempPos = moveOneBlockOfSnake(snakeBox[i], tempPos);
        }
    }
    public Position moveOneBlockOfSnake(SnakeBox snakeBox, Position position){
        Position positionToSend = new Position(snakeBox.getX(), snakeBox.getY());
        snakeBox.changePlace(position.x, position.y);
        return positionToSend;
    }


    public Position goUp(SnakeBox snakeBox){
        Position position = new Position();
        position.x = snakeBox.getX();
        position.y = snakeBox.getY();
        snakeBox.setX(position.x);
        snakeBox.setY(position.y - 28);
        snakeBox.changePlace(snakeBox.getX(), snakeBox.getY());
        return position;
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
