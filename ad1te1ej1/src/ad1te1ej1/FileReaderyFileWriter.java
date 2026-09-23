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
	public static void main(String[] args) throws IOException {
		
		crearFicheroMod();
	
    }

	private static void crearFicheroMod() throws IOException {
		
		// Creamos objetos File de entrada y salida
		File entrada = new File ("." + File.separator + "entrada.txt");
		File salida = new File("." + File.separator + "salida.txt");
		
		// Leemos fichero de entrada caracter por carácter y lo escribimos, modificado o no, en salida.txt
		// Para ello creamos objetos FileReader y FileWriter, para leer y escribir respectivamente,
		// envueltos en un try-catch por si hay problemas al abrir o crear los ficheros
		try {
			
			FileReader fir = new FileReader(entrada);
			FileWriter fiw = new FileWriter(salida);
			
			// Creamos variable int para recoger el carácter leído y char para traducirlo a caracter, 
			// siempre que el int no sea -1 y no se haya llegado al final del fichero
			int i;
			char caracter = 0;
			System.out.println("Se ha creado un fichero que pasa las minúsculas a mayúsculas y oculta los dígitos.");
			
			while ((i=fir.read())!=-1) {
				//Leer el caracter y modificar si procede
				caracter = (char)i;
				if(caracter>=97 && caracter<=122){
					caracter-=32;
				} else if(caracter>=65 && caracter<=90){
					caracter+=32;
				}
				fiw.write(caracter);
			}
			
			fir.close();
			fiw.close();
			
		} catch (IOException e) {
            System.err.println("Error al procesar los ficheros: " + e.getMessage());
        }
		
	}
}