//import Enums.FieldType;
//
//public class Map {
//
//	private Field[][] fields;
//	
//	public Map() {}
//	
//	public void setActor(int x, int y, Actor act) {
//		this.fields[x][y].setActor(act);
//	}
//	
//	public void removeActor(int x, int y, Actor act) {
//		this.fields[x][y].setActor(null);
//	}
//	
//	public Field getField(int x, int y) {
//		return this.fields[x][y];
//	}
//	
//	public void generate(int x) {
//		if (x==0) {
//		this.fields = new Field[20][20];
//		for (int i = 0; i<20; i++) {
//			for (int j = 0; j<20; j++) {
//				this.fields[i][j] = new Field(i, j, FieldType.CLEAR);
//			}
//		}
//	}
//		if (x==1) {
//		this.fields = new Field[50][50];
//		for (int i = 0; i<50; i++) {
//			for (int j = 0; j<50; j++) {
//				this.fields[i][j] = new Field(i, j, FieldType.CLEAR);
//			}
//		}
//	}
//		if (x==2) {
//		this.fields = new Field[50][50];
//		for (int i = 0; i<50; i++) {
//			for (int j = 0; j<50; j++) {
//				this.fields[i][j] = new Field(i, j, FieldType.CLEAR);
//			}
//		}
//		fields[5][5] = new Field(5, 5, FieldType.WALL);
//		fields[6][5] = new Field(6, 5, FieldType.WALL);
//		fields[7][5] = new Field(7, 5, FieldType.WALL);
//		
//		fields[42][5] = new Field(42, 5, FieldType.WALL);
//		fields[43][5] = new Field(43, 5, FieldType.WALL);
//		fields[44][5] = new Field(44, 5, FieldType.WALL);
//	}
//	}
//}
