import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Ejercicio_02App {
	
	/*Crea una aplicaci�n que gestione el flujo de ventas de una
	caja de supermercado. El programa guardara la cantidades del
	carrito de compra dentro de una lista. Mostrar� por pantalla la
	siguiente informacion:
	IVA aplicado (21% o 4%)
	precio total bruto y precio mas IVA.
	Numero de art�culos comprados.
	Cantidad pagada.
	Cambio a devolver al cliente.	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int registarVenta;
		ArrayList<ArrayList> ventas = new ArrayList<ArrayList>();
		
		do {	
			
			registarVenta = JOptionPane.showConfirmDialog(null, "Tiene algun producto para registar?", "Seleccione una opción:" ,JOptionPane.YES_NO_OPTION);
			
			if(registarVenta == 0) {
				
				String iva = JOptionPane.showInputDialog("Ingrese el IVA: (Ejemplo: 0.21)"); 
				Double ivaDouble = Double.parseDouble(iva);
				
				String precioBruto = JOptionPane.showInputDialog("Ingrese el precio en bruto:"); 
				Double precioBrutoDouble = Double.parseDouble(precioBruto);
				
				String numArticulos = JOptionPane.showInputDialog("Ingrese el nº de articulos:"); 
				Double numArticulosDouble = Double.parseDouble(numArticulos);
				
				String cantidadPagada = JOptionPane.showInputDialog("Ingrese la cantidad pagada:"); 
				Double cantidadPagadaDouble = Double.parseDouble(cantidadPagada);
								
				introducirVenta(ventas, ivaDouble, precioBrutoDouble, numArticulosDouble, cantidadPagadaDouble);
				
			}
			
		} while (registarVenta == 0);		
		
		mostrarVentas(ventas);
				
	}
	
	public static ArrayList<ArrayList> introducirVenta(ArrayList<ArrayList> ventas, Double iva, Double precioBruto, Double numArticulos, Double cantidadPagada){
		
		ArrayList<Double> venta = new ArrayList<Double>();
		
		venta.add(iva);
		venta.add(precioBruto);
		venta.add(numArticulos);
		venta.add(cantidadPagada);
		
		ventas.add(venta);
		
		return ventas;
		
	}
	
	public static void mostrarVentas(ArrayList<ArrayList> ventas) {
		
		for (int i = 0; i < ventas.size(); i++) {
			
			//Variable que nos permiten hacer operaciones
			Double iva = (Double) ventas.get(i).get(0);
			Double precioBruto = (Double) ventas.get(i).get(1);
			Double articulosComprados = (Double) ventas.get(i).get(2);
			Double cantidadPagada = (Double) ventas.get(i).get(3);
			
			System.out.println("IVA aplicado: " + iva);
			System.out.println("Precio total bruto: " + precioBruto);
			System.out.println("Precio mas IVA: " + ((iva * precioBruto) + precioBruto));
			System.out.println("Numero de articulos comprados: " + articulosComprados);
			System.out.println("Cantidad pagada: " + cantidadPagada);
			System.out.println("Cambio a devolver al cliente: " + (cantidadPagada - ((iva * precioBruto) + precioBruto)));
			System.out.println("");
		}
		
	}

}
