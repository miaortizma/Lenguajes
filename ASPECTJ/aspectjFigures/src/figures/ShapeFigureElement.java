package figures;

import java.awt.*;
import java.awt.geom.*;

public abstract class ShapeFigureElement implements FigureElement {
    @Override
    public abstract void move(int dx, int dy);

    public abstract Shape getShape();

    @Override
    public Rectangle getBounds() {
        return getShape().getBounds();
    }

    @Override
    public boolean contains(Point2D p) {
        return getShape().contains(p);
    }

    public Color getLineColor() {
        return Color.black;
    }

    public Color getFillColor() {
        return Color.red;
    }

    @Override
    public final void paint(Graphics2D g2) {
        Shape shape = getShape();
        g2.setPaint(getFillColor());
        g2.fill(shape);
        g2.setPaint(getLineColor());
        g2.draw(shape);
    }
}