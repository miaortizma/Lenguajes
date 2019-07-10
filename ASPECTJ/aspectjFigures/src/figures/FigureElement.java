package figures;

import java.awt.*;
import java.awt.geom.*;

public interface FigureElement {
    public static final Rectangle MAX_BOUNDS = new Rectangle(0, 0, 500, 500);

    public abstract void move(int dx, int dy);

    public abstract Rectangle getBounds();

    public abstract boolean contains(Point2D p);

    public abstract void paint(Graphics2D g2);
}