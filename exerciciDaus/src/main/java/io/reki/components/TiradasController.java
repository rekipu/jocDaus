package io.reki.components;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiradasController {

	@Autowired
	private TiradasService tirServ;

	@RequestMapping(method = RequestMethod.POST, value = "/players")
	public void updatePlayer(Player player) {
		tirServ.updatePlayer(player);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/players/{id}/games/")
	public void tiraDaus(ThrowDices tirada) {
		tirServ.addTirada(tirada);
	}

//	DELETE /players/{id} elimina el jugador. 
	@DeleteMapping(value = "/players/{id}")
	public void deletePlayer(Player player) {
		tirServ.deletePlayer(player);
	}

//	DELETE /players/{id}/games: elimina les tirades del jugador.
	@DeleteMapping(value = "/players/{id}/games")
	public void deleteTiradas(Player player) {
		tirServ.deleteTiradas(player);
	}

//	GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
	@RequestMapping("/players")
	public List<Player> getPlayers() {
		return tirServ.getAllPlayers();
		// TODO afegir el percentatge de victories
	}

//	GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	@RequestMapping("/players/{id}/games")
	public List<ThrowDices> getTiradesByPlayerId(Player player) {
		return tirServ.getTiradesByPlayerId(player.getId());
	}

//
//	GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits. 
	@RequestMapping("/players/ranking")
	public TreeMap<Double, String> getRanking() {
		TreeMap<Double, String> mapa = new TreeMap();
		List<Player> jugadors = tirServ.getAllPlayers();
		for(int i=0;i<jugadors.size();i++) {
			mapa.put(percentWin(jugadors.get(i)), jugadors.get(i).getPlayerName());
		}
		return mapa;
		
	}
//	GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	@RequestMapping("/players/ranking/loser")
	public Entry<Double, String> getLoser() {
		return getRanking().lowerEntry(null);
		
	}
	
//	GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	@RequestMapping("/players/ranking/winner")
	public Entry<Double, String> getWinner() {
		return getRanking().higherEntry(null);
		
	}
// aquest es per utilitzar en altres classes, dona percentatge d'exit per jugador:
	public Double percentWin(Player player) {
		int mitja = 0;
		int contador = 0;
		List<ThrowDices> tirades = tirServ.getTiradesByPlayerId(player.getId());
		for (int i=0; i < tirades.size(); i++) {
			contador++;
			if (tirades.get(i).isWon()) {
				mitja++;
			}
		}
		return (double) (mitja / contador);
	}
}