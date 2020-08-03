//package premierLeague;

import java.text.DecimalFormat;

public class Entry {
	private int position;
	private String team ;
	private int played ;
	private int points ;
	private double percentage ;
	private int won ;
	private int lost ;
	private int drawn;
	private int scoreFor;
	private int scoreAgainst ;
	
	public Entry() {
		
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public int getDrawn() {
		return drawn;
	}
	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}
	public int getScoreFor() {
		return scoreFor;
	}
	public void setScoreFor(int scoreFor) {
		this.scoreFor = scoreFor;
	}
	public int getScoreAgainst() {
		return scoreAgainst;
	}
	public void setScoreAgainst(int scoreAgainst) {
		this.scoreAgainst = scoreAgainst;
	}
	
	
	public void processResult (int for1 , int against) {
		
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		
		return "" + position + "\t " + team + "\t  " + played + "\t  " + points
				+ "\t  " + df.format(percentage) + "\t  " + won + "\t  " + lost + "\t  " + drawn + "\t  "
				+ scoreFor + "\t  " + scoreAgainst + "";
	}
}
