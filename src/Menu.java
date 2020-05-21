import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class Menu extends JFrame{

int SizeX = 27, SizeY = 21;
Brick [][] bricks = new Brick[26][21];
Name logo = new Name();
int direction = 0;
boolean [][] tableOfBricks = new boolean[26][21];
ArrayList<SnakeBox> snakeBox = new ArrayList<SnakeBox>();
Easy Easy = new Easy();
Medium Medium = new Medium();
Hard Hard = new Hard();
int lvl;
Exit exit = new Exit();
EasyEnchanced easyEnchanced = new EasyEnchanced();
MediumEnchanced mediumEnchanced = new MediumEnchanced();
HardEnchanced hardEnchanced = new HardEnchanced();

    public Menu(){
        super("Snake");
        setSize(28 * SizeX - 12, 28 * SizeY - 17);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\Pics\\SnakeBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 21; j++){
                tableOfBricks[i][j] = false;
            }
        }
        add(easyEnchanced);
        add(mediumEnchanced);
        add(hardEnchanced);
        add(Easy);
        add(Medium);
        add(Hard);
        addBricks();
        add(logo);
        add(exit);

        Easy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new EasySnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                easyEnchanced.setVisible(true);
                logo.setVisible(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyEnchanced.setVisible(false);
                logo.setVisible(true);
            }
        });
        Medium.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new MediumSnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mediumEnchanced.setVisible(true);
                logo.setVisible(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mediumEnchanced.setVisible(false);
                logo.setVisible(true);
            }
        });
        Hard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new HardSnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hardEnchanced.setVisible(true);
                logo.setVisible(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardEnchanced.setVisible(false);
                logo.setVisible(true);
            }
        });
        setVisible(true);
        initializeSnake();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setDirection();
                moveSnake();
            }
        }, 150, 300);
    }

    public void addBricks(){
        for(int i = 0; i < SizeX - 1; i++){
            for(int j = 0; j < SizeY - 1; j++) {
                if((i == 0 || j == 0 || i == 25 || j == 15) && j != 17 && j != 18 && j != 16) {
                    bricks[i][j] = new Brick(i * 28, j * 28);
                    tableOfBricks[i][j] = true;
                    add(bricks[i][j]);
                }
            }
        }
        tableOfBricks[6][4] = true;
        tableOfBricks[7][4] = true;
        tableOfBricks[8][4] = true;
        tableOfBricks[9][4] = true;
        tableOfBricks[10][4] = true;
        tableOfBricks[11][4] = true;
        tableOfBricks[12][4] = true;
        tableOfBricks[13][4] = true;
        tableOfBricks[14][4] = true;
        tableOfBricks[15][4] = true;
        tableOfBricks[16][4] = true;
        tableOfBricks[17][4] = true;
        tableOfBricks[18][4] = true;
        tableOfBricks[19][4] = true;

        tableOfBricks[6][9] = true;
        tableOfBricks[7][9] = true;
        tableOfBricks[8][9] = true;
        tableOfBricks[9][9] = true;
        tableOfBricks[10][9] = true;
        tableOfBricks[11][9] = true;
        tableOfBricks[12][9] = true;
        tableOfBricks[13][9] = true;
        tableOfBricks[14][9] = true;
        tableOfBricks[15][9] = true;
        tableOfBricks[16][9] = true;
        tableOfBricks[17][9] = true;
        tableOfBricks[18][9] = true;
        tableOfBricks[19][9] = true;

        tableOfBricks[6][5] = true;
        tableOfBricks[6][6] = true;
        tableOfBricks[6][7] = true;
        tableOfBricks[6][8] = true;

        tableOfBricks[19][5] = true;
        tableOfBricks[19][6] = true;
        tableOfBricks[19][7] = true;
        tableOfBricks[19][8] = true;
    }

    public void initializeSnake(){
        for(int i = 0; i < 5; i++){
            snakeBox.add(i, new SnakeBox(12*28, 280 + i*28 + 28));
            add(snakeBox.get(i));
        }
    }

    private static int getRandomNumberInRange(int max) {

        if (1 >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt(max);
    }

    public void setDirection(){
        if(direction == 0){
            direction = getRandomNumberInRange(4);
            while(direction == 2){
                direction = getRandomNumberInRange(4);
            }
        }
        else if(direction == 1){
            direction = getRandomNumberInRange(4);
            while(direction == 3){
                direction = getRandomNumberInRange(4);
            }
        }
        else if(direction == 2){
            direction = getRandomNumberInRange(4);
            while(direction == 0){
                direction = getRandomNumberInRange(4);
            }
        }
        else if(direction == 3){
            direction = getRandomNumberInRange(4);
            while(direction == 1){
                direction = getRandomNumberInRange(4);
            }
        }
    }

    public void moveSnake(){
        Position tempPos = new Position();
        while(checkIfNextEmpty(snakeBox.get(0)) || checkIfNextEmpty1(snakeBox.get(0))) {
            setDirection();
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

    public Position moveOneBlockOfSnake(SnakeBox snakeBox, Position position){
        Position positionToSend = new Position(snakeBox.getX(), snakeBox.getY());
        snakeBox.changePlace(position.x, position.y);
        return positionToSend;
    }

    public boolean checkIfNextEmpty (SnakeBox snake){
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

    public boolean checkIfNextEmpty1 (SnakeBox snake){
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


}

