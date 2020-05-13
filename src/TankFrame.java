import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame  extends Frame {

    Tank myTank = new Tank(100, 100, Dir.STOP);

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

        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    private class MyKeyListener extends KeyAdapter {
        boolean L = false;
        boolean R = false;
        boolean U = false;
        boolean D = false;
        boolean STOP = true;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    L = true;
                    STOP = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    R = true;
                    STOP = false;
                    break;
                case KeyEvent.VK_UP:
                    U = true;
                    STOP = false;
                    break;
                case KeyEvent.VK_DOWN:
                    D = true;
                    STOP = false;
                    break;
            }
            setTankDir();
        }

        private void setTankDir() {

            if (L) myTank.setDir(Dir.LEFT);
            if (U) myTank.setDir(Dir.UP);
            if (R) myTank.setDir(Dir.RIGHT);
            if (D) myTank.setDir(Dir.DOWN);
            if (STOP) myTank.setDir(Dir.STOP);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    L = false;
                    STOP = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    R = false;
                    STOP = true;
                    break;
                case KeyEvent.VK_UP:
                    U = false;
                    STOP = true;
                    break;
                case KeyEvent.VK_DOWN:
                    D = false;
                    STOP = true;
                    break;
            }
            setTankDir();
        }
    }
}
