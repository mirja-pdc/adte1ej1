package ad1te1ej1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Lee entrada.txt carácter a carácter y genere salida.txt aplicando estas transformaciones:
// Las letras se escriben en mayúsculas.
// Cada dígito del 0 al 9 se sustituye por el carácter #.
// El resto de caracteres, incluyendo espacios y saltos de línea, se conservan.

public class FileReaderyFileWriter {
	public static void main(String[] args) {
		
		crearFicheroMod();
	
    }

	private static void crearFicheroMod() {
		
		// Creamos objetos File de entrada y salida
		File entrada = new File ("." + File.separator + "entrada.txt");
		File salida = new File("." + File.separator + "salida.txt");
		
		// Leemos fichero de entrada caracter por carácter y lo escribimos, modificado o no, en salida.txt
		System.out.println("Se creará un fichero que pase las minúsculas a mayúsculas y oculte los dígitos.");
		
		// Para ello creamos objetos FileReader y FileWriter, para leer y escribir respectivamente,
		// envueltos en un try-with-resources POR CORRECCIÓN DE GEMINI por si hay problemas al abrir o crear los ficheros
		// (Mi código original usaba solo try-catch con el catch (IOException e), y además se me había olvidado
		// eliminar el "throws IOException" al declarar crearFicheroMod() y el main().)
		try (FileReader fir = new FileReader(entrada);
			FileWriter fiw = new FileWriter(salida)) {
			
			// Creamos variable int para recoger el carácter leído y char para traducirlo a caracter, 
			// siempre que el int no sea -1 y por tanto no se haya llegado al final del fichero
			int i;
			char caracter;
			
			while ((i=fir.read())!=-1) {
				
				//Leer el caracter y modificar si procede
				caracter = (char) i;
				// OBTENIDO DE GEMINI: Si es una letra, se transforma a mayúscula
                if (Character.isLetter(caracter)) {
                    caracter = Character.toUpperCase(caracter);
                } 
                // OBTENIDO DE GEMINI: Si es un dígito (0-9), se sustituye por #
                else if (Character.isDigit(caracter)) {
                    caracter = '#';
                }
                
                // Escribir el carácter en salida.txt
                fiw.write(caracter);
                
			}
			
			// Ya no hace falta cerrar fir ni fiw porque ahora uso try-with-resources
			// por recomendación de Gemini, así que dejo las líneas comentadas
			// fir.close();
			// fiw.close();
			
		} catch (IOException e) {
            System.err.println("Error al procesar los ficheros: " + e.getMessage());
        }
		
	}
}