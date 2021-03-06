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
			
	public BlockGrid active = new BlockGrid(shape);
	
	public Player steve = new Player(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), new Mesh(Player.playerVertices, Player.playerIndices, Player.skin));
	
	public Camera camera = new Camera(new Vector3f(0, 0, 1), new Vector3f(0, 0, 0));
	
	public void init() {
		window = new Window(WIDTH, HEIGHT, "Game");
		shader = new Shader("/shaders/mainVertex.glsl", "/shaders/mainFragment.glsl");
		renderer = new Renderer(window, shader);
		window.setBackgroundColor(0.4f, 0.7f, 1.0f);
		window.create();
		active.create();
		steve.getMesh().create();
		shader.create();
		
		
	}

	public void run() {
		init();
		while (!window.shouldClose()) {
			if (Input.isKeyPressed(GLFW.GLFW_KEY_F5)) window.setFullScreen(!window.isFullScreen());
			if (Input.isKeyPressed(GLFW.GLFW_KEY_ESCAPE)) return;
			if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) window.mouseState(true);
			if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)) window.mouseState(false);
			update();
			render();
			
		}
		close();
		
	}
	
	private void update() {
		camera.update();
		window.update();
		//camera.update();
	}
	
	private void render() {
		renderer.renderObject(active, camera);
		renderer.renderObject(steve, camera);
		window.swapBuffers();
	}
	
	private void close() {
		window.destroy();
		active.destroy();
		steve.getMesh().destroy();
		shader.destroy();
	}
	
	public static void main(String[] args) {
		new Main().run();

	}
}