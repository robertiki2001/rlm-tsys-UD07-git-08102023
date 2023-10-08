import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ex1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

        ArrayList<Double> notas = new ArrayList<>();

        Map<String, Double> notaMediaPorAlumno = new HashMap<>();

        System.out.print("Introduce la cantidad de alumnos: ");
        int cantidadAlumnos = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= cantidadAlumnos; i++) 
        {
            System.out.print("Nombre del alumno " + i + ": ");
            String nombre = sc.nextLine();

            ArrayList<Double> notasAlumno = new ArrayList<>();
            for (int j = 1; j <= 3; j++) 
            {
                System.out.print("Introduce la nota " + j + " del alumno " + nombre + ": ");
                double nota = sc.nextDouble();
                notasAlumno.add(nota);
            }

            double notaMedia = calcularNotaMedia(notasAlumno);

            notaMediaPorAlumno.put(nombre, notaMedia);

            sc.nextLine();
        }

        double notaMediaCurso = calcularNotaMedia(new ArrayList<>(notaMediaPorAlumno.values()));

        System.out.println("\nNota media de cada alumno:");
        for (Map.Entry<String, Double> entry : notaMediaPorAlumno.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\nNota media del curso: " + notaMediaCurso);
    }


	public static double calcularNotaMedia(ArrayList<Double> notas) 
	{
	    double suma = 0.0;
	    for (double nota : notas) 
	    {
	        suma += nota;
	    }
	    return suma / notas.size();
	}

}
