import javax.swing.*;

public class Paint
{
    public static void main( String args[] )
    {
        JFrame app = new MainWindow();
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        app.setVisible( true );
    }
}
