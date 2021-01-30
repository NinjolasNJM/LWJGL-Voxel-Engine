package engine.objects;


import engine.graphics.Mesh;
import engine.maths.Vector3f;

public interface GameObject {

	
	/*public GameObject(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;
	} */
	

	public Vector3f getPosition();

	public Vector3f getRotation();

	public Vector3f getScale();

	public Mesh getMesh();
	
	
}
