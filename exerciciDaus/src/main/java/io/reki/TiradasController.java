package io.reki;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TiradasController {
	
	@Autowired
	private TiradasService tirServ;
	
	@RequestMapping("/players")
	public List<Player> getPlayers(){
		return tirServ.getAllPlayers();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/players")
	public void updatePlayer(Player player) {
		tirServ.updatePlayer(player);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/players/{id}/games/")
	public void tiraDaus(Player player) {
		//TODO implementar jugada a un jugador concret
	}
	
	
	

}
