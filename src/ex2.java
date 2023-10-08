import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {

    public static void main(String[] args)
{
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> carrito = new ArrayList<>();
        double ivaPorcentaje = 0.21; 
        double precioUnitario, totalCompra = 0;
        int cantidadArticulos = 0;

        while (true) 
        {
            System.out.println("=========SUPERMERCADO=========");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Mostrar contenido del carrito");
            System.out.println("3. Calcular el total de la compra");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) 
            {
                case 1:
                    System.out.print("Ingresa el precio unitario del producto: ");
                    precioUnitario = sc.nextDouble();
                    System.out.print("Ingresa la cantidad de unidades: ");
                    int cantidad = sc.nextInt();
                    carrito.add(precioUnitario * cantidad);
                    cantidadArticulos += cantidad;
                    break;
                case 2:
                    System.out.println("Contenido del carrito:");
                    for (int i = 0; i < carrito.size(); i++) 
                    {
                        System.out.println("Producto " + (i + 1) + ": " + carrito.get(i)+"€");
                    }
                    break;
                case 3:
                    totalCompra = calcularTotalCompra(carrito, ivaPorcentaje);
                    System.out.println("Total de la compra (sin IVA): " + totalCompra);
                    System.out.println("IVA aplicado (" + (ivaPorcentaje * 100) + "%): " + (totalCompra * ivaPorcentaje)+"€");
                    System.out.println("Precio total bruto (con IVA): " + (totalCompra + (totalCompra * ivaPorcentaje))+"€");
                    System.out.println("Número de artículos comprados: " + cantidadArticulos);

                    System.out.print("Cantidad pagada: €");
                    double cantidadPagada = sc.nextDouble();

                    if (cantidadPagada < totalCompra) 
                    {
                        System.out.println("La cantidad pagada es insuficiente. Por favor, ingresa una cantidad válida.");
                    } else
                    {
                        double cambio = cantidadPagada - totalCompra;
                        System.out.println("Cambio a devolver al cliente: " + cambio+" €");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por su compra.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    public static double calcularTotalCompra(ArrayList<Double> carrito, double ivaPorcentaje) 
    {
        double total = 0;
        for (Double subtotal : carrito)
        {
            total += subtotal;
        }
        return total;
    }
}
