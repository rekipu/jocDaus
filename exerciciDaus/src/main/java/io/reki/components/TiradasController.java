package io.reki.components;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
// fer una tirada amb la id d'un jugador
	@RequestMapping(method = RequestMethod.POST, value = "/players/{id}/games/")
	public void tiraDaus(@PathVariable("id") int id) {
		ThrowDices tirada= new ThrowDices(id);
	}
//  tornar una tirada per id
//	@RequestMapping(value = "/tirades/{id}")
//	public ThrowDices getTirada(int id) {
//		if(tirServ.getTiradaById(id)!=null){
//		return tirServ.getTiradaById(id);
//	}else {
//		return null;
//	}
//	}
	@RequestMapping("/tirades")
	public List<ThrowDices> getTirades() {
		return tirServ.getAllTirades();
	}

//	DELETE /players/{id} elimina el jugador. 
	@DeleteMapping(value = "/players/{id}")
	public void deletePlayer(@PathVariable("id") int id) {
		tirServ.deletePlayer( tirServ.getPlayerById(id));
	}

//	DELETE /players/{id}/games: elimina les tirades del jugador.
	@DeleteMapping(value = "/players/{id}/games")
	public void deleteTiradas(@PathVariable("id") int id) {
		tirServ.deleteTiradas(id);
	}

//	GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
	@RequestMapping("/players")
	public List<Player> getPlayers() {
		return tirServ.getAllPlayers();
		// TODO afegir el percentatge de victories
	}

//	GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	@RequestMapping("/players/{id}/games")
	public List<ThrowDices> getTiradesByPlayerId(@PathVariable("id") int id ) {	
		return tirServ.getTiradesByPlayerId(id);
	}

//
//	GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits. 
	@RequestMapping("/players/ranking")
	public TreeMap<Double, String> getRanking() {
		TreeMap<Double, String> mapa = new TreeMap<Double, String>();
		List<Player> jugadors = tirServ.getAllPlayers();
		for(int i=0;i<jugadors.size();i++) {
			mapa.put(percentWin(jugadors.get(i)), jugadors.get(i).getPlayerName());
		}
		return mapa;
		
	}
//	GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	@RequestMapping("/players/ranking/loser")
	public Player getLoser() {
		TreeMap<Double, String> mapa = getRanking();
		return tirServ.getPlayerByPlayerName(mapa.get(mapa.firstKey()));
			
		}
		
		
	
//	GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	@RequestMapping("/players/ranking/winner")
	public Player getWinner() {
		TreeMap<Double, String> mapa = getRanking();
		return tirServ.getPlayerByPlayerName(mapa.get(mapa.lastKey()));
		
	}
	
// aquest es per utilitzar en altres classes, dona percentatge d'exit per jugador:
	public Double percentWin(Player player) {
		double mitja = 0;
		double contador = 0;
		List<ThrowDices> tirades = tirServ.getTiradesByPlayerId(player.getId());
		System.out.println("probant percentwin, tirades.size= "+ tirades.size() + ". tirades.get(0).isWon():"+ tirades.get(0).isWon());
		for (int i=0; i < tirades.size(); i++) {
			contador++;
			if (tirades.get(i).isWon()) {
				mitja++;
			}
		}
		System.out.println("mitja :"+mitja +"   contador:"+ contador+"  mitja / contador:"+mitja / contador);
		return (mitja / contador)*100;
	}
}