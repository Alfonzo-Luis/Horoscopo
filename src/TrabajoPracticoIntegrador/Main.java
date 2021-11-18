package TrabajoPracticoIntegrador;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        generarPrediccion();

    }


    /*-------------------------------------FUNCIONES-------------------------------------*/

    private static void generarPrediccion() {

        Scanner letra = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        System.out.println("\t\t\t*** Bienvenido al templo del Maestro Syntax ***\n\n");


        System.out.println("\t/----------* Menú *----------/\n");
        System.out.println("Por favor, seleccione una opción: \n");
        System.out.println("1.- Solicitar una nueva predicción.");
        System.out.println("2.- Leer mi predicción anterior.");
        System.out.println("3.- Salir.");

        System.out.print("Opción elegida: ");
        String opcion = letra.nextLine();
        opcion = controlNumeros(opcion);



        switch (opcion){

            case "1":

           nuevaPrediccion();
                break;

            case "2":
                String serializacion = "";
                leer(serializacion);
                break;

            case"3":
                System.out.println("Gracias! Vuelva prontos.");
                break;

            default:
                System.out.println("Error en ingreso de datos. Reinicie la aplicación");
        }




}

    private static void nuevaPrediccion() {

        Scanner letra = new Scanner(System.in);
        Scanner num = new Scanner(System.in);

        String serializacion = "";
        System.out.print("Ingrese su nombre: ");
        String nombres = letra.nextLine();
        String nombre= controlPalabras(nombres); /*Función que controla que sólo se ingresen caracteres*/
        serializacion = serializacion + nombre;

        System.out.println("\nIngrese su fecha de nacimiento: \n");

        System.out.print("Día: ");
        String dia = num.nextLine();
        dia = controlNumeros(dia);/*Función que controla que sólo se ingresen números*/
        int dias = Integer.parseInt(dia);


        System.out.print("Mes: ");
        String meses = letra.nextLine();
        meses = controlNumeros(meses);
        int mes = Integer.parseInt(meses);

        System.out.print("Año: ");
        String anios = letra.nextLine();
        anios = controlNumeros(anios);
        int anio = Integer.parseInt(anios);
        serializacion = serializacion +"\n"+ dia +"/"+mes + "/" + anio;

        /*Impresión de datos con fechas en formato español*/
        LocalDate nacimiento = LocalDate.of(anio, mes, dias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedLocalDate = nacimiento.format(formatter);

        System.out.println("\n¡Gracias por visitarnos "+nombre+"!");
        System.out.println("Viniste al mundo el: "+formattedLocalDate);

        /*Lista que contiene todos los signos*/
        List<Signo> signos = new ArrayList<Signo>();
        signos.add(new Signo(LocalDate.of (0, 3, 21), LocalDate.of(0, 4, 20), "Aries"));
        signos.add(new Signo(LocalDate.of (0, 4, 21), LocalDate.of(0, 5, 21), "Tauro"));
        signos.add(new Signo(LocalDate.of (0, 5, 22), LocalDate.of(0, 6, 21), "Géminis"));
        signos.add(new Signo(LocalDate.of (0,6,22), LocalDate.of(0, 7, 23), "Cancer"));
        signos.add( new Signo(LocalDate.of (0, 7, 24), LocalDate.of(0, 8, 23), "Leo"));
        signos.add( new Signo(LocalDate.of (0, 8, 24), LocalDate.of(0, 9, 23), "Virgo"));
        signos.add( new Signo(LocalDate.of (0, 9, 24), LocalDate.of(0, 10, 23), "Libra"));
        signos.add( new Signo(LocalDate.of (0, 10, 24), LocalDate.of(0, 11, 22), "Scorpio"));
        signos.add( new Signo(LocalDate.of (0, 11, 23), LocalDate.of(0, 12, 22), "Sagitario"));
        signos.add( new Signo(LocalDate.of (0, 12, 23), LocalDate.of(0, 1, 20), "Capricornio"));
        signos.add( new Signo(LocalDate.of (0, 1, 21), LocalDate.of(0, 2, 19), "Acuario"));
        signos.add( new Signo(LocalDate.of (0, 2, 20), LocalDate.of(0, 3, 20), "Piscis"));


        /*Encontrar la el signo en las fechas y devolver una frase*/

        for (int i = 0; i < signos.size(); i++)
        {
            if (signos.get(i).obtenerSigno(LocalDate.of(0, mes, dias))) {
                System.out.println("Tu signo es: "+signos.get(i).getNombre());
                serializacion = serializacion +"\n"+"Tu signo es: "+signos.get(i).getNombre();
                Frases frase = new Frases();
                frase.obtenerFrase(LocalDate.of(0,mes ,dias ));
                String prediccion = "El maestro Syntax te dice lo siguiente: " + frase.obtenerFrase(LocalDate.of(0,mes ,dias ));
                System.out.println(prediccion);
                serializacion = serializacion +"\n"+prediccion;
                break;
            }else if(i==11){
                System.out.println("Tu signo es: "+signos.get(i).getNombre());
            }
        }

        escribir(serializacion);
    }

    public static String controlNumeros(String numbers) {

         Scanner numero = new Scanner(System.in);

         while (!Utils.isNumeric(numbers)) {
            System.out.println("Error. Ingrese números.");
            numbers = numero.nextLine();
        }
        return numbers;
    }

    public static String controlPalabras(String palabra) {

        Scanner letras = new Scanner(System.in);

        String palabras = "";

        while (Utils.isNumeric(palabra)) {
            System.out.println("Error. Ingrese sólo caracteres o palabras.");
            palabra = letras.nextLine();
        }
        palabras = palabra;

        return palabras;
    }

    /*-------------------------------------SERIALIZACIÓN-------------------------------------*/

    public static void escribir(String texto){


        try {
            FileWriter escritura = new FileWriter("C:/Users/roma_/desktop/Horoscopo/Destino.txt");
            for (int i = 0; i < texto.length(); i++) {
                escritura.write(texto.charAt(i));

            }
            escritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void leer(String texto){

        try {
            FileReader entrada = new FileReader("C:/Users/roma_/desktop/Horoscopo/Destino.txt");

            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            while (linea != null){

                linea = miBuffer.readLine();
                System.out.println(linea);
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println("No existen predicciones previas. Reinicie la aplicación para una nueva consulta");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
