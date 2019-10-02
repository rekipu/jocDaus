package io.reki.components;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiradasRepository extends CrudRepository <ThrowDices , Integer>{

	public List<ThrowDices> findByPlayerId(int playerId);
	public List<ThrowDices> findByPlayerIdAndWonTrue(int playerId);
	
	public void deleteByPlayerId(int id);
	public Iterable<ThrowDices> getByPlayerId(int id);
}
