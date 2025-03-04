import java.util.Random;
import java.util.Scanner;


public class GokuVsVegeta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int vidaGoku = 100;
        int vidaVegeta = 100;
        
        System.out.println("¡Comienza la batalla entre Goku y Vegeta!");
        
        while (vidaGoku > 0 && vidaVegeta > 0) {
            System.out.println("\nTurno de Goku");
            System.out.println("1. Atacar\n2. Defender");
            int opcionGoku = scanner.nextInt();
            
            if (opcionGoku == 1) {
                int ataque = random.nextInt(20) + 10;
                vidaVegeta -= ataque;
                System.out.println("Goku ataca y causa " + ataque + " de daño a Vegeta.");
            } else {
                System.out.println("Goku se defiende y reduce el daño del siguiente ataque.");
            }
            
            if (vidaVegeta <= 0) break;
            
            System.out.println("\nTurno de Vegeta");
            int opcionVegeta = random.nextInt(2) + 1;
            
            if (opcionVegeta == 1) {
                int ataque = random.nextInt(20) + 10;
                if (opcionGoku == 2) {
                    ataque /= 2;
                }
                vidaGoku -= ataque;
                System.out.println("Vegeta ataca y causa " + ataque + " de daño a Goku.");
            } else {
                System.out.println("Vegeta se defiende y reduce el daño del siguiente ataque.");
            }
            
            System.out.println("\nVida de Goku: " + vidaGoku);
            System.out.println("Vida de Vegeta: " + vidaVegeta);
        }
        
        if (vidaGoku > 0) {
            System.out.println("\n¡Goku gana la batalla!");
        } else {
            System.out.println("\n¡Vegeta gana la batalla!");
        }
        
        scanner.close();
    }
}
