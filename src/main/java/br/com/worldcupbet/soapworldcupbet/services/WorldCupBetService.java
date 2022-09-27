package br.com.worldcupbet.soapworldcupbet.services;


import java.util.ArrayList;
import java.util.List;

public class WorldCupBetService {
	private static List<Bet> betList = new ArrayList<Bet>();

	public WorldCupBetService() {
		if(betList.size() == 0) {			
			Bet bet1 = new Bet();
			Bet bet2 = new Bet();
			
			bet1.setPunterName("Dickson");
			bet1.setTeamOnWhichBet("Brasil");
			bet1.setBetValue(450.50);
			
			bet2.setPunterName("Pedro");
			bet2.setTeamOnWhichBet("França");
			bet2.setBetValue(800.00);
			
			
			betList.add(bet1);
			betList.add(bet2);
		}
	}
	
	public List<Bet> getBets() {
		System.out.println("{getBets}:: start");
		
		return betList;
	}
	
	public Bet getByPunterName(String punterName) {
		
		Bet bet = new Bet();
		
		for (Bet b : betList) {
			if(punterName.equals(b.getPunterName())){
				bet = b;
				break;
			}
		}		
		
		return bet;
	}
	
	public void addBet(Bet bet){		
		System.out.println("{addHighScore} Adding: ["+bet.getPunterName()+"'s Bet]");
		for (Bet b : betList) {
			if(bet.getPunterName().equals(b.getPunterName())){
				return;
			}
		}
		
		betList.add(bet);		
	}
	
	
	public void delete(String punterName) throws Exception {
		System.out.println("{delete} deleting: ["+punterName+"'s Bet]");
		
		Bet bet = new Bet();
		
		for (Bet b : betList) {
			if(punterName.equals(b.getPunterName())){
				bet = b;
				break;
			}
		}
		
		betList.remove(bet);
	}
	
	public void updateBet(Bet bet) {				
		System.out.println("{delete} updating: ["+bet.getPunterName()+"'s Bet]");
		
		for (Bet b : betList) {
			if(bet.getPunterName().equals(b.getPunterName())){
				b.setTeamOnWhichBet(bet.getTeamOnWhichBet());
				b.setBetValue(bet.getBetValue());
				return;
			}
		}	
	}
}
