package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Vehiculo2 {
	private float vertices[]=new float[]{
			-1.5f, 0.3f,3.5f,
			1.5f, 0.3f,3.5f,
			1.5f, 1.6f,3.5f,
			-1.5f, 1.6f,3.5f,
			
			-1.5f, 0.3f,-3.5f,
			1.5f, 0.3f,-3.5f,
			1.5f, 1.6f,-3.5f,
			-1.5f, 1.6f,-3.5f,
			
			-1.5f, 0.3f,-3.5f,
			-1.5f, 0.3f,3.5f,
			-1.5f, 1.6f,3.5f,
			-1.5f, 1.6f,-3.5f,
			
			1.5f, 0.3f,-3.5f,
			1.5f, 0.3f,3.5f,
			1.5f, 1.6f,3.5f,
			1.5f, 1.6f,-3.5f,
			
			///superiorInferior
			-1.5f, 1.6f,3.5f,
			1.5f, 1.6f,3.5f,
			1.5f, 1.6f,-3.5f,
			-1.5f, 1.6f,-3.5f,
			
			/////partesuperior
			
			-1.3f, 1.6f,2.7f,
			1.3f, 1.6f,2.7f,
			1.3f, 2.6f,2.7f,
			-1.3f, 2.6f,2.7f,
			
			-1.3f, 1.6f,-2.7f,
			1.3f, 1.6f,-2.7f,
			1.3f, 2.6f,-2.7f,
			-1.3f, 2.6f,-2.7f,
			
			-1.3f, 1.6f,-2.7f,
			-1.3f, 1.6f,2.7f,
			-1.3f, 2.6f,2.7f,
			-1.3f, 2.6f,-2.7f,
			
			1.3f, 1.6f,-2.7f,
			1.3f, 1.6f,2.7f,
			1.3f, 2.6f,2.7f,
			1.3f, 2.6f,-2.7f,
			
			///superiorSuperior
			-1.3f, 2.6f,2.7f,
			1.3f, 2.6f,2.7f,
			1.3f, 2.6f,-2.7f,
			-1.3f, 2.6f,-2.7f,
			
			//rueda
			-0.2f, 0.1f,0.7f,
			0.2f, 0.1f,0.7f,
			0.2f, 1.2f,0.7f,
			-0.2f, 1.2f,0.7f,
			
			-0.2f, 0.1f,-0.7f,
			0.2f, 0.1f,-0.7f,
			0.2f, 1.2f,-0.7f,
			-0.2f, 1.2f,-0.7f,
			
			-0.2f, 0.1f,-0.7f,
			-0.2f, 0.1f,0.7f,
			-0.2f, 1.2f,0.7f,
			-0.2f, 1.2f,-0.7f,
			
			0.2f, 0.1f,-0.7f,
			0.2f, 0.1f,0.7f,
			0.2f, 1.2f,0.7f,
			0.2f, 1.2f,-0.7f,
			};
			FloatBuffer bufVertices;
			public Vehiculo2(){
				ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
				bufByte.order(ByteOrder.nativeOrder());
				bufVertices = bufByte.asFloatBuffer();
				bufVertices.put(vertices).rewind();
			}
			
			public void dibuja(GL10 gl){
				gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
				gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
				gl.glColor4f(1, 1, 0, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,4,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,8,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,12,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,16,4);
				gl.glColor4f(153/255f, 217/255f, 234/255f, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,20,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,24,4);
				gl.glColor4f(1, 1, 0, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,28,4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,32,4);
				gl.glColor4f(1, 1, 0, 1);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,36,4);
				gl.glColor4f(0, 0, 0, 1);
				gl.glPushMatrix();
				gl.glTranslatef(-1.77f, 0, 2.3f);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 40, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 44, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 48, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 52, 4);
				gl.glPopMatrix();
				
				gl.glPushMatrix();
				gl.glTranslatef(1.77f, 0, 2.3f);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 40, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 44, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 48, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 52, 4);
				gl.glPopMatrix();
				
				gl.glPushMatrix();
				gl.glTranslatef(1.77f, 0, -2.3f);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 40, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 44, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 48, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 52, 4);
				gl.glPopMatrix();
				
				gl.glPushMatrix();
				gl.glTranslatef(-1.77f, 0, -2.3f);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 40, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 44, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 48, 4);
				gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 52, 4);
				gl.glPopMatrix();
				gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			}
}
