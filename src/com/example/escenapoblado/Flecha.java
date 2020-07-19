package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Flecha {
	private float vertices[] = new float[] {
			-0.5f, 0.5f,+1f,//0
			-0.5f, -0.5f,+1f, //1
			0.5f, 0.4f,1f,//2
			0.5f, -0.4f,1f,//3

			0.5f, 0.8f,1f, //4
			0.5f, -0.8f,1f,//5
			1,0,-0.5f,1f,//6
			 
			 
		};
		
		private short indices[] = new short [] { 
			0,1,2, 1,2,3,
			4,5,6, 
		};
		
		FloatBuffer bufVertices;
		ShortBuffer bufIndices;
		public Flecha(){
			/* Lee los vértices */
			ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
			bufByte.order(ByteOrder.nativeOrder());
			bufVertices = bufByte.asFloatBuffer();
			bufVertices.put(vertices).rewind();

			/* Lee los indices */
			bufByte = ByteBuffer.allocateDirect(indices.length * 2);
			bufByte.order(ByteOrder.nativeOrder());
			bufIndices = bufByte.asShortBuffer();
			bufIndices.put(indices).rewind();
		}
		
		public void dibuja(GL10 gl){
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
			gl.glColor4f(0.5f, 0.5f, 0.5f, 1);
			
			gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,GL10.GL_UNSIGNED_SHORT, bufIndices);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}
}
