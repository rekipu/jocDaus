package io.reki.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiradasService {

	@Autowired
	private TiradasRepository tirRepo;
	@Autowired
	private PlayerRepository playRepo;
	
	public TiradasService(TiradasRepository tirRepo, PlayerRepository playRepo) {
		this.tirRepo = tirRepo;
		this.playRepo = playRepo;
	}
	
	public void test() {
		System.out.println("prova");
	}
	
	public Player getPlayerById(int id) {
		return playRepo.getByIdPlayer(id);
	}

	public void addTirada(ThrowDices tirada) {
		tirRepo.save(tirada);
	}

	public List<ThrowDices> showThrows() {
		List<ThrowDices> tirades = new ArrayList<>();
		tirRepo.findAll().forEach(tirades::add);
		return tirades;
	}

	public void showThrowsByPlayer(int id) {
		tirRepo.findByPlayerId(id).forEach(tirada -> System.out.println(tirada));
	}

	public List<Player> getAllPlayers() {
		List<Player> jugadors = new ArrayList<>();
		playRepo.findAll().forEach(jugadors::add);
		return jugadors;
	}

	public void updatePlayer(Player player) {
		playRepo.save(player);
		
	}

	public void deletePlayer(Player player) {
		playRepo.delete(player);
	}

	public void deleteTiradas(int id) {
		tirRepo.deleteByPlayerId(id);
	}

	public List<ThrowDices> getTiradesByPlayerId(int id) {
		List<ThrowDices> tirades = new ArrayList<>();
		tirRepo.getByPlayerId(id).forEach(tirades::add);
		return tirades;
	}

	public List<ThrowDices> getAllTirades() {
		List<ThrowDices> tirades = new ArrayList<>();
		tirRepo.findAll().forEach(tirades::add);
		return tirades;
	}

	public Player getPlayerByPlayerName(String string) {
		return playRepo.getPlayerByPlayerName(string);
	}

//	public ThrowDices getTiradaById(int id) {
//		return tirRepo.findById(id);
//	}
//	
	
	

}
