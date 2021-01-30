package engine.graphics;

import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class Vertex {
	private Vector3f position, color, normal;
	private Vector2f textureCoord;
	
	public Vertex(Vector3f position, Vector3f normal, Vector2f textureCoord) {
		this.position = position;
		this.color = new Vector3f(0.0f, 0.0f, 0.0f);
		this.normal = normal;
		this.textureCoord = textureCoord;
	}
	
	public Vertex(Vector3f position, Vector2f textureCoord) {
		this.position = position;
		this.color = new Vector3f(0.0f, 0.0f, 0.0f);
		this.textureCoord = textureCoord;
	}
	
	public static Vertex[] translate(Vertex[] vertices, Vector3f pos) {
		Vertex[] result = new Vertex[vertices.length];
		
		for(int i = 0; i < vertices.length; i++) {
			result[i] = new Vertex(Vector3f.add(vertices[i].getPosition(), pos), vertices[i].getTextureCoord());
		}
		
		return result;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public Vector3f getNormal() {
		return normal;
	}

	public Vector2f getTextureCoord() {
		return textureCoord;
	}
	
}
