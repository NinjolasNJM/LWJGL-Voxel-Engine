package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class Input {
	private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
	private static boolean[] oldKeys = new boolean[GLFW.GLFW_KEY_LAST];
	private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
	private static boolean[] oldButtons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
	//private static boolean[] gamepadButtons = new boolean[GLFW.GLFW_GAMEPAD_BUTTON_LAST];
	//private static boolean[] oldGamepadButtons = new boolean[GLFW.GLFW_GAMEPAD_BUTTON_LAST];
	private static double mouseX, mouseY;
	private static double scrollX, scrollY;
	//private static double leftX, leftY;
	// private static double rightX, rightY;
	private static float mouseDX, mouseDY;
	private double oldMouseX, oldMouseY = 0, newMouseX, newMouseY;
	private static float scrollDX, scrollDY;
	private double oldScrollX, oldScrollY = 0, newScrollX, newScrollY;
	
	private GLFWKeyCallback keyboard;
	private GLFWCursorPosCallback mouseMove;
	private GLFWMouseButtonCallback mouseButtons;
	private GLFWScrollCallback mouseScroll;
	
	public Input() {
		keyboard = new GLFWKeyCallback() {
			public void invoke(long window, int key, int scancode, int action, int mods) {
				if(key != 348 && key != -1) {
					keys[key] = (action != GLFW.GLFW_RELEASE);
				}
			}
		};
		
		mouseMove = new GLFWCursorPosCallback() {
			public void invoke(long window, double xpos, double ypos) {
				mouseX = xpos;
				mouseY = ypos;
			}
		};
		
		mouseButtons = new GLFWMouseButtonCallback() {
			public void invoke(long window, int button, int action, int mods) {
				buttons[button] = (action != GLFW.GLFW_RELEASE);
			}
		};
		
		mouseScroll = new GLFWScrollCallback() {
			public void invoke(long window, double offsetx, double offsety) {
				scrollX += offsetx;
				scrollY += offsety;
			}
		};
	}
	
	public void update() {
		for (int i = 0; i < GLFW.GLFW_KEY_LAST; i++) {
			oldKeys[i] = keys[i];
		}
		for (int i = 0; i < GLFW.GLFW_MOUSE_BUTTON_LAST; i++) {
			oldButtons[i] = buttons[i];
		}
		
		oldMouseX = newMouseX;
		oldMouseY = newMouseY;
		
		newMouseX = Input.getMouseX();
		newMouseY = Input.getMouseY();
		
		mouseDX = (float) (oldMouseX - newMouseX);
		mouseDY = (float) (oldMouseY - newMouseY);
		
		oldScrollX = newScrollX;
		oldScrollY = newScrollY;
		
		newScrollX = Input.getScrollX();
		newScrollY = Input.getScrollY();
		
		scrollDX = (float) (oldScrollX - newScrollX);
		scrollDY = (float) (oldScrollY - newScrollY);
	}
	
	public static boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public static boolean isKeyPressed(int key) {
		return keys[key] && !oldKeys[key];
	}
	
	public static boolean isKeyReleased(int key) {
		return !keys[key] && oldKeys[key];
	}
	
	public static boolean isButtonDown(int button) {
		return buttons[button];
	}
	
	public static boolean isButtonPressed(int button) {
		return buttons[button] && !oldButtons[button];
	}
	
	public static boolean isButtonReleased(int button) {
		return !buttons[button] && oldButtons[button];
	}
	
	public void destroy() {
		keyboard.free();
		mouseMove.free();
		mouseButtons.free();
		mouseScroll.free();
	}

	public static double getMouseX() {
		return mouseX;
	}

	public static double getMouseY() {
		return mouseY;
	}
	
	public static double getScrollX() {
		return scrollX;
	}

	public static double getScrollY() {
		return scrollY;
	}
	
	public static float getMouseDX() {
		return mouseDX;
	}

	public static float getMouseDY() {
		return mouseDY;
	}
	
	public static float getScrollDX() {
		return scrollDX;
	}

	public static float getScrollDY() {
		return scrollDY;
	}

	public GLFWKeyCallback getKeyboardCallback() {
		return keyboard;
	}

	public GLFWCursorPosCallback getMouseMoveCallback() {
		return mouseMove;
	}

	public GLFWMouseButtonCallback getMouseButtonsCallback() {
		return mouseButtons;
	}
	
	public GLFWScrollCallback getMouseScrollCallback() {
		return mouseScroll;
	}
}
