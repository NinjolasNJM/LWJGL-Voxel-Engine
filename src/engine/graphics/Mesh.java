package engine.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import engine.maths.Vector3f;
import engine.objects.Block;

public class Mesh {
	private Vertex[] vertices;
	private int[] indices;
	private Material material;
	private int vao, pbo, ibo, cbo, tbo;
	
	public Mesh(Vertex[] vertices, int[] indices, Material material) {
		this.vertices = vertices;
		this.indices = indices;
		this.material = material;
	}
	
	public void create() {
		material.create();
		
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		FloatBuffer positionBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
		float[] positionData = new float[vertices.length * 3];
		for (int i = 0; i < vertices.length; i++) {
			positionData[i * 3] = vertices[i].getPosition().getX();
			positionData[i * 3 + 1] = vertices[i].getPosition().getY();
			positionData[i * 3 + 2] = vertices[i].getPosition().getZ();
		}
		positionBuffer.put(positionData).flip();
		
		pbo = storeData(positionBuffer, 0, 3);
		
		FloatBuffer colorBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
		float[] colorData = new float[vertices.length * 3];
		for (int i = 0; i < vertices.length; i++) {
			colorData[i * 3] = vertices[i].getColor().getX();
			colorData[i * 3 + 1] = vertices[i].getColor().getY();
			colorData[i * 3 + 2] = vertices[i].getColor().getZ();
		}
		colorBuffer.put(colorData).flip();
		
		cbo = storeData(colorBuffer, 1, 3);
		
		FloatBuffer textureBuffer = MemoryUtil.memAllocFloat(vertices.length * 2);
		float[] textureData = new float[vertices.length * 2];
		for (int i = 0; i < vertices.length; i++) {
			textureData[i * 2] = vertices[i].getTextureCoord().getX();
			textureData[i * 2 + 1] = vertices[i].getTextureCoord().getY();
		}
		textureBuffer.put(textureData).flip();
		
		tbo = storeData(textureBuffer, 2, 2);
		
		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
		indicesBuffer.put(indices).flip();
		
		ibo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		
	}
	
	private int storeData(FloatBuffer buffer, int index, int size) {
		int bufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, bufferID);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(index, size, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		return bufferID;
	}
	
	public void destroy() {
		GL15.glDeleteBuffers(pbo);
		GL15.glDeleteBuffers(cbo);
		GL15.glDeleteBuffers(ibo);
		GL15.glDeleteBuffers(tbo);
		
		GL30.glDeleteVertexArrays(vao);
		
		material.destroy();
	}
	
	public static Mesh combine(Mesh mesh1, Mesh mesh2) {
		Vertex[] vertices = concatVertices(mesh1.getVertices(), mesh2.getVertices());
		int[] indices = concatIndices(mesh1.getIndices(), mesh2.getIndices());
		Mesh result = new Mesh(vertices, indices, mesh1.getMaterial());
		
		return result;
	}
	
	public static Mesh cuboid(Mesh mesh, Vector3f size) {
		Mesh result = new Mesh(Block.airVertices, Block.blockIndices, Block.terrain);
		
		for(int i = 0; i < size.getX(); i++) {
			for(int j = 0; j < size.getY(); j++) {
				for(int k = 0; k < size.getZ(); k++) {
					result = Mesh.combine(result, Mesh.translate(mesh, new Vector3f((float) i, (float) j, (float) k)));
				}
			}
		}
		
		return result;
	}
	
	public static Mesh blockMesh(HashMap<Vector3f, Block> grid) {
		Mesh result = new Mesh(Block.airVertices, Block.blockIndices, Block.terrain);
		
		for(Vector3f i : grid.keySet()) {
			result = Mesh.combine(result, Mesh.translate(grid.get(i).getMesh(), i));
		}
		return result;
	}
	
	public static Vertex[] concatVertices(Vertex[] vertices1, Vertex[] vertices2) {
		int length = vertices1.length + vertices2.length;
		Vertex[] result = new Vertex[length];
		
		int pos = 0;
	        for (Vertex element : vertices1) {
	            result[pos] = element;
	            pos++;
	        }

	        for (Vertex element : vertices2) {
	            result[pos] = element;
	            pos++;
	        }
		
		return result;
	}
	
	public static int[] concatIndices(int[] indices1, int[] indices2) {
		int length = indices1.length + indices2.length;
		int[] result = new int[length];
		
		int highest = 0;
		int pos = 0;
        for (int element : indices1) {
            result[pos] = element;
            if (element > highest) {
            	highest = element;
            }
            pos++;
        }

        for (int element : indices2) {
            result[pos] = element + highest + 1;
            pos++;
        }
		
		return result;
	}
	
	public static Mesh translate(Mesh mesh, Vector3f pos) {
		return new Mesh(Vertex.translate(mesh.getVertices(), pos), mesh.getIndices(), mesh.getMaterial());
	}

	public Vertex[] getVertices() {
		return vertices;
	}

	public int[] getIndices() {
		return indices;
	}

	public int getVAO() {
		return vao;
	}

	public int getPBO() {
		return pbo;
	}
	
	public int getCBO() {
		return cbo;
	}
	
	public int getTBO() {
		return tbo;
	}

	public int getIBO() {
		return ibo;
	}
	
	public Material getMaterial() {
		return material;
	}
	
}
