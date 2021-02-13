package engine.objects;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class Player implements GameObject {

	private Vector3f position, rotation, scale;
	private Mesh mesh;
	
	public Player(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;
	}
	
	public static Vertex[] playerVertices = new Vertex[] {
			//Head
			
			//Back face
			new Vertex(new Vector3f( 0.25f,  0.5f, -0.25f), new Vector2f((float) 24 / 64,(float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f, -0.25f), new Vector2f((float) 24 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.0f, -0.25f), new Vector2f((float) 32 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.5f, -0.25f), new Vector2f((float) 32 / 64,(float) 8 / 64)),
			
			//Front face
			new Vertex(new Vector3f(-0.25f,  0.5f,  0.25f), new Vector2f((float) 8 / 64, (float) 8 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.0f,  0.25f), new Vector2f((float) 8 / 64, (float) 16 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f,  0.25f), new Vector2f((float) 16 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.5f,  0.25f), new Vector2f((float) 16 / 64,(float) 8 / 64)),
			
			//Right face
			new Vertex(new Vector3f( 0.25f,  0.5f,  0.25f), new Vector2f((float) 16 / 64,(float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f,  0.25f), new Vector2f((float) 16 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f, -0.25f), new Vector2f((float) 24 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.5f, -0.25f), new Vector2f((float) 24 / 64,(float) 8 / 64)),
			
			//Left face
			new Vertex(new Vector3f(-0.25f,  0.5f, -0.25f), new Vector2f((float) 0 / 64,(float)  8 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.0f, -0.25f), new Vector2f((float) 0 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.0f,  0.25f), new Vector2f((float) 8 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.5f,  0.25f), new Vector2f((float) 8 / 64,(float)  8 / 64)),
			
			//Top face
			new Vertex(new Vector3f(-0.25f,  0.5f,  0.25f), new Vector2f((float) 8 / 64, (float) 0 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.5f, -0.25f), new Vector2f((float) 8 / 64, (float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.5f, -0.25f), new Vector2f((float) 16 / 64,(float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.5f,  0.25f), new Vector2f((float) 16 / 64,(float) 0 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f(-0.25f, -0.0f, -0.25f), new Vector2f((float) 16 / 64,(float) 0 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.0f,  0.25f), new Vector2f((float) 16 / 64,(float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f,  0.25f), new Vector2f((float) 24 / 64,(float) 8 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.0f, -0.25f), new Vector2f((float) 24 / 64,(float) 0 / 64)),
			
			//Body
			
			//Back face
			new Vertex(new Vector3f( 0.25f,  0.0f, -0.125f), new Vector2f((float) 32 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f,-0.125f), new Vector2f((float) 32 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f,-0.125f), new Vector2f((float) 40 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.0f, -0.125f), new Vector2f((float) 40 / 64,(float) 20 / 64)),
			
			//Front face
			new Vertex(new Vector3f(-0.25f,  0.0f,  0.125f), new Vector2f((float) 20 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f, 0.125f), new Vector2f((float) 20 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f, 0.125f), new Vector2f((float) 28 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.0f,  0.125f), new Vector2f((float) 28 / 64,(float) 20 / 64)),
			
			//Right face
			new Vertex(new Vector3f( 0.25f,  0.0f,   0.125f), new Vector2f((float) 28 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f,  0.125f), new Vector2f((float) 28 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f, -0.125f), new Vector2f((float) 32 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.0f,  -0.125f), new Vector2f((float) 32 / 64,(float) 20 / 64)),
			
			//Left face
			new Vertex(new Vector3f(-0.25f,  0.0f, -0.125f), new Vector2f((float) 16 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f,-0.125f), new Vector2f((float) 16 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f, 0.125f), new Vector2f((float) 20 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.0f,  0.125f), new Vector2f((float) 20 / 64,(float) 20 / 64)),
			
			//Top face
			new Vertex(new Vector3f(-0.25f,  0.0f,  0.125f), new Vector2f((float) 20 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f,  0.0f, -0.125f), new Vector2f((float) 20 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.0f, -0.125f), new Vector2f((float) 28 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f,  0.0f,  0.125f), new Vector2f((float) 28 / 64,(float) 16 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f(-0.25f, -0.75f, -0.125f), new Vector2f((float) 28 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f,  0.125f), new Vector2f((float) 28 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f,  0.125f), new Vector2f((float) 36 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f, -0.125f), new Vector2f((float) 36 / 64,(float) 16 / 64)),
			
			//Right Arm
			
			//Back face
			new Vertex(new Vector3f( -0.25f,  -0.0f, -0.125f), new Vector2f((float) 52 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( -0.25f, -0.75f, -0.125f), new Vector2f((float) 52 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( -0.5f,  -0.75f, -0.125f), new Vector2f((float) 56 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( -0.5f,   -0.0f, -0.125f), new Vector2f((float) 56 / 64,(float) 20 / 64)),
			
			//Front face
			new Vertex(new Vector3f(-0.5f,   -0.0f,  0.125f), new Vector2f((float) 44 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.5f,  -0.75f,  0.125f), new Vector2f((float) 44 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f,  0.125f), new Vector2f((float) 48 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f,  -0.0f,  0.125f), new Vector2f((float) 48 / 64,(float) 20 / 64)),
			
			//Right face
			new Vertex(new Vector3f( -0.25f,  -0.0f,  0.125f), new Vector2f((float) 48 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( -0.25f, -0.75f,  0.125f), new Vector2f((float) 48 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( -0.25f, -0.75f, -0.125f), new Vector2f((float) 52 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( -0.25f,  -0.0f, -0.125f), new Vector2f((float) 52 / 64,(float) 20 / 64)),
			
			//Left face
			new Vertex(new Vector3f(-0.5f,  -0.0f, -0.125f), new Vector2f((float) 40 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.5f, -0.75f, -0.125f), new Vector2f((float) 40 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.5f, -0.75f,  0.125f), new Vector2f((float) 44 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.5f,  -0.0f,  0.125f), new Vector2f((float) 44 / 64,(float) 20 / 64)),
			
			//Top face
			new Vertex(new Vector3f(  -0.5f,  -0.0f, -0.125f), new Vector2f((float) 44 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(  -0.5f,  -0.0f,  0.125f), new Vector2f((float) 44 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( -0.25f,  -0.0f,  0.125f), new Vector2f((float) 48 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( -0.25f,  -0.0f, -0.125f), new Vector2f((float) 48 / 64,(float) 16 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f( -0.25f,  -0.75f,  0.125f), new Vector2f((float) 48 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f( -0.25f,  -0.75f, -0.125f), new Vector2f((float) 48 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(  -0.5f,  -0.75f, -0.125f), new Vector2f((float) 52 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(  -0.5f,  -0.75f,  0.125f), new Vector2f((float) 52 / 64,(float) 16 / 64)),
			
			//Left Arm
			
			//Back face
			new Vertex(new Vector3f(  0.5f,  -0.0f, -0.125f), new Vector2f((float) 44 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(  0.5f, -0.75f, -0.125f), new Vector2f((float) 44 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f( 0.25f, -0.75f, -0.125f), new Vector2f((float) 48 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f( 0.25f,  -0.0f, -0.125f), new Vector2f((float) 48 / 64,(float) 52 / 64)),
			
			//Front face
			new Vertex(new Vector3f(0.25f,  -0.0f,  0.125f), new Vector2f((float) 36 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f,  0.125f), new Vector2f((float) 36 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.5f,  -0.75f,  0.125f), new Vector2f((float) 40 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.5f,   -0.0f,  0.125f), new Vector2f((float) 40 / 64,(float) 52 / 64)),
			
			//Right face
			new Vertex(new Vector3f( 0.5f,  -0.0f,  0.125f), new Vector2f((float) 40 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f( 0.5f, -0.75f,  0.125f), new Vector2f((float) 40 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f( 0.5f, -0.75f, -0.125f), new Vector2f((float) 44 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f( 0.5f,  -0.0f, -0.125f), new Vector2f((float) 44 / 64,(float) 52 / 64)),
			
			//Left face
			new Vertex(new Vector3f(0.25f,  -0.0f, -0.125f), new Vector2f((float) 32 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f, -0.125f), new Vector2f((float) 32 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f,  0.125f), new Vector2f((float) 36 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f,  -0.0f,  0.125f), new Vector2f((float) 36 / 64,(float) 52 / 64)),
			
			//Top face
			new Vertex(new Vector3f( 0.25f,  -0.0f, -0.125f), new Vector2f((float) 36 / 64,(float) 48 / 64)),
			new Vertex(new Vector3f( 0.25f,  -0.0f,  0.125f), new Vector2f((float) 36 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(  0.5f,  -0.0f,  0.125f), new Vector2f((float) 40 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(  0.5f,  -0.0f, -0.125f), new Vector2f((float) 40 / 64,(float) 48 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f(  0.5f,  -0.75f,  0.125f), new Vector2f((float) 40 / 64,(float) 48 / 64)),
			new Vertex(new Vector3f(  0.5f,  -0.75f, -0.125f), new Vector2f((float) 40 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f( 0.25f,  -0.75f, -0.125f), new Vector2f((float) 44 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f( 0.25f,  -0.75f,  0.125f), new Vector2f((float) 44 / 64,(float) 48 / 64)),
			
			//Right Leg
			
			//Back face
			new Vertex(new Vector3f( 0.0f,  -0.75f, -0.125f), new Vector2f((float) 12 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -1.5f,  -0.125f), new Vector2f((float) 12 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -1.5f,  -0.125f), new Vector2f((float) 16 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f, -0.125f), new Vector2f((float) 16 / 64,(float) 20 / 64)),
			
			//Front face
			new Vertex(new Vector3f(-0.25f, -0.75f,  0.125f), new Vector2f((float) 4 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.25f,  -1.5f,  0.125f), new Vector2f((float) 4 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.0f,   -1.5f,  0.125f), new Vector2f((float) 8 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.0f,  -0.75f,  0.125f), new Vector2f((float) 8 / 64,(float) 20 / 64)),
			
			//Right face
			new Vertex(new Vector3f( 0.0f, -0.75f,  0.125f), new Vector2f((float)  8 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -1.5f,  0.125f), new Vector2f((float)  8 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.0f,  -1.5f, -0.125f), new Vector2f((float) 12 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f( 0.0f, -0.75f, -0.125f), new Vector2f((float) 12 / 64,(float) 20 / 64)),
			
			//Left face
			new Vertex(new Vector3f(-0.25f, -0.75f, -0.125f), new Vector2f((float) 0 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f(-0.25f,  -1.5f, -0.125f), new Vector2f((float) 0 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f,  -1.5f,  0.125f), new Vector2f((float) 4 / 64,(float) 32 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f,  0.125f), new Vector2f((float) 4 / 64,(float) 20 / 64)),
			
			//Top face
			new Vertex(new Vector3f(-0.25f, -0.75f,  0.125f), new Vector2f((float) 4 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f, -0.75f, -0.125f), new Vector2f((float) 4 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -0.75f, -0.125f), new Vector2f((float) 8 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -0.75f,  0.125f), new Vector2f((float) 8 / 64,(float) 16 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f(-0.25f, -1.5f, -0.125f), new Vector2f((float)  8 / 64,(float) 16 / 64)),
			new Vertex(new Vector3f(-0.25f, -1.5f,  0.125f), new Vector2f((float)  8 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -1.5f,  0.125f), new Vector2f((float) 12 / 64,(float) 20 / 64)),
			new Vertex(new Vector3f( 0.0f,  -1.5f, -0.125f), new Vector2f((float) 12 / 64,(float) 16 / 64)),
			
			//Left Leg
			
			//Back face
			new Vertex(new Vector3f(0.25f, -0.75f, -0.125f), new Vector2f((float) 28 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -1.5f,  -0.125f), new Vector2f((float) 28 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.0f,  -1.5f,  -0.125f), new Vector2f((float) 32 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.0f,  -0.75f, -0.125f), new Vector2f((float) 32 / 64,(float) 52 / 64)),
			
			//Front face
			new Vertex(new Vector3f(0.0f,  -0.75f,  0.125f), new Vector2f((float) 20 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.0f,   -1.5f,  0.125f), new Vector2f((float) 20 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f,  -1.5f,  0.125f), new Vector2f((float) 24 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f,  0.125f), new Vector2f((float) 24 / 64,(float) 52 / 64)),
			
			//Right face
			new Vertex(new Vector3f(0.25f, -0.75f,  0.125f), new Vector2f((float) 24 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f,  -1.5f,  0.125f), new Vector2f((float) 24 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f,  -1.5f, -0.125f), new Vector2f((float) 28 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f, -0.125f), new Vector2f((float) 28 / 64,(float) 52 / 64)),
			
			//Left face
			new Vertex(new Vector3f(0.0f, -0.75f, -0.125f), new Vector2f((float) 16 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.0f,  -1.5f, -0.125f), new Vector2f((float) 16 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.0f,  -1.5f,  0.125f), new Vector2f((float) 20 / 64,(float) 64 / 64)),
			new Vertex(new Vector3f(0.0f, -0.75f,  0.125f), new Vector2f((float) 20 / 64,(float) 52 / 64)),
			
			//Top face
			new Vertex(new Vector3f(0.0f,  -0.75f,  0.125f), new Vector2f((float) 20 / 64,(float) 48 / 64)),
			new Vertex(new Vector3f(0.0f,  -0.75f, -0.125f), new Vector2f((float) 20 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f, -0.125f), new Vector2f((float) 24 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -0.75f,  0.125f), new Vector2f((float) 24 / 64,(float) 48 / 64)),
			
			//Bottom face
			new Vertex(new Vector3f(0.0f,  -1.5f, -0.125f), new Vector2f((float) 24 / 64,(float) 48 / 64)),
			new Vertex(new Vector3f(0.0f,  -1.5f,  0.125f), new Vector2f((float) 24 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -1.5f,  0.125f), new Vector2f((float) 28 / 64,(float) 52 / 64)),
			new Vertex(new Vector3f(0.25f, -1.5f, -0.125f), new Vector2f((float) 28 / 64,(float) 48 / 64)),
	};
	
	public static int[] playerIndices = new int[] {
			//Head
			
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
			23, 21, 22,
			
			//Body
			
			//Back face
			24, 25, 27,
			27, 25, 26,
			
			//Front face
			28, 29, 31,
			31, 29, 30,
			
			//Right face
			32, 33, 35,
			35, 33, 34,
			
			//Left face
			36, 37, 39,
			39, 37, 38,
			
			//Top face
			40, 41, 43,
			43, 41, 42,
			
			//Bottom face
			44, 45, 47,
			47, 45, 46,
			
			//Right Arm
			
			//Back face
			48, 49, 51,
			51, 49, 50,
			
			//Front face
			52, 53, 55,
			55, 53, 54,
			
			//Right face
			56, 57, 59,
			59, 57, 58,
			
			//Left face
			60, 61, 63,
			63, 61, 62,
			
			//Top face
			64, 65, 67,
			67, 65, 66,
			
			//Bottom face
			68, 69, 71,
			71, 69, 70,
			
			//Left Arm
			
			//Back face
			72, 73, 75,
			75, 73, 74,
			
			//Front face
			76, 77, 79,
			79, 77, 78,
			
			//Right face
			80, 81, 83,
			83, 81, 82,
			
			//Left face
			84, 85, 87,
			87, 85, 86,
			
			//Top face
			88, 89, 91,
			91, 89, 90,
			
			//Bottom face
			92, 93, 95,
			95, 93, 94,
			
			//Right Leg
			
			//Back face
			96, 97, 99,
			99, 97, 98,
			
			//Front face
			100, 101, 103,
			103, 101, 102,
			
			//Right face
			104, 105, 107,
			107, 105, 106,
			
			//Left face
			108, 109, 111,
			111, 109, 110,
			
			//Top face
			112, 113, 115,
			115, 113, 114,
			
			//Bottom face
			116, 117, 119,
			119, 117, 118,
			
			//Right Leg
			
			//Back face
			120, 121, 123,
			123, 121, 122,
			
			//Front face
			124, 125, 127,
			127, 125, 126,
			
			//Right face
			128, 129, 131,
			131, 129, 130,
			
			//Left face
			132, 133, 135,
			135, 133, 134,
			
			//Top face
			136, 137, 139,
			139, 137, 138,
			
			//Bottom face
			140, 141, 143,
			143, 141, 142,
	};
	
	public static Material skin = new Material("/textures/NinjolasNJM.png");
	
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
