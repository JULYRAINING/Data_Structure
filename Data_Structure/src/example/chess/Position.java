package example.chess;

public class Position {

	public int x;
	public int y;
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Position(){
		this(0, 0);
	}
	public Position(Position p){
		this(p.x, p.y);
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
}
