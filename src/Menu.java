import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener {

int SizeX = 26, SizeY = 21;
Brick [] bricks = new Brick[26];
    public Menu(){
        super("Snake");
        setSize(28 * SizeX - 12, 28 * SizeY - 17);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SnakeBox snakeBox = new SnakeBox(0,0);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\Pics\\SnakeBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addBricks();
//        add(snakeBox);
        setVisible(true);

    }
    public void addBricks(){
        for(int i = 0; i < SizeX-1; i++){
            bricks[i] = new Brick(i*28, 0);
            add(bricks[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

