import javax.swing.*;
import java.awt.*;

public class SnakeBox extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2g = (Graphics2D) g.create();
        g.setColor(Color.GRAY);
        g.fillRoundRect(250, 250, 28, 28, 10, 10);
    }
}
