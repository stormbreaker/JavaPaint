import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.LinkedList;

public class CreateMenus
{
    String[] menuNames = {"File", "Shape", "Foreground Color", "Background Color", "Help"};

    public CreateMenus()
    {

    }

    public JMenuBar GetMenuBar()
    {
        return CreateMenuBar();
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
        AddColorMenuItems(menus.get(2));
        AddColorMenuItems(menus.get(3));
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

        menuItem.addActionListener(new ButtonActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Rectangle");

        menuItem.addActionListener(new ButtonActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Ellipse");

        menuItem.addActionListener(new ButtonActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Filled Rectangle");

        menuItem.addActionListener(new ButtonActionListener());

        shapeMenu.add(menuItem);

        menuItem = new JMenuItem("Filled Ellipse");

        menuItem.addActionListener(new ButtonActionListener());

        shapeMenu.add(menuItem);
    }

    private void AddColorMenuItems(JMenu foregroudColorMenu)
    {
        JMenuItem menuItem = new JMenuItem("Red");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Blue");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Green");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Yellow");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Orange");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Purple");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Pink");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);

        menuItem = new JMenuItem("Black");

        menuItem.addActionListener(new ButtonActionListener());

        foregroudColorMenu.add(menuItem);
    }

    private void AddHelpMenuItems(JMenu helpMenu)
    {
        JMenuItem menuItem = new JMenuItem("Help");

        menuItem.addActionListener(new ButtonActionListener());

        helpMenu.add(menuItem);
    }
}

class ButtonActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        JMenuItem menuItem = (JMenuItem)e.getSource();

        JOptionPane.showMessageDialog(new JFrame(), "You clicked the " + menuItem.getText());
    }
}
