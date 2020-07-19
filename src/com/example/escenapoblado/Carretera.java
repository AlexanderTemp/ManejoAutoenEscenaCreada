package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Carretera {
	private float vertices[] = new float[] {
			-6, 0.5f, 10, // 0
			 6, 0.5f, 10, // 1
			 6, 0.5f,  50, // 2
			-6, 0.5f,  50, // 3
			
			-6, 1.2f, 5, // 4
			 6, 1.2f, 5, // 5
			 6, 0.5f, 10, // 6
			 -6, 0.5f, 10, // 7
			
			 
			 -6, 1.2f, -10, // 8
			 6, 1.2f, -10, // 9
			 6, 1.2f, 5, // 10
			 -6, 1.2f, 5, // 11
			 
			 -6, 0.5f, -15, // 12
			 6, 0.5f, -15, // 13
			 6, 1.2f, -10, // 14
			 -6, 1.2f, -10, // 15
			
			 -6, 0.5f, -50, // 16
			 6, 0.5f, -50, // 17
			 6, 0.5f, -15, // 18
			 -6, 0.5f, -15, // 19
			
			
			 
		};
		
		private short indices[] = new short [] { 
			 0, 1, 2, 0, 2, 3,
			 4, 5, 6, 4, 6, 7,
			 8, 9, 10, 8, 10, 11,
			 12, 13, 14, 12, 14, 15,
			 16, 17, 18, 16, 18, 19,	 
		};
		
		FloatBuffer bufVertices;
		ShortBuffer bufIndices;
		public Carretera(){
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
