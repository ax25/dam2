package calculos;

public class Hilo extends Thread{
	int array[];
	Compara compara;
	int numeros;
	int parametro;
	Hilo(){
		
	}
	Hilo(int array[], Compara compara, int numeros, int parametro){
		this.array=array;
		this.compara=compara;
		this.numeros=numeros;
		this.parametro=parametro;
	}
	public void run(){
		for(int i=numeros-1;i>(numeros-parametro);i--){
			if(array[i]>compara.mayor){
				compara.setMayor(array[i]);
			}
		}
	}
}
