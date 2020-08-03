//package premierLeague;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
	private Entry[] table;
	private int nTeams;
	public Table(){
		this.nTeams = 8;
		this.table = new Entry[this.nTeams];
		load();
	}

	public List<Entry> getAllEntries(){
		return Arrays.asList(table);
	}

	public Entry lookupTeam (String t){
		for(Entry team : table ){
			if(t != null && t.equals(team.getTeam())){
				return team;
			}
		}
		return null;
	}

	public ArrayList<Entry> findTeamOnSamePoints(String t){
		ArrayList<Entry> res = new ArrayList<Entry>();
		Entry team = lookupTeam(t);
		for(Entry team1 : table){
			if(t != null && t.equals(team.getTeam())){
				res.add(team1); 
			}
		}
		return res;
	}

	public int highestScoreFor(){
		int high = -1;
		for(int i = 0; i < this.nTeams; i++) {
			if(high < table[i].getScoreFor()){
				high = table[i].getScoreFor();
			}
		}
		return high;
	}

	public int highestScoreAgainst() {
		int low = Integer.MAX_VALUE; 
		for(int i = 0; i < this.nTeams; i++) {
			if( low > table[i].getScoreAgainst()){
				low = table[i].getScoreAgainst();
			}
		}
		return low;
	}

	public double averageScoreFor(){
		double avg = 0;
		for(int i = 0; i < this.nTeams; i++) {
			avg += table[i].getPoints();
		}
		return avg/this.nTeams;
	}

	public void processGame(String t1, int g1, int b1, String t2, int g2, int b2){
		Entry team1 = null;
		Entry team2 = null;
		int scoredFor = ((g1 * 6) + b1) ;
		int scoredAgainst = (g2 * 6) + b2;	
		
		for(Entry team : getAllEntries()){
			if(t1.equals(team.getTeam())){
				team1 = team;
			}
			if(t2.equals(team.getTeam())){
				team2 = team;
			}
		}
		team1.setPlayed(team1.getPlayed() + 1);
		team2.setPlayed(team2.getPlayed() + 1);
		if(scoredFor == scoredAgainst){
			team1.setDrawn(team1.getDrawn() + 1);
			team2.setDrawn(team2.getDrawn() + 1);
		}
		else if(scoredFor > scoredAgainst){
			team1.setWon(team1.getWon() + 1);
			team2.setLost(team2.getLost() + 1);
		}
		else if(scoredFor < scoredAgainst){
			team2.setWon(team2.getWon() + 1);
			team1.setLost(team1.getLost() + 1);
		}
		team1.setScoreFor(team1.getScoreFor() + scoredFor);
		team1.setScoreAgainst(team1.getScoreAgainst() + scoredAgainst);
		
		team2.setScoreFor(team2.getScoreFor() + scoredAgainst);
		team2.setScoreAgainst(team2.getScoreAgainst() + scoredFor);
		
		for(Entry e : getAllEntries()) {
		e.setPercentage(((double) e.getScoreFor()  / (e.getScoreAgainst() + e.getScoreFor())) * 100);
		e.setPoints((e.getWon() * 2) + e.getDrawn());
		}
		sort();		
	}

	private void load(){
		String teams[] = {"t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8"};
		int wins[] = {3, 3, 2, 1, 1, 1, 1, 0};
		int losses[] = {0, 0, 1, 2, 2, 2, 2, 3};
		int drawn[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int scoreFor[] = {149, 127, 105, 90, 85, 60, 50, 81};
		int scoreAgainst[] = {50, 59, 65, 104, 118, 107, 150, 94};

		for(int i = 0; i < this.nTeams; i++) {
			Entry e = new Entry();
			e.setTeam(teams[i]);
			e.setWon(wins[i]);
			e.setLost(losses[i]);
			e.setDrawn(drawn[i]);
			e.setScoreFor(scoreFor[i]);
			e.setScoreAgainst(scoreAgainst[i]);
			e.setPercentage(((double)scoreFor[i] / (scoreAgainst[i] + scoreFor[i])) * 100);
			e.setPlayed(wins[i] + losses[i] + drawn[i]);
			e.setPoints( (wins[i] * 2) + drawn[i] );
			table[i] = e;
		}
		sort();

	}

	private int compare(Entry e1, Entry e2) {
		if(e1.getPoints() > e2.getPoints() ) {
			return 1;
		}
		else if(e2.getPoints() > e1.getPoints() ) {
			return -1;
		}
		else if(e1.getPercentage() > e2.getPercentage()) {
			return 1 ;
		}
		else if (e1.getPercentage() > e2.getPercentage()) {
			return -1;
		}
		else {
			return 0;
		}
	}

	private void sort()
	{
		int n = table.length;

		for (int i = 0; i < n-1; i++)
		{
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (compare (table[j], table[min_idx]) == 1)
					min_idx = j;
			Entry temp = table[min_idx];
			table[min_idx] = table[i];
			table[i] = temp;
		}

		for(int p = 0; p < table.length; p++) {
			table[p].setPosition(p + 1);
		}
	}
}
