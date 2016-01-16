import java.awt.*;
import java.lang.*;

public class Rectangle extends Shape
{
    public int width, height;

    public void SetProperties(Coordinate first, Coordinate second, Color bgColor, Color fgColor)
    {
        width = second.XCoord - first.XCoord;
        height = second.YCoord - first.YCoord;

        if (width > 0 && height > 0)
        {
            firstCoord = first;
        }
        else if (width < 0 && height < 0)
        {
            firstCoord = second;
        }
        else if (width < 0 && height > 0)
        {
            firstCoord.XCoord = second.XCoord;
            firstCoord.YCoord = first.YCoord;
        }
        else if (width > 0 && height < 0)
        {
            firstCoord.XCoord = first.XCoord;
            firstCoord.YCoord = second.YCoord;
        }

        center.XCoord = (first.XCoord + second.XCoord)/2;
        center.YCoord = (first.YCoord + second.YCoord)/2;
        vecto1.XCoord = first.XCoord - center.XCoord;
        vecto1.YCoord = first.YCoord - center.YCoord;
        vecto2.XCoord = second.XCoord - center.XCoord;
        vecto2.YCoord = second.YCoord - center.YCoord;

        fgShColor = fgColor;
        width = Math.abs(width);
        height = Math.abs(height);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(fgShColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(firstCoord.XCoord, firstCoord.YCoord, width, height);
    }
}
