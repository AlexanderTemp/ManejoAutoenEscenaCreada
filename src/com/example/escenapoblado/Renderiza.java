package com.example.escenapoblado;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.view.MotionEvent;
import android.widget.Toast;

public class Renderiza extends GLSurfaceView implements Renderer{
	private Flecha flechaDer;
	/* Variable del acelerómetro */
	public float acelerometroX = 0;
	public float acelerometroY=0;
	int alto, ancho;
	private CasaPersonal casa;
	private CasaPersonal2 casa1;
	private CasaPersonal3 casa2;
	private Esfera esf1, esf2, esf3, esf4, esf5;
	private CasaPersonal4 casa3;
	private float trazoHorizontal;
	private float trazoVertical;
	private float antX;
	private float antY;
	private Cesped cesped, cesped1, cesped2, cesped3, cesped4, cesped5;
	private Carretera carretera;
	private Rio rio;
	private FranjasCarretera franjas;
	private Arbusto arbusto;
	private Arbol arbol;
	private Montania monta;
	private RioDeMontania riomon;
	private Vehiculo auto;
	private Vehiculo2 auto1;
	private Vehiculo3 auto2;
	private float movimientoAdelante;
	private boolean sw, bandera;
	private float volante;
	/* Para la rotación */
	private float rotY;
	
	public Renderiza(Context contexto) {
		super(contexto);
		/* Se inicia el renderizado */
		this.setRenderer(this);
		/* La ventana solicita recibir una entrada */
		this.requestFocus();
		/* Se establece que la ventana detecte el modo táctil */
		this.setFocusableInTouchMode(true);
		/* Se renderizará al inicio o cuando se llame a requestRender() */
		this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		// TODO Auto-generated method stub
		flechaDer=new Flecha();
		casa=new CasaPersonal();
		casa1=new CasaPersonal2();
		casa2=new CasaPersonal3();
		casa3=new CasaPersonal4();
		antY=0;
		movimientoAdelante = 0;
		cesped=new Cesped();
		cesped1=new Cesped();
		cesped2=new Cesped();
		cesped3=new Cesped();
		cesped4=new Cesped();
		cesped5=new Cesped();
		carretera=new Carretera();
		rio=new Rio();
		franjas=new FranjasCarretera();
		arbusto=new Arbusto();
		esf1= new Esfera(5, 20, 20);
		esf2= new Esfera(2, 15, 15);
		esf3= new Esfera(2, 15, 15);
		esf4= new Esfera(6, 10, 10);
		esf5= new Esfera(1, 10, 10);
		arbol=new Arbol();
		monta=new Montania();
		sw=false; 
		volante = 0;
		bandera=false;
		riomon=new RioDeMontania();
		auto=new Vehiculo();
		auto1=new Vehiculo2();
		auto2=new Vehiculo3();
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(1, 1, 1, 0);
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		//vista inicial de la cámara
		//gl.glTranslatef(0, -1.5f,-70);
		
		//movimiento=movimiento + 0.005f;
		gl.glScalef(0.4f, 0.4f, 0.4f);
		//gl.glRotatef(1, 0.0f, 0.0f, 0.0f);
		// Para la animación
		//gl.glRotatef(rotY, 0.0f, 1.0f, 0.0f);
		//gl.glRotatef(0.90f, 1.0f, 0.0f, 0.0f);
		//gl.glPushMatrix();
		
		//gl.glLoadIdentity();
		if(acelerometroY>1){antY=antY+=0.70;
		if(antY>60)antY=60;
		gl.glRotatef(antY, 0.0f, 1f, 0.0f);
		}else if (acelerometroY<-1){ antY-=0.70;
		if(antY<-60)antY=-60;
		gl.glRotatef(antY, 0.0f, 1f, 0.0f);
		}
		else gl.glRotatef(antY, 0, 1, 0);
		gl.glTranslatef(0, -2.4f, -95);
		//gl.glPushMatrix();
		//flechaDer.dibuja(gl);
		if(bandera){
			if(sw)
				movimientoAdelante=movimientoAdelante+0.075f;
			else
				movimientoAdelante=movimientoAdelante-0.075f;
			gl.glTranslatef(0,0,movimientoAdelante);
		}
		
		
		if(acelerometroY>0){
			volante = volante - 0.075f;
			gl.glTranslatef(volante, 0, 0);
		}else if (acelerometroY<0){
			volante = volante +  0.075f;
			gl.glTranslatef(volante, 0, 0);
		}
		
		
		//gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);

		gl.glPushMatrix();
		gl.glTranslatef(0,-0.2f,0);
		cesped.dibuja(gl);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		rio.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(0, -0.2f, 100);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		cesped1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(100, -0.2f, 100);
		cesped2.dibuja(gl);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(100, -0.2f, 0);
		cesped3.dibuja(gl);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-100, -0.2f, 100);
		cesped4.dibuja(gl);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-100, -0.2f, 0);
		cesped5.dibuja(gl);
		carretera.dibuja(gl);
		franjas.dibuja(gl);
		gl.glPopMatrix();
		// Casas
		//casa.dibuja(gl);
		gl.glPushMatrix();
		gl.glTranslatef(-34, 0, 26);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-14, 0, 30);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-25, 0, 12);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-42, 0, 22);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-8, 0, 44);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-28, 0, 39);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-15, 0, 27);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-17, 0, 16);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-20, 0, 35);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-42, 0, 36);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		////fin primer cuadrante
		
		gl.glPushMatrix();
		gl.glTranslatef(44, 0, 40);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(28, 0, 21);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(14, 0, 20);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(39, 0, 32);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(22, 0, 24);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(23, 0, 41);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(22, 0, 26);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(33, 0, 39);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(11, 0, 37);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(16, 0, 11);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		
		///fin otrocuadrante
		gl.glPushMatrix();
		gl.glTranslatef(12, 0, -35);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(29, 0, -19);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(34, 0, -42);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(40, 0, -28);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(12, 0, -42);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(33, 0, -34);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(16, 0, -38);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(13, 0, -49);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(15, 0, -24);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(32, 0, -24);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		///////fin de otro cuadrante
		
		gl.glPushMatrix();
		gl.glTranslatef(-38, 0, -47);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-27, 0, -38);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-44, 0, -24);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-16, 0, -40);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-39, 0, -19);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-22, 0, -29);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-13, 0, -33);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-41, 0, -41);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-17, 0, -39);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-38, 0, -46);
		arbusto.dibuja(gl);
		gl.glPopMatrix();
		
		///fin cuadrante negativo
		///cadrante de arboles
		///z=-15,- 50  x=-7 -50
		for (int i = -15; i > -50; i-=8) {
			for (int j = -7; j > -50; j-=8) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				arbol.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPushMatrix();
		gl.glTranslatef(-40, 0, 40);
		monta.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-32, 0, 39);
		monta.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(-24, 0, 38);
		monta.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		riomon.dibuja(gl);
		gl.glPopMatrix();
		/////auto punto vista
		
		gl.glPushMatrix();
		gl.glTranslatef(1.5f, 0.1f, 0);
		auto.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-1.5f, 0.1f, 35);
		auto1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-1.2f, 0.1f, -30);
		auto2.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(20, 0, 25);
		casa.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(20, 0, 40);
		casa1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(40, 0, 25);
		casa2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(40, 0, 40);
		casa3.dibuja(gl);
		gl.glPopMatrix();
		
		for (int i = -15; i > -50; i-=8) {
			for (int j = 7; j < 50; j+=8) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				arbol.dibuja(gl);
				gl.glPopMatrix();
			}
		}
	/////////////////////////////////////////////	
		gl.glPushMatrix();
		gl.glTranslatef(75,6,75);
		gl.glColor4f( 0f, 0f, 0f, 1 );
		esf1.dibuja(gl);
		gl.glPushMatrix();
		gl.glRotatef( 360.0f*24/24.0f, 0.0f, 1.0f, 0.0f );
		// Tercero, se dibuja la tierra como una esfera en base a lineas.
		gl.glColor4f( 0.2f, 0.2f, 1.0f, 1 );
		esf5.dibuja(gl);
		gl.glPopMatrix();
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(75,6,-75);
		gl.glColor4f( 0.4f, 0.2f, 0.8f, 1 );
		esf2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-75,6,0);
		gl.glColor4f( 0.6f, 0.15f, 0.334f, 1 );
		esf3.dibuja(gl);
		gl.glPopMatrix();
		
		

		gl.glPushMatrix();
		gl.glTranslatef(-140, 0, 125);
		casa2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-100, 0, 0);
		for (int i = -15; i > -50; i-=8) {
			for (int j = 7; j < 50; j+=8) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				arbol.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, 100);
		for (int i = -15; i > -50; i-=8) {
			for (int j = 7; j < 50; j+=8) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				arbol.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(100, 0, 0);
		for (int i = -15; i > -50; i-=8) {
			for (int j = 7; j < 50; j+=8) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				arbol.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-100, 0, 100);
		for (int i = -15; i > -50; i-=15) {
			for (int j = 7; j < 50; j+=15) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				casa.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(-100, 0, 0);
		for (int i = 15; i > 50; i+=15) {
			for (int j=-7; j < 50; j-=15) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				casa1.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();
		
		
		
		gl.glPushMatrix();
		gl.glTranslatef(-60, 0, 75);
		for (int i = -15; i > 50; i-=15) {
			for (int j = 7; j < 50; j+=15) {
				gl.glPushMatrix();
				gl.glTranslatef(j, 0, i);
				casa1.dibuja(gl);
				gl.glPopMatrix();
			}
		}
		gl.glPopMatrix();
		
		
		gl.glFlush();
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		// TODO Auto-generated method stub
		ancho=w;
		alto=h;
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		//60
		GLU.gluPerspective(gl, 20f, (float)w / h, 0.05f, 100f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	
	/**
	 * Maneja los eventos del movimiento en la pantalla táctil.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		//se obtiene las posiciones físicas del celular
		float x=e.getX(), y=e.getY();
		float posx, posy;
		float medio = (float)ancho/2;
		////todas las accciones se hacen con action
//		if (e.getAction() == MotionEvent.ACTION_MOVE) {
//			if(antX == -1) {
//				antX = posx;
//			} else {							
//				rotY = rotY + (posx - antX) / 10;
//				antX = posx;
//			}
//			
//			requestRender();
//		}
		if(e.getAction()==MotionEvent.ACTION_MOVE){
			bandera=true;
			//posx=(x*8/(float)ancho)-4;
			//posy=(12-y*12/(float)alto)-6;
			if(x>medio)
				sw=true;
			else if (x<medio) 
				sw=false;
		}
		requestRender();
		return true;
	}


}
