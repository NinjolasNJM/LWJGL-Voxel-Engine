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
					{6, 7, 8, 9}
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
				{10}
			}
	};
	
	public static int[][][] shape = {
			{
				{6, 6, 6, 6, 6, 6, 6, 6},
				{6, 5, 5, 6, 6, 5, 5, 6},
				{6, 5, 5, 6, 6, 5, 5, 6},
				{6, 5, 5, 5, 5, 5, 5, 6},
				{6, 2, 2, 5, 5, 2, 2, 6},
				{6, 5, 5, 5, 5, 5, 5, 6},
				{6, 4, 5, 5, 5, 5, 4, 6},
				{6, 4, 2, 2, 2, 2, 4, 6}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			}, {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
			},
			
	};
			
	public BlockGrid chunk = new BlockGrid(atlas);
	public BlockGrid chunk1 = new BlockGrid(atlas1);
	
	public BlockGrid active = chunk;
	
	public Vector2f w = new Vector2f(64.0f, 0.0f);
	public Mesh wood = new Mesh(Block.blockVertices(w, w, w, w, w, w), Block.blockIndices, Block.terrain);
	public GameObject grid1;
	
	//public GameObject steve = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), new Mesh(player));
	
	public Camera camera = new Camera(new Vector3f(0, 0, 1), new Vector3f(0, 0, 0));
	
	public void init() {
		window = new Window(WIDTH, HEIGHT, "Game");
		shader = new Shader("/shaders/mainVertex.glsl", "/shaders/mainFragment.glsl");
		renderer = new Renderer(window, shader);
		window.setBackgroundColor(0.4f, 0.7f, 1.0f);
		window.create();
		active.create();
		grid1Create();
		shader.create();
		
		
	}

	private void grid1Create() {
		BlockGrid active1 = new BlockGrid(shape);
		active1.create();
		//grid1 = new GameObject(new Vector3f(6, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Mesh.blockMesh(active1.getGrid()));
		Mesh woodMesh =  Mesh.blockMesh(active1.getGrid());
		woodMesh.create();
		grid1 = new GameObject(new Vector3f(6, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), woodMesh);
	}

	public void run() {
		init();
		while (!window.shouldClose()) {
			if (Input.isKeyPressed(GLFW.GLFW_KEY_F5)) window.setFullScreen(!window.isFullScreen());
			if (Input.isKeyPressed(GLFW.GLFW_KEY_ESCAPE)) return;
			if (Input.isKeyPressed(GLFW.GLFW_KEY_O)) active.reload(chunk);
			if (Input.isKeyPressed(GLFW.GLFW_KEY_P)) active.reload(chunk1);
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
		renderer.renderObject(grid1, camera);
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