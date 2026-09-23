package ad1;

import java.io.File;

/**
 * Prueba con vídeos de File de AD01 en mi Mac
 * Uso File.separator para independencia entre ruta fichero y SO
 */
public class claseFIle {
    public static void main(String[] args) {
    	System.out.println("Información sobre el fichero:");
    	
    	File f = new File(File.separator + "Users" 
        	    + File.separator + "mirja" 
        		+ File.separator + "Documents" 
        	    + File.separator + "DAM" 
        		+ File.separator + "AD" 
        	    + File.separator + "pruebaLectura.txt");
    	
    	if(f.exists()) {
    		System.out.println("Nombre: " + f.getName());
    		System.out.println("Ruta: " + f.getPath());
    		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
    		System.out.println("Se puede leer: " + f.canRead());
    		System.out.println("Se puede escribir: " + f.canWrite());
    		System.out.println("Tamaño: " + f.length());
    		System.out.println("Es un directorio: " + f.isDirectory());
    		System.out.println("Es un fichero: " + f.isFile());
    		System.out.println("Nombre del directorio padre: " + f.getParent());	
    	}
       
    }
}

