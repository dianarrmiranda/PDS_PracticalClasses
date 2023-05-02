import startypes.*;
import java.awt.Graphics;


public class StarFlyweight {

    private StarType starType;
    private int x;
    private int y;

    public StarFlyweight(StarType starType, int x, int y) {
        this.starType = starType;
        this.x = x;
        this.y = y;
    }

    
    public void draw(Graphics g) {
        g.setColor(this.starType.getColor());
        g.fillOval(this.x, this.y , this.starType.getSize(), this.starType.getSize());
    }

    

    
}
