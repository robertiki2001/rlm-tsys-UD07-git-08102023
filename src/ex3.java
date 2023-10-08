import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> stockProductosTienda = new HashMap<>();
        Map<String, Integer> cantidadProductos = new HashMap<>();

        stockProductosTienda.put("Cervezas", 0.85);
        stockProductosTienda.put("Pan", 0.50);
        stockProductosTienda.put("Manzanas", 0.20);
        stockProductosTienda.put("Galletas", 2.80);
        stockProductosTienda.put("Huevos", 3.25);
        stockProductosTienda.put("Pollo", 4.5);
        stockProductosTienda.put("Pimientos", 0.60);
        stockProductosTienda.put("Servilletas", 1.5);
        stockProductosTienda.put("Chocolate", 2.40);
        stockProductosTienda.put("Maiz", 1.49);
        
        cantidadProductos.put("Cervezas", 20);
        cantidadProductos.put("Pan", 30);
        cantidadProductos.put("Manzanas", 60);
        cantidadProductos.put("Galletas", 100);
        cantidadProductos.put("Huevos", 75);
        cantidadProductos.put("Pollo", 10);
        cantidadProductos.put("Pimientos", 35);
        cantidadProductos.put("Servilletas", 20);
        cantidadProductos.put("Chocolate", 200);
        cantidadProductos.put("Maiz", 50);

        while (true) 
        {
            System.out.println("=========STOCK DE LA TIENDA=========");
            System.out.println("1. Agregar nuevo artículo:");
            System.out.println("2. Consultar stock de un producto");
            System.out.println("3. Consultar stock de la tienda");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) 
            {
                case 1:
                    System.out.print("Ingresa el nombre del nuevo artículo: ");
                    String articuloNuevo = sc.nextLine();
                    System.out.print("Ingresa el precio del artículo: ");
                    double precioNuevo = sc.nextDouble();
                    System.out.print("Ingresa la cantidad de unidades: ");
                    int cantidadNuevo = sc.nextInt();

                    stockProductosTienda.put(articuloNuevo, precioNuevo);
                    cantidadProductos.put(articuloNuevo, cantidadNuevo);
                    break;
                case 2:
                    System.out.print("Introduce el nombre del producto para ver su stock: ");
                    String articuloExistente = sc.nextLine();
                    if (stockProductosTienda.containsKey(articuloExistente)) 
                    {
                        System.out.println("Nombre del producto: " + articuloExistente);
                        System.out.println("Precio del producto: " + stockProductosTienda.get(articuloExistente) + "€");
                        System.out.println("Cantidad de unidades: " + cantidadProductos.get(articuloExistente));
                    } 
                    else 
                    {
                        System.out.println("El artículo introducido no existe");
                    }
                    break;
                case 3:
                    System.out.println("Stock total de la tienda:");
                    for (String articulo : stockProductosTienda.keySet()) 
                    {
                        System.out.println("Nombre del producto: " + articulo);
                        System.out.println("Precio del producto: " + stockProductosTienda.get(articulo) + "€");
                        System.out.println("Cantidad de unidades: " + cantidadProductos.get(articulo));
                        System.out.println("------");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por las consultas, que tenga un buen día!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
}
