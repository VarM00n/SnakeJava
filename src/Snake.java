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
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Snake extends JFrame implements ActionListener{

int x = 0, xVel = 28;
int y = 172, yVel = 28;
BufferedImage background;
ArrayList<SnakeBox> snakeBox = new ArrayList<SnakeBox>();

    /**
     * Where to go 0 - top, 1 - right, 2 - bot, 3 - left
     */
int direction = 0;
boolean chosenDirection = false;
    public Snake(){
        super("Snake");
        setSize(560, 420);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                        if(direction != 2) {
                            if (!chosenDirection) {
                                direction = 0;
                                chosenDirection = true;
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT :
                        if(direction != 3) {
                            if (!chosenDirection) {
                                direction = 1;
                                chosenDirection = true;
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if(direction != 1) {
                            if (!chosenDirection) {
                                direction = 3;
                                chosenDirection = true;
                            }
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(direction != 0) {
                            if (!chosenDirection) {
                                direction = 2;
                                chosenDirection = true;
                            }
                        }
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
                chosenDirection = false;
                System.out.println(direction);
            }
        }, 250, 250);
    }

    public void initializeSnake(){
        x = 252;
        y = 280;
        for(int i = 0; i < 3; i++){
            snakeBox.add(i, new SnakeBox(252, 280 + i*28));
            add(snakeBox.get(i));
        }
    }
    public void moveSnake(){
        Position tempPos = new Position();
        if(checkIfNextEmpty(snakeBox.get(0))) {
            dispose();
        }
        if(direction == 0)
            tempPos = goUp(snakeBox.get(0));
        if(direction == 1)
            tempPos = goRight(snakeBox.get(0));
        if(direction == 2)
            tempPos = goDown(snakeBox.get(0));
        if(direction == 3)
            tempPos = goLeft(snakeBox.get(0));
        for(int i = 1; i < snakeBox.size(); i++){
            tempPos = moveOneBlockOfSnake(snakeBox.get(i), tempPos);
        }
    }
    
    public boolean checkIfNextEmpty (SnakeBox snake){
        Position position = new Position();
        if(direction == 0) {
            position.setPosition(snake.getX(), snake.getY() - 28);
            for (SnakeBox box : snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
        }
        if(direction == 1) {
            position.setPosition(snake.getX() + 28, snake.getY());
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
        }
        if(direction == 2){
            position.setPosition(snake.getX(), snake.getY() + 28);
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
        }
        if(direction == 3){
            position.setPosition(snake.getX() - 28, snake.getY());
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
        }
        return false;
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
    public Position goRight(SnakeBox snakeBox){
        Position position = new Position();
        position.x = snakeBox.getX();
        position.y = snakeBox.getY();
        snakeBox.setX(position.x + 28);
        snakeBox.setY(position.y);
        snakeBox.changePlace(snakeBox.getX(), snakeBox.getY());
        return position;
    }
    public Position goLeft(SnakeBox snakeBox){
        Position position = new Position();
        position.x = snakeBox.getX();
        position.y = snakeBox.getY();
        snakeBox.setX(position.x - 28);
        snakeBox.setY(position.y);
        snakeBox.changePlace(snakeBox.getX(), snakeBox.getY());
        return position;
    }
    public Position goDown(SnakeBox snakeBox){
        Position position = new Position();
        position.x = snakeBox.getX();
        position.y = snakeBox.getY();
        snakeBox.setX(position.x);
        snakeBox.setY(position.y + 28);
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
