import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class Snake extends JFrame{

JButton snake = new JButton();
Icon snakeB = new ImageIcon("src\\Pics\\Snake.png");
int x = 0, xVel = 28;


    public Snake(){
        super("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        enableInputMethods(true);
        Board board = new Board();
        add(board);
        this.setVisible(true);

//        paintBackground("src\\Pics\\SnakeBackground.png");
//        this.setResizable(false);
//
//        snake.setBounds(0, x, 28,28);
//        snake.setIcon(snakeB);
//        snake.setBorder(new EmptyBorder(0, 0, 0, 0));
//        snake.addActionListener(this);
//        add(snake);
//
////        SnakeBox snakeBox = new SnakeBox();
////        this.add(snakeBox);
//        this.setVisible(true);
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                x += xVel;
//                System.out.println(x);
//
//            }
//        }, 1000, 1000);

    }

//    public void repaintSnake(){
//        this.remove(snake);
//        x = 28;
//        add(snake);
//    }
//
//    public void paintBackground(String path){
//        try {
//            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path)))));
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        repaintSnake();
//    }
}
