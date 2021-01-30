package engine.objects;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class BlockGrid implements GameObject{
	private Vector3f position, rotation, scale;
	private Mesh mesh;
	
	private int[][][] map;
	//private int x, y, z;
	private Block[][][] grid; // = new GameObject[map.length][map[0].length][map[0][0].length];
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
	private Mesh diamond1 = Mesh.translate(diamond, new Vector3f(0, 1, 0));
	private Mesh diamond2 = Mesh.translate(diamond, new Vector3f(0, 2, 0));
	private Mesh grass = new Mesh(Block.blockVertices(g, g, g, g, t, d), Block.blockIndices, terrain);
	private Mesh ditto = Mesh.combine(iron, diamond1); 
	private Mesh ditto1 = Mesh.cuboid(grass, new Vector3f(10, 10, 16));
	

	
	
	//private Mesh debug = new Mesh(Block.blockVertices, Block.blockIndices, new Material("/textures/debug2.png"));
	
	public BlockGrid(int[][][] map) {
		this.position = new Vector3f(0, 0, 0);
		this.rotation = new Vector3f(0, 0, 0);
		this.scale = new Vector3f(1, 1, 1);
		this.map = map;
		int x = map.length;
		int y = map[0].length;
		int z = map[0][0].length;
		grid = new Block[x][y][z];
		//create();

		
		
	}
	
	public void create() {
		dirt.create();
		wood.create();
		stone.create();
		iron.create();
		diamond.create();
		diamond1.create();
		diamond2.create();
		grass.create();
		ditto.create();
		ditto1.create();
		//debug.create();
		
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				for(int k = 0; k < map[0][0].length; k++) {
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
					case 6:
						type = diamond;
						break;
					case 7:
						type = diamond1;
						break;
					case 8:
						type = ditto;
						break;
					case 9:
						type = ditto1;
						break;
					default:
						type = dirt;
						break;
					}
					grid[i][j][k] = new Block(new Vector3f((float) i, (float) j, (float) k), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), type);
				}
			}
		}
		mesh = Mesh.blockMesh(grid);
		mesh.create();
	}
	
	public void destroy() {
		dirt.destroy();
		wood.destroy();
		stone.destroy();
		iron.destroy();
		diamond.destroy();
		diamond1.destroy();
		diamond2.destroy();
		grass.destroy();
		ditto.destroy();
		ditto1.destroy();
		//debug.destroy();
		mesh.destroy();
	}
	
	public void reload(int[][][] map) {
		destroy();
		this.map = map;
		int x = map.length;
		int y = map[0].length;
		int z = map[0][0].length;
		grid = new Block[x][y][z];
		//grid1 = new GameObject(new Vector3f(6, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Mesh.blockMesh(grid));
		//this.map = map;
		create();
	}
	
	public void reload(BlockGrid newGrid) {
		reload(newGrid.getMap());
	}

	public Block[][][] getGrid() {
		return grid;
	}

	public int getX() {
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
	}

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
