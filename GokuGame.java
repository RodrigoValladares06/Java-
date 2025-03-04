import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

class GokuGame extends JPanel implements ActionListener {
    private Timer timer;
    private int gokuX = 200;
    private int gokuY = 400;
    private int velocidad = 10;
    private ArrayList<Point> enemigos;
    private Random random;
    private boolean enJuego = true;

    public GokuGame() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moverGoku(e);
            }
        });
        enemigos = new ArrayList<>();
        random = new Random();
        timer = new Timer(50, this);
        timer.start();
    }

    private void moverGoku(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && gokuX > 0) {
            gokuX -= velocidad;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && gokuX < 450) {
            gokuX += velocidad;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && gokuY > 0) {
            gokuY -= velocidad;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && gokuY < 450) {
            gokuY += velocidad;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (random.nextInt(10) > 7) {
            enemigos.add(new Point(random.nextInt(500), 0));
        }
        
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).y += 5;
            if (enemigos.get(i).y > 500) {
                enemigos.remove(i);
            }
            
            if (new Rectangle(gokuX, gokuY, 50, 50).intersects(
                    new Rectangle(enemigos.get(i).x, enemigos.get(i).y, 40, 40))) {
                enJuego = false;
                timer.stop();
                JOptionPane.showMessageDialog(this, "¡Perdiste! Goku fue golpeado.");
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (enJuego) {
            g.setColor(Color.BLUE);
            g.fillRect(gokuX, gokuY, 50, 50);
            g.setColor(Color.RED);
            for (Point enemigo : enemigos) {
                g.fillRect(enemigo.x, enemigo.y, 40, 40);
            }
        }
    }
}
