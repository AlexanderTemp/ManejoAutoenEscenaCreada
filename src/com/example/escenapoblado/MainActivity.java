package com.example.escenapoblado;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {
	private TextView texto1;
	private GLSurfaceView superficie;
    private SensorManager sensorManager;
    public Renderiza renderiza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		renderiza=new Renderiza(this);
		superficie=renderiza;
		
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
		
//		MediaPlayer mediaPlayer=MediaPlayer.create(this, R.raw.ambiente);
//		mediaPlayer.setVolume(0.5f, 0.5f);
//		mediaPlayer.start();
		
		//RelativeLayout pantalla = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
	    //pantalla.addView(superficie);   
//		texto1 = (TextView) pantalla.findViewById(R.id.texto1);
//      texto1.bringToFront();
        
		setContentView(superficie);
    }
    
    public void actualizaTexto(final String s) {
    	runOnUiThread(new Runnable() {
    		@Override
    		public void run() {
    			texto1.setText("Para Atras                      Para Adelante");
    			}
    		});
    	}
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
    	if (e.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			//renderiza.acelerometroX = (float) (e.values[0]*0.9815);
			renderiza.acelerometroY = e.values[1];
		}
		
	}

}
