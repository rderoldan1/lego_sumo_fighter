package pricipal;

import lejos.nxt.*;


public class Principal {
	
	 /**
	  * Retorna verdadero si el color es blanco
	  * @param numero, el valor leido por el sensor de color
	  * @return
	  */
	 static boolean blanco(int numero){
		boolean resultado; 
		if (numero > 43){
			resultado = true;
		}else{
			resultado = false;
		}
		return resultado;	
	}
	 
	 static boolean enemigo(int numero){
		 boolean resultado;
		 if (numero < 30){
			 resultado = true;
		 }else {
			 resultado = false;
		 }
		 return resultado;
	 }
	 
	 static void iniciar(){
		 
	 }
	 
	 
	/**
	 * Inicio de la aplicacion 'El Santo'
	 * @param args
	 */
	public static void main(String[] args){
		Mover mover = new Mover();
		mover.derecha(500, 600);
		/** Sensor de distancia */
		UltrasonicSensor distancia = new UltrasonicSensor(SensorPort.S3);
		/** Sensor de luz de la izquierda */
		LightSensor sensor1 = new LightSensor(SensorPort.S1);			
		/** Sensor de luz de la derecha */
		LightSensor sensor2 = new LightSensor(SensorPort.S2);				
		
		while (true){
			/** Si se detecta blanco en el sensor de la izquierda, el santo gira */
			if (blanco(sensor1.getLightValue())){
				mover.derecha(250,300);
			}
			/** Si se detecta blanco en el sensor de la derecha, el santo gira */
			else if(blanco(sensor2.getLightValue())){
				mover.izquierda(250,300);
			}
			/** Si el santo detecta a su enemigo, lo ataca */
			else if (enemigo(distancia.getDistance())){
				mover.adelante(1000);
				/*
				if (!enemigo(distancia.getDistance())){
					mover.atras();
					Delay.msDelay(1000);
				}
				if (blanco(sensor1.getLightValue()) || blanco(sensor2.getLightValue())){
					mover.atras();
				}
				*/
			}
			/** Si el santo no encuentra ningun enemigo, lo busca */
			else{
				mover.derecha(250,90);
				//mover.izquierda(250, 90);
				if (enemigo(distancia.getDistance())){
					mover.adelante(1000);
				}
			}
		}
	}
}
