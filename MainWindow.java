import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class MainWindow extends JFrame implements KeyListener
{
    String[] menuNames = {"File", "Shape", "Foreground Color", "Background Color", "Help"};

    JMenuBar menubar;
    DrawPanel drawPanel;

    public MainWindow()
    {
        setTitle("Paint");

        drawPanel = new DrawPanel();

        SetupMenuBar();

        setJMenuBar(menubar);
        getContentPane().add(drawPanel);
        addKeyListener(this);
    }

    public void keyTyped(KeyEvent e){ }
    public void keyReleased(KeyEvent e){ }

    public void keyPressed(KeyEvent e)
    {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
        else if (keycode == KeyEvent.VK_D)
        {
            drawPanel.RemoveLastObject();
        }
        else if (keycode == KeyEvent.VK_C)
        {
            drawPanel.ClearScreen();
        }
    }

    private void SetupMenuBar()
    {
        menubar = CreateMenuBar();
    }

    private JMenuBar CreateMenuBar()
    {
        JMenuBar menubar = new JMenuBar();

        List<JMenu> menus = GetMenus();

        for (JMenu menu : menus)
        {
            menubar.add(menu);
        }

        return menubar;
    }

    private List<JMenu> GetMenus()
    {
        List<JMenu> menus = new LinkedList<JMenu>();

        for (String menuName : menuNames)
        {
            menus.add(new JMenu(menuName));
        }

        AddFileMenuItems(menus.get(0));
        AddShapeMenuItems(menus.get(1));
        AddForegroundColorMenuItems(menus.get(2));
        AddBackgroundMenuItems(menus.get(3));
        AddHelpMenuItems(menus.get(4));

        return menus;
    }

    private void AddFileMenuItems(JMenu fileMenu)
    {
        JMenuItem menuItem = new JMenuItem("Exit");

        menuItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae )
            {
                System.exit( 0 );
            }
        });

        fileMenu.add(menuItem);
    }

    private void AddShapeMenuItems(JMenu shapeMenu)
    {
        JMenuItem menuItem = new JMenuItem("Line");

        menuItem.addActionListener(new ShapeActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Rectangle");

        menuItem.addActionListener(new ShapeActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Ellipse");

        menuItem.addActionListener(new ShapeActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Filled Rectangle");

        menuItem.addActionListener(new ShapeActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Filled Ellipse");

        menuItem.addActionListener(new ShapeActionListener());

        shapeMenu.add(menuItem);
    }

    private void AddForegroundColorMenuItems(JMenu foregroudColorMenu)
    {
        JMenuItem menuItem = new JMenuItem("Red");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Blue");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Green");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Yellow");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Orange");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Magenta");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Pink");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Black");

        menuItem.addActionListener(new ForegroundColorActionListener());

        foregroudColorMenu.add(menuItem);
    }

    private void AddBackgroundMenuItems(JMenu backgroundColorMenu)
    {
        JMenuItem menuItem = new JMenuItem("Red");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Blue");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Green");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Yellow");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Orange");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Magenta");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Pink");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);

        menuItem = new JMenuItem("Black");

        menuItem.addActionListener(new BackgroundColorActionListener());

        backgroundColorMenu.add(menuItem);
    }

    private void AddHelpMenuItems(JMenu helpMenu)
    {
        JMenuItem menuItem = new JMenuItem("Help");

        //menuItem.addActionListener(this);

        helpMenu.add(menuItem);
    }

    class ShapeActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JMenuItem menuItem = (JMenuItem)e.getSource();
            String menuText = menuItem.getText();

            if (menuText == "Line")
            {
                drawPanel.currentShape = new Line();
            }
            else if (menuText == "Rectangle")
            {
                drawPanel.currentShape = new Rectangle();
            }
            else if (menuText == "Ellipse")
            {
                drawPanel.currentShape = new Ellipse();
            }
            else if (menuText == "Filled Rectangle")
            {
                drawPanel.currentShape = new FilledRectangle();
            }
            if (menuText == "Filled Ellipse")
            {
                drawPanel.currentShape = new FilledEllipse();
            }
        }
    }

    class ForegroundColorActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JMenuItem menuItem = (JMenuItem)e.getSource();
            String menuText = menuItem.getText();

            if (menuText == "Red")
            {
                drawPanel.foregroundColor = Color.red;
            }
            if (menuText == "Blue")
            {
                drawPanel.foregroundColor = Color.blue;
            }
            if (menuText == "Green")
            {
                drawPanel.foregroundColor = Color.green;
            }
            if (menuText == "Yellow")
            {
                drawPanel.foregroundColor = Color.yellow;
            }
            if (menuText == "Orange")
            {
                drawPanel.foregroundColor = Color.orange;
            }
            if (menuText == "Magenta")
            {
                drawPanel.foregroundColor = Color.magenta;
            }
            if (menuText == "Pink")
            {
                drawPanel.foregroundColor = Color.pink;
            }
            if (menuText == "Black")
            {
                drawPanel.foregroundColor = Color.black;
            }
        }
    }

    class BackgroundColorActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JMenuItem menuItem = (JMenuItem)e.getSource();
            String menuText = menuItem.getText();

            if (menuText == "Red")
            {
                drawPanel.backgroundColor = Color.red;
            }
            if (menuText == "Blue")
            {
                drawPanel.backgroundColor = Color.blue;
            }
            if (menuText == "Green")
            {
                drawPanel.backgroundColor = Color.green;
            }
            if (menuText == "Yellow")
            {
                drawPanel.backgroundColor = Color.yellow;
            }
            if (menuText == "Orange")
            {
                drawPanel.backgroundColor = Color.orange;
            }
            if (menuText == "Magenta")
            {
                drawPanel.backgroundColor = Color.magenta;
            }
            if (menuText == "Pink")
            {
                drawPanel.backgroundColor = Color.pink;
            }
            if (menuText == "Black")
            {
                drawPanel.backgroundColor = Color.black;
            }
        }
    }
}
