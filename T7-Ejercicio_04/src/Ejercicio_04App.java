import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio_04App {
	
	/*Combina los m�todos generados en las actividades 2 y 3
	creando una aplicaci�n que gestione ventas y control de stock en
	una misma interfaz. Utiliza para ello las estructuras de datos que
	creas conveniente.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();
		productos.put("Platano", 5);
		productos.put("Fresa", 8);
		productos.put("Naranja", 20);
		productos.put("Manzana", 13);
		productos.put("Peras", 2);
		productos.put("Cerezas", 4);
		productos.put("Melón", 12);
		productos.put("Sandía", 26);
		productos.put("Arandano", 31);
		productos.put("Uva", 7);
		
		ArrayList<ArrayList> ventas = new ArrayList<ArrayList>();
		
		while(true){		
			String[] accion = {"Añadir producto" , "Cambiar precio", "Consultar producto", "Registar venta", "Mostrar ventas"};
			Object seleccion = JOptionPane.showInputDialog(null, "Que desea hacer?", "Seleccion",  JOptionPane.DEFAULT_OPTION, null, accion, "0");
			
			switch ((String)seleccion) {
				case "Añadir producto":
					añadirProducto(productos);
					break;
				case "Cambiar precio":
					cambiarPrecio(productos);
					break;
				case "Consultar producto":
					consultar(productos);
					break;
				case "Registar venta":
					registarVenta(ventas);
					break;
				case "Mostrar ventas":
					mostrarVentas(ventas);
					break;
			}
		}

	}
	
	public static void registarVenta(ArrayList<ArrayList> ventas) {
		
		ArrayList<ArrayList> venta = new ArrayList<ArrayList>();
						
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
	
	public static Hashtable<String, Integer> añadirProducto(Hashtable<String, Integer> arrayProductos) {
		
		String nombreProducto = JOptionPane.showInputDialog("Indique el nombre del producto");

		String precioProducto = JOptionPane.showInputDialog("Indique el precio del producto");
		int precioProductoInt = Integer.parseInt(precioProducto);
		
		arrayProductos.put(nombreProducto, precioProductoInt);
		
		System.out.println(nombreProducto + " ha sido añadido con un precio de " + precioProductoInt);
		
		return arrayProductos;
	}
	
	public static Hashtable<String, Integer> cambiarPrecio(Hashtable<String, Integer> arrayProductos) {
		
		Enumeration<String> EnumerationClave = arrayProductos.keys();
		String[] accion = new String[arrayProductos.size()];
		int contador = 0;
		
		while (EnumerationClave.hasMoreElements()) {
			accion[contador] = EnumerationClave.nextElement();
			contador++;
		}
		
		Object seleccion = JOptionPane.showInputDialog(null, "Cual desea cambiar?", "Seleccion",  JOptionPane.DEFAULT_OPTION, null, accion, "0");

		String precioProducto = JOptionPane.showInputDialog("Indique el nuevo precio del producto");
		int precioProductoInt = Integer.parseInt(precioProducto);
		
		arrayProductos.put((String) seleccion, precioProductoInt);
		
		System.out.println(seleccion + " ha sido modificado con un precio de " + precioProductoInt);
		
		return arrayProductos;
	}
	
	public static void consultar(Hashtable<String, Integer> arrayProductos) {
		
		int consultarTodos = JOptionPane.showConfirmDialog(null, "Consultar todos los productos?", "Seleccione una opción:" ,JOptionPane.YES_NO_OPTION);
		
		if(consultarTodos == 0) {
			
			Enumeration<String> EnumerationClave = arrayProductos.keys();
			Enumeration<Integer> EnumerationValor = arrayProductos.elements();
			
			while (EnumerationClave.hasMoreElements()){
				System.out.println("El precio de " + EnumerationClave.nextElement() + " es de " + EnumerationValor.nextElement());
			}
		
		}else{
			
			Enumeration<String> EnumerationClave = arrayProductos.keys();
			String[] accion = new String[arrayProductos.size()];
			int contador = 0;
			
			while (EnumerationClave.hasMoreElements()) {
				accion[contador] = EnumerationClave.nextElement();
				contador++;
			}
			
			Object seleccion = JOptionPane.showInputDialog(null, "Que desea hacer?", "Seleccion",  JOptionPane.DEFAULT_OPTION, null, accion, "0");
			
			System.out.println("El precio de " + seleccion + " es de " + arrayProductos.get(seleccion));
			
		}
		
	}

}
