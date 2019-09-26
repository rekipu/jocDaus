package io.reki.components;

import java.util.ArrayList;
import java.util.List;

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
	
	
	

}
