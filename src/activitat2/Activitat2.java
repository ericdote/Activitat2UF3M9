package activitat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Activitat2 {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL url = new URL("http://www.servidor.com/cercar?tipus=compres&inici=2010-03-01&final=2010-03-31");

        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Autoritat: " + url.getAuthority());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Filename: " + url.getFile());
        System.out.println("Ref: " + url.getRef());

        llegirUrl(url);
        part3();
        exercici2(url, "<ul>");
    }
    /**
     * Metodo que le llega una tipo URL i imprime el codigo html tal y como se ve estructurado
     * @param url
     * @throws IOException 
     */
    public static void llegirUrl(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String linea;
        while ((linea = in.readLine()) != null) {
            System.out.println(linea);
        }
    }
    /**
     * Metodo que apartir de una url se conecta y imprime por pantalla la sintaxis del html
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static void part3() throws MalformedURLException, IOException {
        URL url = new URL("http://www.google.com");
        URLConnection conect = url.openConnection();
        conect.setDoOutput(true);
        conect.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(conect.getInputStream()));
        String linea;
        while ((linea = in.readLine()) != null) {
            System.out.println(linea);
        }

    }

    /**
     * Metodo que le llega por parametro una URL y un String que sera un tag, en caso de 
     * Encontrar la etiqueta imprime.
     * @param url
     * @param tag
     * @throws IOException 
     */
    public static void exercici2(URL url, String tag) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String linea;
        while ((linea = in.readLine()) != null) {
            if (linea.contains(tag)) {                
                System.out.println(linea);
            }
        }
    }
}
