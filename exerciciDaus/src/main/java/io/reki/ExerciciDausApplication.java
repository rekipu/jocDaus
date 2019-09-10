package io.reki;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciciDausApplication {
	public static void neteja() {
		for (int i = 0; i < 30; ++i) System.out.println();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExerciciDausApplication.class, args);

		Scanner lee = new Scanner(System.in);
		int select;
		int playerId = 0;
		
		
		TiradasService tiradasService = new TiradasService();

		do {
			System.out.println("Benvingut al dad'o'matic!");
			System.out.println("Per registrar un jugador nou, escriu 1");
			System.out.println("Per fer una tirada, escriu 2");
			System.out.println("Per consultar historial, escriu 3");
			System.out.println("Per sortir, escriu qualsevol altra cosa: ");
			select = lee.nextInt();
			switch (select) {
			case 1:
				neteja();
				System.out.println("Escriu el nom de jugador, o deixa en blanc per logejar anonimament: ");
				Player player = new Player(lee.next());
				System.out.println("Benvingut, " + player.getPlayerName() + " , el teu id es: " + player.getId());
				playerId = player.getId();
				break;
			case 2:
				neteja();
				if (playerId == 0) {
					System.out.println("Has d'estar logejat com a jugador per tirar daus");
					break;
				} else {
					String resposta;
					do {
						neteja();
						ThrowDices tirada = new ThrowDices(playerId);
						tirada.won = tirada.tiraDaus();
						tiradasService.addTirada(tirada);
						System.out.println("Vols tornar a tirar? S/N");
						resposta = lee.next();
					} while (resposta.toUpperCase().equals("S"));
					break;
				}
			case 3:
				neteja();
				// TODO consultes
				System.out.println(tiradasService.showThrows());
				System.out.println("blablabla historial");
				break;
			default:
				break;	
			}
			

		} while (select == 1 || select == 2 || select == 3);
		
		System.out.println("Bye bye, hasta otro ratito!");

		/*
		 * ThrowDices tirada = new ThrowDices(3); tirada.tira();
		 */
	}

}
