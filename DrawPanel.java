import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.LinkedList;
import java.lang.Math;

// ButtonPanel changes color in response to button presses
public class DrawPanel extends JPanel implements MouseListener
{
    private List<Shape> shapeList = new LinkedList<Shape>();
    private Coordinate firstCoord;
    private Coordinate secondCoord;

    public Shape currentShape;
    public Color foregroundColor;
    public Color backgroundColor;
    public Shape mobileShape;
    public boolean moving = false;

    public DrawPanel()
    {
        addMouseListener(this);

        currentShape = new Line();
        foregroundColor = Color.black;
        backgroundColor = Color.black;
    }

     public void mouseClicked(MouseEvent e) {}
    // {
    //     if (SwingUtilities.isRightMouseButton(e) == true && moving == false)
    //     {
    //         if (shapeList.size() > 0)
    //         {
    //             //find closest shape in the list
    //             firstCoord.XCoord = e.getX();
    //             firstCoord.YCoord = e.getY();
    //             mobileShape = getClosest(firstCoord.XCoord, firstCoord.YCoord); //fine?
    //             moving = true;
    //         }
    //     }
    //     //this executes immediately.... which is 'tarded but it is because moving
    //     //is set to true right away
    //     if (SwingUtilities.isRightMouseButton(e) && moving == true)
    //     {
    //         secondCoord.XCoord = e.getX();
    //         secondCoord.YCoord = e.getY(); //new center
    //
    //         //compute new first/sec Coords
    //
    //
    //         mobileShape.SetProperties(firstCoord, secondCoord, mobileShape.bgShColor, mobileShape.fgShColor);
    //         moving = false;
    //     }
    // }
    public void mouseEntered(MouseEvent e){ }
    public void mouseExited(MouseEvent e){ }

    public void mousePressed(MouseEvent e)
    {
        //I believe I need to if these so if button1, then paint new
        //if button3, then call a distance and move
        if (SwingUtilities.isLeftMouseButton(e) == true)
        {
            firstCoord = new Coordinate();
            firstCoord.XCoord = e.getX();
            firstCoord.YCoord = e.getY();
        }
         else if (SwingUtilities.isRightMouseButton(e) == true)
         {
             if (shapeList.size() > 0)
             {
                 //find closest shape in the list
                 firstCoord = new Coordinate();
                 firstCoord.XCoord = e.getX();
                 firstCoord.YCoord = e.getY();
                 mobileShape = getClosest(firstCoord.XCoord, firstCoord.YCoord);
             }
         }
    }

    public void mouseReleased(MouseEvent e)
    {
        //same as in mousePressed
        //if button1, then paint new
        //if button3, then move
        if (SwingUtilities.isLeftMouseButton(e) == true)
        {
            secondCoord = new Coordinate();
            secondCoord.XCoord = e.getX();
            secondCoord.YCoord = e.getY();
            SetCurrentShape();

            currentShape.SetProperties(firstCoord, secondCoord, backgroundColor, foregroundColor);

            shapeList.add(currentShape);
        }
         else if (SwingUtilities.isRightMouseButton(e) == true)
         {
             //move the shape
             secondCoord = new Coordinate();
             secondCoord.XCoord = e.getX();
             secondCoord.YCoord = e.getY();
             firstCoord.XCoord = secondCoord.XCoord + mobileShape.vecto1.XCoord;
                firstCoord.YCoord = secondCoord.YCoord + mobileShape.vecto1.YCoord;

                secondCoord.XCoord = secondCoord.XCoord + mobileShape.vecto2.XCoord;
                secondCoord.YCoord = secondCoord.YCoord + mobileShape.vecto2.YCoord;
                mobileShape.SetProperties(firstCoord, secondCoord, mobileShape.bgShColor, mobileShape.fgShColor);
                mobileShape = null;

        }

        repaint();
    }

    public void paintComponent(Graphics g)
    {
        for (Shape shape : shapeList)
        {
            System.out.println(shapeList.size());
            shape.paintComponent(g);
            //repaint();
        }
    }

    public void RemoveLastObject()
    {
        shapeList.remove(shapeList.size() - 1);

        repaint();
    }

    public void ClearScreen()
    {
        shapeList.clear();

        repaint();
    }

    private void SetCurrentShape()
    {
        if (currentShape instanceof Line)
        {
            currentShape = new Line();
        }
        else if (currentShape instanceof FilledRectangle)
        {
            currentShape = new FilledRectangle();
        }
        else if (currentShape instanceof FilledEllipse)
        {
            currentShape = new FilledEllipse();
        }
        else if (currentShape instanceof Rectangle)
        {
            currentShape = new Rectangle();
        }
        else
        {
            currentShape = new Ellipse();
        }
    }
    private Shape getClosest(int x, int y)
    {
        int min = 999999;
        Shape minShape = null;
        int tempMin;
        for (Shape shape : shapeList)
        {
            tempMin = (int)Math.sqrt(Math.pow(shape.center.XCoord - x, 2.0) + Math.pow(shape.center.YCoord - y, 2.0));
            //square root of ((x2-x1)^2 + (y2-y1)^2
            if (tempMin < min && tempMin <= 10)
            {
                min = tempMin;
                minShape = shape;
            }
        }

        return minShape;
    }
}
