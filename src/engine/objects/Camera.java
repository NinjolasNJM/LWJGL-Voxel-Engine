package engine.objects;

import org.lwjgl.glfw.GLFW;

import engine.io.Input;
import engine.maths.Vector3f;

public class Camera {
	private Vector3f position, rotation;
	private float moveSpeed = 0.2f, mouseSensitivity = 0.1f, distance = 2.0f, horizontalAngle = 0, verticalAngle = 0;
	
	public Camera(Vector3f position, Vector3f rotation) {
		this.position = position;
		this.rotation = rotation;
	}
	
	public void update() {
		float dx = Input.getMouseDX();
		float dy = Input.getMouseDY();
		
		float x = (float) Math.sin(Math.toRadians(rotation.getY())) * moveSpeed;
		float z = (float) Math.cos(Math.toRadians(rotation.getY())) * moveSpeed;
		
		if (Input.isKeyDown(GLFW.GLFW_KEY_A)) position = Vector3f.add(position,  new Vector3f(-z, 0, x));
		if (Input.isKeyDown(GLFW.GLFW_KEY_D)) position = Vector3f.add(position,  new Vector3f(z, 0, -x));
		if (Input.isKeyDown(GLFW.GLFW_KEY_W)) position = Vector3f.add(position,  new Vector3f(-x, 0, -z));
		if (Input.isKeyDown(GLFW.GLFW_KEY_S)) position = Vector3f.add(position,  new Vector3f(x, 0, z));
		if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE)) position = Vector3f.add(position,  new Vector3f(0, moveSpeed, 0));
		if (Input.isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT)) position = Vector3f.add(position,  new Vector3f(0, -moveSpeed, 0));
		
		rotation = Vector3f.add(rotation, new Vector3f(dy * mouseSensitivity, dx * mouseSensitivity, 0));
	}
	
	public void update(GameObject object) {
		float dx = Input.getMouseDX();
		float dy = Input.getMouseDY();
		float ds = Input.getScrollDY();
		
		verticalAngle -= dy * mouseSensitivity;
		horizontalAngle += dx * mouseSensitivity;
	
		if (distance >= 0) {
			distance += ds * mouseSensitivity;
		} else {
			distance = 0.0f;
		}
		
		float horizontalDistance = (float) (distance * Math.cos(Math.toRadians(verticalAngle)));
		float verticalDistance = (float) (distance * Math.sin(Math.toRadians(verticalAngle)));
		
		float xOffset = (float) (horizontalDistance * Math.sin(Math.toRadians(-horizontalAngle)));
		float zOffset = (float) (horizontalDistance * Math.cos(Math.toRadians(-horizontalAngle)));
		
		position.set(object.getPosition().getX() + xOffset, object.getPosition().getY() - verticalDistance, object.getPosition().getZ() + zOffset);
		
		rotation.set(verticalAngle, -horizontalAngle, 0);
	}

	public Vector3f getPosition() {
		return position;
	}

	public Vector3f getRotation() {
		return rotation;
	}
	
	
}
