import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera implements Juego {

	public void jugar() {
		System.out.println("Bienvenidos a Piedra, Papel, Tijera!");

		Random random = new Random();

		int contadorUsuario = 0;
		int contadorMaquina = 0;

		while (contadorMaquina < 3 && contadorUsuario < 3) {

			int jugadaComp = random.nextInt(3);
			int jugadaUsuario = recogeJugadaUsuario();

			imprimirVs(jugadaComp, jugadaUsuario);

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

		System.out.println("Fin!");
	}

	private void imprimirVs(int jugadaOrdenador, int jugadaUsaurio) {
		System.out.printf("%s vs. %s\n", jugadaALiteral(jugadaUsaurio), jugadaALiteral(jugadaOrdenador));
	}

	private String jugadaALiteral(int jugada) {
		switch (jugada) {
		case 0:
			return "Piedra";
		case 1:
			return "Papel";
		case 2:
			return "Tijera";
		default:
			return null;
		}
	}

	private int recogeJugadaUsuario() {
		
		Scanner scanner = new Scanner(System.in);
		int jugadaUsuario;

		do {
			System.out.println("Juegue: ");
			String jugada = scanner.nextLine().toLowerCase();
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
		} while (jugadaUsuario == -1);
		
		scanner.close();
		
		return jugadaUsuario;
	}

}
