import javax.swing.*;



import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<StarFlyweight> stars = new ArrayList<>();

    public void placeStar(StarFlyweight star) {
        stars.add(star);
    }

    @Override
    public void paint(Graphics graphics) {
        for (StarFlyweight star : stars) {
            star.draw(graphics);
        }
    }
}