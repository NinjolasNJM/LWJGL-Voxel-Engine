package engine.objects;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class Block implements GameObject{
	
	private Vector3f position, rotation, scale;
	private Mesh mesh;
	
	public Block(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;
	}

	public static Vertex[] blockVertices(Vector2f s, Vector2f n, Vector2f w, Vector2f e, Vector2f t, Vector2f b) {
		return new Vertex[] {
				//South face
				new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f((s.getX()) / 256, (s.getY()) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f((s.getX()) / 256, (s.getY() + 16) / 256)),
				new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f((s.getX() + 16) / 256, (s.getY() + 16) / 256)),
				new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f((s.getX() + 16) / 256, (s.getY()) / 256)),
				
				//North face
				new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f((n.getX()) / 256, (n.getY()) / 256)),
				new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f((n.getX()) / 256, (n.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f((n.getX() + 16) / 256, (n.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f((n.getX() + 16) / 256, (n.getY()) / 256)),
				
				//West face
				new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f((w.getX()) / 256, (w.getY()) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f((w.getX()) / 256, (w.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f((w.getX() + 16) / 256, (w.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f((w.getX() + 16) / 256, (w.getY()) / 256)),
				
				//East face
				new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f((e.getX()) / 256, (e.getY()) / 256)),
				new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f((e.getX()) / 256, (e.getY() + 16) / 256)),
				new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f((e.getX() + 16) / 256, (e.getY() + 16) / 256)),
				new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f((e.getX() + 16) / 256, (e.getY()) / 256)),
				
				//Top face
				new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f((t.getX()) / 256, (t.getY()) / 256)),
				new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f((t.getX()) / 256, (t.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f((t.getX() + 16) / 256, (t.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f((t.getX() + 16) / 256, (t.getY()) / 256)),
				
				//Bottom face
				new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f((b.getX()) / 256, (b.getY()) / 256)),
				new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f((b.getX()) / 256, (b.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f((b.getX() + 16) / 256, (b.getY() + 16) / 256)),
				new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f((b.getX() + 16) / 256, (b.getY()) / 256)),
		};
	}
	
	public static int[] blockIndices = new int[] {
			//Back face
			0, 1, 3,	
			3, 1, 2,	
			
			//Front face
			4, 5, 7,
			7, 5, 6,
			
			//Right face
			8, 9, 11,
			11, 9, 10,
			
			//Left face
			12, 13, 15,
			15, 13, 14,
			
			//Top face
			16, 17, 19,
			19, 17, 18,
			
			//Bottom face
			20, 21, 23,
			23, 21, 22
	};
	
	public static Material terrain = new Material("/textures/terrain.png");
	public static Vertex[] airVertices = {};

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
