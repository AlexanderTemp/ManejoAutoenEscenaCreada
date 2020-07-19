package com.example.escenapoblado;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

public class Arbusto {

	private float vertices[]=new float[]{
			1.2544405f, 0.3234366f, -0.3624301f, 1.3165393f, 0.8878262f, -0.90722626f, 0.91679263f, 1.1865752f, -1.205611f, 1.0731745f, 1.033868f, -1.4742032f, -0.08324647f, 1.1838691f, 0.17870474f, -0.63531965f, 0.6595951f, -0.61821556f, 0.030096292f, 1.0947857f, -0.86559606f, -0.17798495f, 0.0716663f, 1.2010155f, -0.55617374f, 0.92399937f, 0.9286685f, 0.6127844f, 0.09168488f, 0.109867215f, 0.40807843f, 0.025960386f, 0.03511548f, 0.012593508f, 1.3009216f, 0.32972813f, 1.4847162f, 1.4146829f, -1.2953779f, 0.5873544f, 0.8866379f, -0.6151777f, -0.7997573f, 1.0746385f, 0.42324078f, -0.4209993f, 0.6850096f, -0.09004605f, 0.43973517f, 0.7912016f, -1.4825295f, 1.2829604f, 1.0552593f, 0.83109236f, -0.8225836f, 0.8773765f, -0.41258693f, -0.860455f, 0.049338967f, 0.8003688f, -1.472893f, 0.82569313f, -0.37965024f, -0.7237113f, 0.2532616f, 0.70918226f, 0.41964006f, 0.071837515f, 0.57365894f, 0.461218f, 1.4733678f, 1.2774377f, -0.37545812f, 1.4872231f, 1.1155605f, 0.26410627f, 0.07283342f, -0.7006336f, -0.34043264f, 0.806126f, -0.32668018f, -1.2329724f, 0.07204646f, -0.88199115f, -0.5997425f, 1.4476063f, 0.84097385f, 1.2167406f, 0.809699f, 0.66644335f, 0.39109612f, 0.6393492f, 0.9059305f, -0.186939f, 0.50734985f, 0.7869806f, -0.0145715475f, 0.11217329f, -1.4295895f, 0.78259754f, 0.4286668f, 0.96947217f, -1.1607888f, 1.0165551f, -1.2088141f, 1.4218788f, 1.4152323f, -0.9657882f, -0.50285965f, 0.7305989f, -1.2804656f, -0.8093029f, 0.20599455f, 1.025682f, -0.23919976f, 0.57215464f, 0.31579447f, -0.6291951f, 0.97028714f, 1.0676453f, 0.6904404f, 1.3297802f, -0.5093787f, 0.9692099f, 0.49867773f, -0.95969045f, -1.3419287f, 0.9226204f, -1.3557732f, 1.153893f, 0.8946246f, 1.3564107f, -1.0541136f, 0.36007234f, 0.035489917f,
	};

	FloatBuffer bufVertices;
	Random rand=new Random();
	float minx=-0.8f, maxx=0.8f;
	float miny=0f, maxy=0.9f;
	float minz=-0.8f, maxz=0.8f;
	public Arbusto(){
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufVertices = bufByte.asFloatBuffer();
		bufVertices.put(vertices).rewind();

	}

	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glColor4f(0, 128/255f, 64/255f, 1);
		int i=0;
		for (int j = 0; j < 15; j++) {
			gl.glDrawArrays(GL10.GL_TRIANGLES, i, 3);
			i=i+3;
		}
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
