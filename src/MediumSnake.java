import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

public class MediumSnake extends JFrame implements ActionListener{

    int x = 0, xVel = 28;
    int y = 172, yVel = 28;
    int SizeX = 27, SizeY = 21;
    BufferedImage background;
    ArrayList<SnakeBox> snakeBox = new ArrayList<SnakeBox>();
    SnakeBox fruit = new SnakeBox(0,0);
    Name name = new Name();
    Brick [][] bricks = new Brick[26][21];
    boolean [][] tableOfBricks = new boolean[26][21];
    /**
     * Where to go 0 - top, 1 - right, 2 - bot, 3 - left
     */
    int direction = 0;
    boolean chosenDirection = false;
    boolean eaten = false;
    public MediumSnake(){
        super("Snake");
        setSize(28 * SizeX - 12, 28 * SizeY - 17);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\Pics\\SnakeBackground.png")))));
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
        addBricks();
        setVisible(true);
        initializeSnake();
        add(fruit);
        setPlaceForFruit();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveSnake();
                chosenDirection = false;
            }
        }, 150, 150);
    }

    public void addBricks(){
        for(int i = 0; i < SizeX - 1; i++){
            for(int j = 0; j < SizeY - 1; j++) {
                if((i == 0 || j == 0 || i == 25 || j == 15) && j != 17 && j != 18 && j != 16) {
                    bricks[i][j] = new Brick(i * 28, j * 28);
                    tableOfBricks[i][j] = true;
                    add(bricks[i][j]);
                }
                if(i == 5 && (j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10)){
                    bricks[i][j] = new Brick(i * 28, j * 28);
                    tableOfBricks[i][j] = true;
                    add(bricks[i][j]);
                }
                if(i == 20 && (j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10)){
                    bricks[i][j] = new Brick(i * 28, j * 28);
                    tableOfBricks[i][j] = true;
                    add(bricks[i][j]);
                }
            }
        }

    }

    private static int getRandomNumberInRange(int max) {
        int random = (int)(max * Math.random() + 1);
        return random;
    }

    public void setPlaceForFruit(){
        Position positionOfFruit = new Position();
        boolean check = true;
        while(check){
            int check1 = 0;
            positionOfFruit.x = getRandomNumberInRange(23);
            positionOfFruit.y = getRandomNumberInRange(14);
            for (SnakeBox box : snakeBox) {
                if (box.getX() == positionOfFruit.x * 28 && box.getY() == positionOfFruit.y * 28) {
                    check1 = 1;
                    break;
                }
            }
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 21; j++){
                    if(tableOfBricks[i][j]){
                        if(positionOfFruit.x == i && positionOfFruit.y == j){
                            check1 = 1;
                            break;
                        }
                    }
                }
            }
            if(check1 == 0){
                fruit.changePlace(positionOfFruit.x * 28, positionOfFruit.y * 28);
                check = false;
            }
        }
    }

    public void initializeSnake(){
        for(int i = 0; i < 3; i++){
            snakeBox.add(i, new SnakeBox(252, 280 + i*28));
            add(snakeBox.get(i));
        }
    }

    public void moveSnake(){
        Position tempPos = new Position();
        if(checkIfNextEmpty(snakeBox.get(0)) || checkIfNextEmpty1(snakeBox.get(0))) {
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
        if(eaten){
            snakeBox.add(snakeBox.size() - 1, new SnakeBox(snakeBox.get(snakeBox.size() - 1).getX(), snakeBox.get(snakeBox.size() - 1).getY()));
            add(snakeBox.get(snakeBox.size() - 2));
            setPlaceForFruit();
            eaten = false;
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
            if(fruit.getX() == position.x && fruit.getY() == position.y){
                eaten = true;
            }
        }
        if(direction == 1) {
            position.setPosition(snake.getX() + 28, snake.getY());
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
            if(fruit.getX() == position.x && fruit.getY() == position.y){
                eaten = true;
            }
        }
        if(direction == 2){
            position.setPosition(snake.getX(), snake.getY() + 28);
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
            if(fruit.getX() == position.x && fruit.getY() == position.y){
                eaten = true;
            }
        }
        if(direction == 3){
            position.setPosition(snake.getX() - 28, snake.getY());
            for (SnakeBox box : this.snakeBox) {
                if (box.getX() == position.x && box.getY() == position.y) {
                    return true;
                }
            }
            if(fruit.getX() == position.x && fruit.getY() == position.y){
                eaten = true;
            }
        }
        return false;
    }

    public boolean checkIfNextEmpty1 (SnakeBox snake){
        Position position = new Position();
        if(direction == 0) {
            position.setPosition(snake.getX(), snake.getY() - 28);
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 21; j++){
                    if(tableOfBricks[i][j] && position.x/28 == i && position.y/28 == j){
                        return true;
                    }
                }
            }
        }
        if(direction == 1) {
            position.setPosition(snake.getX() + 28, snake.getY());
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 21; j++){
                    if(tableOfBricks[i][j] && position.x/28 == i && position.y/28 == j){
                        return true;
                    }
                }
            }
        }
        if(direction == 2){
            position.setPosition(snake.getX(), snake.getY() + 28);
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 21; j++){
                    if(tableOfBricks[i][j] && position.x/28 == i && position.y/28 == j){
                        return true;
                    }
                }
            }
        }
        if(direction == 3){
            position.setPosition(snake.getX() - 28, snake.getY());
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 21; j++){
                    if(tableOfBricks[i][j] && position.x/28 == i && position.y/28 == j){
                        return true;
                    }
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
