import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ejercicio_03App {
	
	/*Crea una base de datos de 10 artículos para controlar el
	stock de productos de una tienda por medio de un diccionario
	de datos (articulo:precio). El usuario podr� a�adir, por medio
	de interfaz visual art�culos nuevos y cantidades de estos. El
	usario podr� consultar la información almacenada en el
	diccionario referente a un articulo concreto e incluso listar toda
	la información en la terminal del programa.*/

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
		
		while(true){		
			String[] accion = {"Añadir producto" , "Cambiar precio", "Consultar"};
			Object seleccion = JOptionPane.showInputDialog(null, "Que desea hacer?", "Seleccion",  JOptionPane.DEFAULT_OPTION, null, accion, "0");
			
			switch ((String)seleccion) {
				case "Añadir producto":
					añadirProducto(productos);
					break;
				case "Cambiar precio":
					cambiarPrecio(productos);
					break;
				case "Consultar":
					consultar(productos);
					break;
			}			
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
