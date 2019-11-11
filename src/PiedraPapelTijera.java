import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

	public static void main(String[] args) {
		System.out.println("Bienvenidos a Piedra, Papel, Tijera!");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int contadorUsuario = 0;
		int contadorMaquina = 0;

		while (contadorMaquina < 3 && contadorUsuario < 3) {
			System.out.println("Juegue: ");
			int jugadaComp = random.nextInt(3);
			String jugada = scanner.nextLine().toLowerCase();
			int jugadaUsuario;

			switch (jugada) {
			case "piedra":
				jugadaUsuario = 0;
				break;
			case "papel":
				jugadaUsuario = 1;
				break;
			case "tijera":
				jugadaUsuario = 2;
				break;
			default:
				jugadaUsuario = -1;
				System.err.println("Jugada no soportada!! ");
				break;
			}

			if (jugadaUsuario == -1) {
				scanner.close();
				throw new RuntimeException("Jugada no soportada");
			}

			System.out.printf("%d vs. %d\n", jugadaUsuario, jugadaComp);

			if (jugadaComp == jugadaUsuario) {
				System.out.println("Empate!");
			} else if ((jugadaComp == 0 && jugadaUsuario == 2) || (jugadaComp == 1 && jugadaUsuario == 0)
					|| (jugadaComp == 2 && jugadaUsuario == 1)) {
				contadorMaquina++;
			} else {
				contadorUsuario++;
			}

			System.out.printf("Jugador: %d | Máquina: %d \n", contadorUsuario, contadorMaquina);
		}

		scanner.close();
		System.out.println("Fin!");
	}

}
