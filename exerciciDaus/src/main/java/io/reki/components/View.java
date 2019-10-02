package io.reki.components;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class View implements ApplicationListener<ApplicationReadyEvent>{
	public void neteja() {
		for (int i = 0; i < 30; ++i)
			System.out.println();
	}

	@Autowired
	private TiradasService tiradasService;

	public void probar(TiradasService tiradasService) {
		this.tiradasService=tiradasService;
		Scanner lee = new Scanner(System.in);
		int select;
		Player player = null;
		

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
				player = new Player(lee.next());
				System.out.println("Benvingut, " + player.getPlayerName() + " , el teu id es: " + player.getId()
						+ ", i data:" + player.getRegisterDate());
				tiradasService.updatePlayer(player);
				break;
			case 2:
				neteja();
				if (player == null) {
					System.out.println("Has d'estar logejat com a jugador per tirar daus");
					break;
				} else {
					String resposta;
					do {
						neteja();
						ThrowDices tirada = new ThrowDices(player.getId());
						System.out.println(tirada);
						tiradasService.addTirada(tirada);
						System.out.println("Vols tornar a tirar? S/N");
						resposta = lee.next();
					} while (resposta.toUpperCase().equals("S"));
					break;
				}
			case 3:
				neteja();
				// TODO consultes
				//System.out.println(tiradasService.showThrows());
				System.out.println(tiradasService.getAllPlayers());
				break;
			default:
				break;
			}

		} while (select == 1 || select == 2 || select == 3);

		System.out.println("Bye bye, hasta otro ratito!");
	}
	//this part launches probar when all the program is setup and ready
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		probar(tiradasService);
		return;
	}

}
