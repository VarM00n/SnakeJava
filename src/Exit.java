import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Exit extends JPanel {
    BufferedImage SnakeIcon;

    public Exit(){
        try {
            SnakeIcon = ImageIO.read(new File("src\\Pics\\Exit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(24*28,16*28 + 3,51,51);
        this.setVisible(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
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
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(SnakeIcon, 0,0, null);
    }
}