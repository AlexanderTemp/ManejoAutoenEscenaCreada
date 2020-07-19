package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class FranjasCarretera {
	private float vertices[] = new float[] {
			 
			 -0.12f,0.52f,44,//0
			 0.12f,0.52f,44,//1
			 0.12f,0.52f,48,//2
			 -0.12f,0.52f,48,//3
			 
			 -0.12f,0.52f,36,//4
			 0.12f,0.52f,36,//5
			 0.12f,0.52f,40,//6
			 -0.12f,0.52f,40,//7
			 
			 -0.12f,0.52f,26,//8
			 0.12f,0.52f,26,//9
			 0.12f,0.52f,30,//10
			 -0.12f,0.52f,30,//11
			 
			 -0.12f,0.52f,16,//12
			 0.12f,0.52f,16,//13
			 0.12f,0.52f,20,//14
			 -0.12f,0.52f,20,//15
			 
			 -0.12f,0.52f,8,//16
			 0.12f,0.52f,8,//17
			 0.12f,0.52f,12,//18
			 -0.12f,0.52f,12,//19
			 
			 
			 -0.12f,1.32f,1,//20
			 0.12f,1.32f,1,//21
			 0.12f,1.32f,5,//22
			 -0.12f,1.32f,5,//23
			 
			 -0.12f,1.32f,-7,//24
			 0.12f,1.32f,-7,//25
			 0.12f,1.32f,-3,//26
			 -0.12f,1.32f,-3,//27
			 
			 -0.12f,0.12f,-17,//28
			 0.12f,0.12f,-17,//29
			 0.12f,0.12f,-12,//30
			 -0.12f,0.12f,-12,//31
			 
			 -0.12f,0.52f,-24,//32
			 0.12f,0.52f,-24,//33
			 0.12f,0.52f,-20,//34
			 -0.12f,0.52f,-20,//35
			 
			 -0.12f,0.52f,-32,//36
			 0.12f,0.52f,-32,//37
			 0.12f,0.52f,-28,//38
			 -0.12f,0.52f,-28,//39
			 
			 -0.12f,0.52f,-40,//40
			 0.12f,0.52f,-40,//41
			 0.12f,0.52f,-36,//42
			 -0.12f,0.52f,-36,//43
			 
			 -0.12f,0.52f,-48,//44
			 0.12f,0.52f,-48,//45
			 0.12f,0.52f,-44,//46
			 -0.12f,0.52f,-44,//47
		};
		
		private short indices[] = new short [] { 
				 0, 1, 2, 0, 2, 3,
				 4, 5, 6, 4, 6, 7,
				 8, 9, 10, 8, 10, 11,
				 12, 13, 14, 12, 14, 15,
				 16, 17, 18, 16, 18, 19,	 
				 20,21,22,20,22,23,
				 24,25,26,24,26,27,
				 28,29,30,28,30,31,
				 32,33,34,32,34,35,
				 36,37,38,36,38,39,
				 40,41,42,40,42,43,
				 44,45,46,44,46,47,
		};
		
		FloatBuffer bufVertices;
		ShortBuffer bufIndices;
		
		public FranjasCarretera(){
			
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
		
		public void dibuja(GL10 gl) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
			gl.glColor4f(1f, 1f, 1f, 1);
			
			/* Dibuja el piso */
			gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
					GL10.GL_UNSIGNED_SHORT, bufIndices);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}
}
