package engine.objects;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class BlockGrid {
	private int x, y, z;
	private Material terrain = new Material("/textures/terrain.png");
	private GameObject[][][] grid = new GameObject[x][y][z];
	
	private Vector2f d = new Vector2f(32.0f, 0.0f);
	private Vector2f w = new Vector2f(64.0f, 0.0f);
	private Vector2f s = new Vector2f(16.0f, 0.0f);
	private Vector2f i = new Vector2f(96.0f, 16.0f);
	private Vector2f a = new Vector2f(128.0f, 16.0f);
	private Vector2f g = new Vector2f(48.0f, 0.0f);
	private Vector2f t = new Vector2f(0.0f, 0.0f);
	
	/*private Vector2f[] grass = {
			g, g, g, g, t, d
	};
	private Vector2f[] dirt = {
			d, d, d, d, d, d
	};
	private Vector2f[] wood = {
			w, w, w, w, w, w
	};
	private Vector2f[] stone = {
			s, s, s, s, s, s
	};
	private Vector2f[] iron = {
			i, i, i, i, i, i
	};
	private Vector2f[] diamond = {
			a, a, a, a, a, a
	}; */
	
	private Vertex[] airVertices = {};
	private int[] airIndices = Block.blockIndices;
	
	//private GameObject grid = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), blockMesh());
	private Mesh air = new Mesh(airVertices, airIndices, terrain);
	private Mesh dirt = new Mesh(Block.blockVertices(d, d, d, d, d, d), Block.blockIndices, terrain);
	private Mesh wood = new Mesh(Block.blockVertices(w, w, w, w, w, w), Block.blockIndices, terrain);
	private Mesh stone = new Mesh(Block.blockVertices(s, s, s, s, s, s), Block.blockIndices, terrain);
	private Mesh iron = new Mesh(Block.blockVertices(i, i, i, i, i, i), Block.blockIndices, terrain);
	private Mesh diamond = new Mesh(Block.blockVertices(a, a, a, a, a, a), Block.blockIndices, terrain);
	private Mesh grass = new Mesh(Block.blockVertices(g, g, g, g, t, d), Block.blockIndices, terrain);
	private Mesh ditto = Mesh.combine(iron, diamond); 
	
	private int[][][] map;
	
	/*private Mesh blockMesh() {
		Mesh result = new Mesh(Block.blockVertices(g, g, g, g, g, g), Block.blockIndices, terrain);
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					Vector2f[] type;
					System.out.println("Grid Indices is " + result.getIndices().toString());
					switch(map[i][j][k]) {
					case 0:
						type = null;
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
					default:
						type = diamond;
						break;
					}
					if (type != null) {
						//System.out.println("Added block at (" + i + ", " + j + ", " + k + ") of type " + type);

						result = Mesh.combine(result, new Mesh(Block.blockVertices(type, new Vector3f(i, j, k)), Block.blockIndices, terrain));
					}
					
				}
			}
		} 
			
		//System.out.println("Grid Indices is " + result.getIndices().toString());
		return result;
	} */
	//private Mesh debug = new Mesh(Block.blockVertices, Block.blockIndices, new Material("/textures/debug2.png"));

	
	public BlockGrid(int x, int y, int z, int[][][] map) {
		this.x = x;
		this.y = y;
		this.z = z;
		grid = new GameObject[x][y][z];
		this.map = map;
		//grid = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), blockMesh());
		
	}
	
	public void create() {
		dirt.create();
		wood.create();
		stone.create();
		iron.create();
		diamond.create();
		grass.create();
		//ditto.create();
		//debug.create();
		//blockMesh().create();
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					Mesh type;
					//System.out.println("Block at (" + i + ", " + j + ", " + k + ") is " + map[i][j][k]);
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
					default:
						type = diamond;
						break;
					}
					grid[i][j][k] = new GameObject(new Vector3f((float) i, (float) j, (float) k), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), type);
				}
			}
		}
	}
	
	public void destroy() {
		dirt.destroy();
		wood.destroy();
		stone.destroy();
		iron.destroy();
		diamond.destroy();
		grass.destroy();
		//ditto.destroy();
		//debug.destroy();
		//blockMesh().destroy();
	}
	
	public void reload(int x, int y, int z, int[][][] map) {
		destroy();
		this.x = x;
		this.y = y;
		this.z = z;
		grid = new GameObject[x][y][z];
		//grid = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), blockMesh());
		this.map = map;
		create();
	}

	public GameObject[][][] getGrid() {
		return grid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
}
