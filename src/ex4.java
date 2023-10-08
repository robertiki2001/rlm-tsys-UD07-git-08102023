import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> stockProductosTienda = new HashMap<>();
        Map<String, Integer> cantidadProductos = new HashMap<>();
        Map<String, Integer> carrito = new HashMap<>();

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

        double ivaPorcentaje = 0.21;
        double totalCompra = 0;
        int cantidadArticulos = 0;

        while (true) 
        {
            System.out.println("=========SUPERMERCADO=========");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Mostrar contenido del carrito");
            System.out.println("3. Calcular el total de la compra");
            System.out.println("4. Consultar stock de un producto");
            System.out.println("5. Consultar stock de la tienda");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) 
            {
                case 1:
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombreProducto = sc.nextLine();
                    System.out.print("Ingresa la cantidad de unidades: ");
                    int cantidad = sc.nextInt();
                    agregarAlCarrito(stockProductosTienda, cantidadProductos, carrito, nombreProducto, cantidad);
                    break;
                case 2:
                    mostrarCarrito(carrito, stockProductosTienda);
                    break;
                case 3:
                    totalCompra = calcularTotalCompra(carrito, stockProductosTienda, ivaPorcentaje);
                    System.out.println("Total de la compra (sin IVA): " + totalCompra);
                    System.out.println("IVA aplicado (" + (ivaPorcentaje * 100) + "%): " + (totalCompra * ivaPorcentaje) + "€");
                    System.out.println("Precio total bruto (con IVA): " + (totalCompra + (totalCompra * ivaPorcentaje)) + "€");
                    System.out.println("Número de artículos comprados: " + cantidadArticulos);

                    System.out.print("Ingresa la cantidad a pagar: €");
                    double cantidadPagada = sc.nextDouble();

                    if (cantidadPagada < totalCompra)
                    {
                        System.out.println("La cantidad pagada es insuficiente. Por favor, ingresa una cantidad válida.");
                    } 
                    else 
                    {
                        double cambio = cantidadPagada - totalCompra;
                        System.out.println("Cambio a devolver al cliente: " + cambio + " €");
                    }
                    break;
                case 4:
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombreProd = sc.nextLine();
                    consultarStockProducto(stockProductosTienda, cantidadProductos, nombreProd);
                    break;
                case 5:
                    consultarStockTienda(stockProductosTienda, cantidadProductos);
                    break;
                case 6:
                    System.out.println("Gracias por su compra.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    public static void agregarAlCarrito(Map<String, Double> stockProductosTienda, Map<String, Integer> cantidadProductos,
            Map<String, Integer> carrito, String nombre, int cantidad)
    {
        if (stockProductosTienda.containsKey(nombre) && cantidadProductos.containsKey(nombre)) 
        {
            if (cantidad <= cantidadProductos.get(nombre))
            {
                cantidadProductos.put(nombre, cantidadProductos.get(nombre) - cantidad);
                carrito.put(nombre, carrito.getOrDefault(nombre, 0) + cantidad);
            } 
            else
            {
                System.out.println("No hay suficiente stock disponible.");
            }
        } 
        else
        {
            System.out.println("El producto no existe en la tienda.");
        }
    }

    public static void mostrarCarrito(Map<String, Integer> carrito, Map<String, Double> stockProductosTienda) 
    {
        System.out.println("Contenido del carrito:");
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) 
        {
            String nombre = entry.getKey();
            int cantidad = entry.getValue();
            double precioUnitario = stockProductosTienda.get(nombre);
            System.out.println("Producto: " + nombre + ", Cantidad en Carrito: " + cantidad + ", Precio Unitario: "
                    + precioUnitario + "€");
        }
    }

    public static double calcularTotalCompra(Map<String, Integer> carrito, Map<String, Double> stockProductosTienda,
            double ivaPorcentaje)
    {
        double total = 0;
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) 
        {
            String nombre = entry.getKey();
            int cantidadEnCarrito = entry.getValue();
            double precioUnitario = stockProductosTienda.get(nombre);
            total += cantidadEnCarrito * precioUnitario;
        }
        return total;
    }

    public static void consultarStockProducto(Map<String, Double> stockProductosTienda,
            Map<String, Integer> cantidadProductos, String nombre) 
    {
        if (stockProductosTienda.containsKey(nombre) && cantidadProductos.containsKey(nombre))
        {
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Precio del producto: " + stockProductosTienda.get(nombre) + "€");
            System.out.println("Stock disponible: " + cantidadProductos.get(nombre));
        }
        else 
        {
            System.out.println("El producto no existe en la tienda.");
        }
    }

    public static void consultarStockTienda(Map<String, Double> stockProductosTienda,
            Map<String, Integer> cantidadProductos) 
    {
        System.out.println("Stock total de la tienda:");
        for (Map.Entry<String, Double> entry : stockProductosTienda.entrySet())
        {
            String nombre = entry.getKey();
            double precio = entry.getValue();
            int cantidad = cantidadProductos.get(nombre);
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Precio del producto: " + precio + "€");
            System.out.println("Cantidad de unidades: " + cantidad);
            System.out.println("------");
        }
    }
}
