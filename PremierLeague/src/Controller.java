//package premierLeague;

public class Controller {

	private Table table;	 

	public Controller(Table table) {
		this.table = table;
	}

	public void commandLoop(String[] input) {
		System.out.println();
		switch(input[0]) {
		case "0":
			System.out.println("help                                             0");
			System.out.println("display entries                                  1");
			System.out.println("display selected statistics                      2");
			System.out.println("lookup a specified team                          3 team");
			System.out.println("find teams with same points as a specified team  4 team");
			System.out.println("add a new result                                 5 team1 g1 b1 team2 g2 b2");
			System.out.println("quit                                             9");
			break;

		case "1" :
		    //SF refers to Score For and SA refers to Score Against
			System.out.println("Pos	Team	Played	Points	   %	Won	Lost	Drawn	 SF	 SA");
			for( Entry e : table.getAllEntries())
				System.out.println(e);
			break;

		case "2" :
			String highTeam = "";
			int high = -1;
			String lowTeam = "";
			int low = Integer.MAX_VALUE;
			
			for( Entry e : table.getAllEntries()) {
				 if(high < e.getScoreFor() ){
					 high = e.getScoreFor();
					 highTeam = e.getTeam(); 					 
				 }
				 
				 if( low > e.getScoreAgainst()){
					 low = e.getScoreAgainst();
					 lowTeam = e.getTeam() ; 
				 }		 	
			}
			System.out.println("1. The team that has scored the highest number of points:\t\t\t" + highTeam);
			System.out.println("2. The team that has had the lowest number of points scored against them:\t" + lowTeam);
			System.out.println("3. The average value of the points scored for all teams:\t\t\t" + table.averageScoreFor());			
			break;			
			
		case "3" :
			if(input.length < 2){
				System.out.println("Team not available");
			}
			else {
				//SF refers to Score For and SA refers to Score Against
				System.out.println("Pos	Team	Played	Points	   %	Won	Lost	Drawn	 SF	 SA");
				System.out.println(table.lookupTeam(input[1]));
			}
			break;
			
		case "4" :
			if(input.length < 2){
				System.out.println("Team not available");
			}
			else {
				//SF refers to Score For and SA refers to Score Against
				System.out.println("Pos	Team	Played	Points	   %	Won	Lost	Drawn	 SF	 SA");
				Entry e = table.lookupTeam(input[1]);
				for(Entry team : table.getAllEntries()) {
					if(e.getPoints() == team.getPoints()) {
						System.out.println(team);
					}
				}
			}
			break;			
			
		case "5" : 
			try{
				table.processGame(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4], Integer.parseInt(input[5]), Integer.parseInt(input[6]));
			}catch(Exception e) {
				System.out.println("invalid input");
			}

		default :
			break;
		}
	}
}
