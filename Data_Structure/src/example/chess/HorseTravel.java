package example.chess;

public class HorseTravel {
	
	private int[][] chessboard;
	private boolean show;
	public HorseTravel(int n, int x, int y, boolean show) {
		
		chessboard = new int[n][n];
		
		
		this.show = show;
		start(x, y);
	}
	private void start(int x, int y) {
		Position current = new Position(x, y);
		int count = 1;
		int direction = 1;
		int n = chessboard.length;
		while (count<=n*n&&direction!=0) {
			chessboard[current.x][current.y] = count;
			if(this.show){
				System.out.print("第"+count+"步    ");
			}
			direction = select(current);
			if(direction == 0 && count <n*n){
				System.out.println("第"+count+"步无路可通");
			}else {
				count++;
				current = geoStep(current, direction);
			}
		}
		if(!show){ 
			this.print();
		}
		
	}
	private void print() {
		for(int i = 0; i<this.chessboard.length; i++){
			for(int j = 0; j<this.chessboard.length; j++){
				if(chessboard[i][j]>=0&&chessboard[i][j]<10){
					System.out.print(" ");
				}
				System.out.print(" "+chessboard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private Position geoStep(Position current, int direction) {
		int x = current.x;
		int y = current.y;
		switch (direction) {
		
		case 1:x = x-2; y = y+1; break;
		case 2:x = x-1; y = y+2; break;	
		case 3:x = x+1; y = y+2; break;	
		case 4:x = x+2; y = y+1; break;	
		case 5:x = x+2; y = y-1; break;	
		case 6:x = x+1; y = y-2; break;	
		case 7:x = x-1; y = y-2; break;	
		case 8:x = x-2; y = y-1; break;	
			
		}
		int n = chessboard.length;
		if(x>=0&&x<n&&y>=0&&y<n&&chessboard[x][y]==0){
			return new Position(x, y);
		}else {
			return null;
		}
		
	}
	private int select(Position current) {
		if(this.show){
			System.out.println("当前位置： "+current.toString());
			this.print();
			System.out.println("方向    下一位置    可通方向    可通路数");
		}
		int direction = 0;
		int minroad = 8;
		for(int i = 0; i<=8; i++){
			int road = 0;
			Position next1 = geoStep(current, i);
			if(next1!=null){
				if(this.show){
					System.out.print("    "+i+ "\t" + next1.toString() + "\t");
				}
				for(int j = 1; j<=8;j++){
					Position next2 = geoStep(next1, j);
					if(next2!=null){
						road++;
						if(this.show){
							System.out.print(j+",");
						}
					}
				}
				if(road <minroad){
					minroad = road;
					direction = i;
				}
				if(this.show){
					System.out.println("\t"+road);
				}
			}
			if(this.show){
				System.out.println("选定下一步方向    direction="+direction+"\r\n");
			}
		}
		return direction;
	}
	public static void main(String[] args) {
		new HorseTravel(8, 0, 0, true);
	}
	
}
