import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class Lost extends JFrame{
Home home = new Home(220,20);
int lvl;
LostText lostText = new LostText();
Replay replay = new Replay(10, 20, this.lvl);
    /**
     * 1 - easy, 2 - medium, 3 - hard
     */

    public Lost(int lv, EasySnake easySnake){
        super("Snake");
        setSize(300, 150);
        setLayout(null);
        this.lvl = lv;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res\\Pics\\LostBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(replay);
        add(home);
        add(lostText);
        setVisible(true);

        home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                    easySnake.dispose();
                dispose();
                new Menu();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        replay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                easySnake.dispose();
                dispose();
                new EasySnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public Lost(int lv, MediumSnake mediumSnake){
        super("Snake");
        setSize(300, 150);
        setLayout(null);
        this.lvl = lv;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res\\Pics\\LostBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(replay);
        add(home);
        add(lostText);
        setVisible(true);

        home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mediumSnake.dispose();
                dispose();
                new Menu();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        replay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mediumSnake.dispose();
                dispose();
                new MediumSnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public Lost(int lv, HardSnake hardSnake){
        super("Snake");
        setSize(300, 150);
        setLayout(null);
        this.lvl = lv;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res\\Pics\\LostBackground.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(replay);
        add(home);
        add(lostText);
        setVisible(true);

        home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                hardSnake.dispose();
                dispose();
                new Menu();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        replay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                hardSnake.dispose();
                dispose();
                new HardSnake();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    void setLvl(int lv){
        this.lvl = lv;
    }

}

