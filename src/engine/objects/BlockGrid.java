package engine.objects;

import java.util.HashMap;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class BlockGrid implements GameObject{
	private Vector3f position, rotation, scale;
	private Mesh mesh;
	
	private HashMap<Vector3f, Block> grid = new HashMap<Vector3f, Block>();
	private Material terrain = Block.terrain;
	private Vector2f d = new Vector2f(32.0f, 0.0f);
	private Vector2f w = new Vector2f(64.0f, 0.0f);
	private Vector2f s = new Vector2f(16.0f, 0.0f);
	private Vector2f i = new Vector2f(96.0f, 16.0f);
	private Vector2f a = new Vector2f(128.0f, 16.0f);
	private Vector2f g = new Vector2f(48.0f, 0.0f);
	private Vector2f t = new Vector2f(0.0f, 0.0f);
	
	private Mesh air = new Mesh(Block.airVertices, Block.blockIndices, terrain);
	private Mesh dirt = new Mesh(Block.blockVertices(d, d, d, d, d, d), Block.blockIndices, terrain);
	private Mesh wood = new Mesh(Block.blockVertices(w, w, w, w, w, w), Block.blockIndices, terrain);
	private Mesh stone = new Mesh(Block.blockVertices(s, s, s, s, s, s), Block.blockIndices, terrain);
	private Mesh iron = new Mesh(Block.blockVertices(i, i, i, i, i, i), Block.blockIndices, terrain);
	private Mesh diamond = new Mesh(Block.blockVertices(a, a, a, a, a, a), Block.blockIndices, terrain);
	private Mesh grass = new Mesh(Block.blockVertices(g, g, g, g, t, d), Block.blockIndices, terrain);
	
	public BlockGrid(HashMap<Vector3f, Integer> map) {
		this.position = new Vector3f(0, 0, 0);
		this.rotation = new Vector3f(0, 0, 0);
		this.scale = new Vector3f(1, 1, 1);
		
		for(Vector3f i : map.keySet()) {
			Mesh type;

			switch(map.get(i)) {
			case 0:
				type = air;
				break;
			case 1:
				type = grass;
				break;
			case 2:
				type = dirt;
				break;
			case 3:
				type = wood;
				break;
			case 4:
				type = stone;
				break;
			case 5:
				type = iron;
				break;
			case 6:
				type = diamond;
				break;
			default:
				type = dirt;
				break;
			}
			grid.put(i, new Block(i, new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), type));
		}
	}
	
	public BlockGrid(int[][][] map) {
		this.position = new Vector3f(0, 0, 0);
		this.rotation = new Vector3f(0, 0, 0);
		this.scale = new Vector3f(1, 1, 1);
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				for(int k = 0; k < map[0][0].length; k++) {
					Mesh type;
					switch(map[i][j][k]) {
					case 0:
						type = air;
						break;
					case 1:
						type = grass;
						break;
					case 2:
						type = dirt;
						break;
					case 3:
						type = wood;
						break;
					case 4:
						type = stone;
						break;
					case 5:
						type = iron;
						break;
					case 6:
						type = diamond;
						break;
					default:
						type = dirt;
						break;
					}
					if(!(type.equals(air))) {
						grid.put(new Vector3f((float) i, (float) j, (float) k), new Block(new Vector3f((float) i, (float) j, (float) k), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), type));
					}
				}
			}
		}
	}
	
	public void create() {
		dirt.create();
		wood.create();
		stone.create();
		iron.create();
		diamond.create();
		grass.create();
		
		mesh = Mesh.blockMesh(grid);
		mesh.create();
	}
	
	public void destroy() {
		dirt.destroy();
		wood.destroy();
		stone.destroy();
		iron.destroy();
		diamond.destroy();
		grass.destroy();
		mesh.destroy();
	}
	
	public void reload(int[][][] map) {
		destroy();
		//this.map = map;
		//int x = map.length;
		//int y = map[0].length;
		//int z = map[0][0].length;
		//grid = new Block[x][y][z];
		create();
	}
	
	//public void reload(BlockGrid2 newGrid) {
	//	reload(newGrid.getMap());
	//}

	public HashMap<Vector3f, Block> getGrid() {
		return grid;
	}

	/* public int getX() {
		return map.length;
	}

	public int getY() {
		return map[0].length;
	}

	public int getZ() {
		return map[0][0].length;
	} 
	
	public int[][][] getMap() {
		return map;
	} */

	public Vector3f getPosition() {
		return position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public Mesh getMesh() {
		return mesh;
	}
	
}
