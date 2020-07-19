package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CasaPersonal4 {
	private float vertices[]=new float[]{
			-4.0f, 0.1f,3f,
			4.0f, 0.1f,3f,
			4.0f, 4.5f,3f,
			-4.0f, 4.5f,3f,
			
			-4.0f, 0.1f,-3f,
			4.0f, 0.1f,-3f,
			4.0f, 4.5f,-3f,
			-4.0f, 4.5f,-3f,
			
			-4.0f, 0.1f,-3f,
			-4.0f, 0.1f,3f,
			-4.0f, 4.5f,3f,
			-4.0f, 4.5f,-3f,
			
			4.0f, 0.1f,-3f,
			4.0f, 0.1f,3f,
			4.0f, 4.5f,3f,
			4.0f, 4.5f,-3f,
			
			///superiorInferior
			-4.3f, 4.5f,3f,
			0f, 5.5f,3f,
			0f, 5.5f,-3f,
			-4.3f, 4.5f,-3f,
			
			4.3f, 4.5f,3f,
			0f, 5.5f,3f,
			0f, 5.5f,-3f,
			4.3f, 4.5f,-3f,
			
			////puerta
			
			-1.0f, 0.1f,3.1f,
			1.0f, 0.1f,3.1f,
			1.0f, 3.7f, 3.1f,
			-1.0f, 3.7f,3.1f,
			
			-1.0f, 0.1f,-3.1f,
			1.0f, 0.1f,-3.1f,
			1.0f, 3.7f,-3.1f,
			-1.0f, 3.7f,-3.1f,
			///Ventanas
			-4.1f, 1.5f,-1f,
			-4.1f, 1.5f,1f,
			-4.1f, 3.1f,1f,
			-4.1f, 3.1f,-1f,
			
			4.1f, 1.5f,-1f,
			4.1f, 1.5f,1f,
			4.1f, 3.1f,1f,
			4.1f, 3.1f,-1f,
			
			
			};
			FloatBuffer bufVertices;
			public CasaPersonal4(){
				ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
				bufByte.order(ByteOrder.nativeOrder());
				bufVertices = bufByte.asFloatBuffer();
				bufVertices.put(vertices).rewind();
			}
			
			public void dibuja(GL10 gl){
				gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
				gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
				gl.glColor4f(1, 128/255f, 1, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,4,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,8,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,12,4);
				
				gl.glColor4f(128/255f,64/255f,64/255f,1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,16,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,20,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,24,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,28,4);
				
				
				gl.glColor4f(153/255f, 217/255f, 234/255f, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,32,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,36,4);
				
				
				
				gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			}
}
