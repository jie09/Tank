import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame  extends Frame {

    int x = 200, y = 200;
    public TankFrame() throws HeadlessException {
        setVisible(true);
        setTitle("Tank WAR");
        setSize(800, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.drawRect(x, y,100,100);
        x += 5;
        y += 5;
    }
}
