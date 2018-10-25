package trivago.model;

public class Estadistica {
    private double[] x;
    private int n;
    public Estadistica(double[] datos) {
        x=datos;
        n=datos.length;
    }
    public double valorMedio(){
   	    double suma=0;
	    for(int i=0; i<n; i++){
		    suma+=x[i];
        }
	    return suma/n;
    }
    public double desviacionMedia(){
 	    double suma=0;
	    double media=valorMedio();
	    for(int i=0; i<n; i++){
		    suma+=Math.abs(x[i]-media);
        }
	    return suma/n;
    }
    public double desviacionCuadratica(){
  	    double suma=0;
	    double media=valorMedio();
	    for(int i=0; i<n; i++){
		    suma+=(x[i]-media)*(x[i]-media);
        }
	    return Math.sqrt(suma/n);
    }
    public String toString(){
        String texto="";
        for(int i=0; i<n; i++){
            texto+="\t"+x[i];
        }
        texto+="\n";
        return texto;
    }

    
}
