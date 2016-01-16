import java.awt.*;
import javax.swing.*;

public abstract class Shape extends JComponent
{
    public Color fgShColor;
    public Color bgShColor;
    public Coordinate firstCoord = new Coordinate();
    public Coordinate secondCoord = new Coordinate();
    public Coordinate center = new Coordinate();
    public Coordinate vecto1 = new Coordinate();
    public Coordinate vecto2 = new Coordinate();

    public abstract void SetProperties(Coordinate first, Coordinate second, Color bgColor, Color fgColor);
    public abstract void paintComponent(Graphics g);
}
