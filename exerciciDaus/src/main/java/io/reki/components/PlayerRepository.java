package io.reki.components;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository <Player, Integer>{

	public Player getByIdPlayer(int id);

	public Player getPlayerByPlayerName(String string);
	
}
