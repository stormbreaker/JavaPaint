import java.awt.*;

public class Line extends Shape
{
    public Coordinate endcoord;

    public void SetProperties(Coordinate first, Coordinate second,
    Color bgColor, Color fgColor)
    {
        firstCoord = first;
        secondCoord = second;
        fgShColor = fgColor;
        center.XCoord = (first.XCoord + second.XCoord)/2;
        center.YCoord = (first.YCoord + second.YCoord)/2;
        
        vecto1.XCoord = first.XCoord - center.XCoord;
        vecto1.YCoord = first.YCoord - center.YCoord;
        vecto2.XCoord = second.XCoord - center.XCoord;
        vecto2.YCoord = second.YCoord - center.YCoord;

    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(fgShColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(firstCoord.XCoord, firstCoord.YCoord, secondCoord.XCoord, secondCoord.YCoord);
    }
}
