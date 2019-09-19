package io.reki;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiradasRepository extends CrudRepository <ThrowDices , Integer>{

	List<ThrowDices> findByPlayerId(int playerId);
	List<ThrowDices> findByPlayerIdAndWonTrue(int playerId);
}
