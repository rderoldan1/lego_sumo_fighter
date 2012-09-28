package pricipal;

import lejos.nxt.*;

public class Mover {
	/** Motor atras */
	NXTRegulatedMotor MotorA = Motor.A;
	/** Motor izquierda */
    NXTRegulatedMotor MotorB = Motor.B;
    /** Motor derecha */
    NXTRegulatedMotor MotorC = Motor.C;
    
    /**
     * Clase que contiene todos los metodos para mover al santo
     */
    public Mover(){
    	
    }
    
    /**
     * Mover el santo hacia adelante
     * @param speed, Velocidad con la que se va a mover el santo
     */
	void adelante(int speed){
		MotorA.setSpeed(speed);
		MotorB.setSpeed(speed);
		MotorC.setSpeed(speed);
		
		MotorA.backward();
		MotorB.forward();
		MotorC.forward();
	}
	
	/*
	 * Mover el santo hacia atras
	 */
	void atras(){
		MotorA.stop();
		MotorB.setSpeed(700);
		MotorC.setSpeed(700);
		
		MotorB.backward();
		MotorC.backward();
	}
	
	/**
	 * Mover el santo hacia la derecha
	 */
	void derecha(int speed, int grados){
		MotorA.stop();
		MotorB.setSpeed(speed);
		MotorC.setSpeed(speed);
		
		MotorC.rotate(grados,true);
		MotorB.rotate(-grados);
	}	
	
	/**
	 * Mover el santo hacia la izquierda
	 */
	void izquierda(int speed, int grados){
		MotorA.stop();
		MotorB.setSpeed(speed);
		MotorC.setSpeed(speed);

		MotorB.rotate(grados,true);
		MotorC.rotate(-grados);
	}
}










