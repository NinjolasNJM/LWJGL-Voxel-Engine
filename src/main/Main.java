package main;

import org.lwjgl.glfw.GLFW;

import engine.graphics.*;
import engine.io.*;
import engine.maths.*;
import engine.objects.*;

public class Main implements Runnable{

	public Window window;
	public Renderer renderer;
	public Shader shader;
	public final int WIDTH = 1280, HEIGHT = 760;
	
	public int[][][] atlas = {
				{
					{1, 1, 1, 1},
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 0, 0}
				}, {
					{1, 1, 1, 1},
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 4, 0, 0}
				}, {
					{1, 1, 1, 1},
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 0, 0}
				}, {
					{1, 1, 1, 1},
					{0, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 0, 0}
				},
	};
	public int[][][] atlas1 = {
			{
				{2}
			}
	};

	public BlockGrid chunk = new BlockGrid(4, 4, 4, atlas);
	public BlockGrid chunk1 = new BlockGrid(1, 1, 1, atlas1);
	
	public BlockGrid active = chunk1;
	
	//public GameObject steve = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), new Mesh(player));
	
	public Camera camera = new Camera(new Vector3f(0, 0, 1), new Vector3f(0, 0, 0));
	
	public void init() {
		window = new Window(WIDTH, HEIGHT, "Game");
		shader = new Shader("/shaders/mainVertex.glsl", "/shaders/mainFragment.glsl");
		renderer = new Renderer(window, shader);
		window.setBackgroundColor(0.4f, 0.7f, 1.0f);
		window.create();
		active.create();
		shader.create();
		
		
	}

	public void run() {
		init();
		while (!window.shouldClose()) {
			if (Input.isKeyPressed(GLFW.GLFW_KEY_F5)) window.setFullScreen(!window.isFullScreen());
			if (Input.isKeyPressed(GLFW.GLFW_KEY_ESCAPE)) return;
			if (Input.isKeyPressed(GLFW.GLFW_KEY_O)) active.reload(4, 4, 4, atlas);
			if (Input.isKeyPressed(GLFW.GLFW_KEY_P)) active.reload(1, 1, 1, atlas1);
			if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) window.mouseState(true);
			if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)) window.mouseState(false);
			update();
			render();
			
		}
		close();
		
	}
	
	private void update() {
		window.update();
		camera.update();
	}
	
	private void render() {
		for (int i = 0; i < active.getX(); i++) {
			for (int j = 0; j < active.getY(); j++) {
				for(int k = 0; k < active.getZ(); k++) {
					renderer.renderObject(active.getGrid()[i][j][k], camera);
				}
			}
		}
		//renderer.renderObject(chunk.getGrid(), camera);
		window.swapBuffers();
	}
	
	private void close() {
		window.destroy();
		active.destroy();
		shader.destroy();
	}
	
	public static void main(String[] args) {
		new Main().run();

	}
}