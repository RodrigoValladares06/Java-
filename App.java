import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Goku: Esquiva los enemigos");
            GokuGame game = new GokuGame();
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
