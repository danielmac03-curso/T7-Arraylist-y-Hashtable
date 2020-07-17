import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ejercicio_01App {
	
	/*Crea una aplicaci�n que calcule la nota media de los
	alumnos pertenecientes al curso de programaci�n. Una vez
	calculada la nota media se guardara esta informaci�n en un
	diccionario de datos que almacene la nota media de cada
	alumno. Todos estos datos se han de proporcionar por
	pantalla.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String numAlumnos = JOptionPane.showInputDialog("Introduce la cantidad de alumnos:");
		int numAlumnosInt = Integer.parseInt(numAlumnos);
		
		String numNotas = JOptionPane.showInputDialog("Introduce la cantidad de notas:");
		double numAlumnosnumNotasDouble = Double.parseDouble(numNotas);
		
		Hashtable<String, Double> notas = rellenarNotas(numAlumnosInt, numAlumnosnumNotasDouble);
		mostarNotas(notas);
						
	}
	
	public static Hashtable<String, Double> rellenarNotas(int numAlumnos, Double numNotas){
		Hashtable<String, Double> resultado = new Hashtable<String, Double>();
		
		for (int i = 0; i < numAlumnos; i++) {
			
			Double notaMedia = 0.0;
			String nombreAlumno = JOptionPane.showInputDialog("Introduce el nombre del alumno");
			
			for (int j = 0; j < numNotas; j++) {
				
				String numNota = JOptionPane.showInputDialog("Introduce la " + (j+1) + "º nota del " + (i+1) + "º alumno");
				Double numNotaDoble = Double.parseDouble(numNota);
				
				notaMedia += numNotaDoble;
				
			}
			
			notaMedia = notaMedia/numNotas;
			
			resultado.put(nombreAlumno, notaMedia);
			
		}
				
		return resultado;
	}
	
	public static void mostarNotas(Hashtable<String, Double> arrayNotas) {
		
		Enumeration<String> EnumerationClave = arrayNotas.keys();
		Enumeration<Double> EnumerationValor = arrayNotas.elements();
		
		while (EnumerationClave.hasMoreElements()){
			System.out.println("El alumno " + EnumerationClave.nextElement() + " tiene una media de " + EnumerationValor.nextElement());
		}
		
	}

}
