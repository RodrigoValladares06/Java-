public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GokuVsVegeta juego = new GokuVsVegeta();
            juego.setVisible(true);
        });
    }
}
