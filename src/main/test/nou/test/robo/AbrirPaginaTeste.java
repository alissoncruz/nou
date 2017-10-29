package nou.test.robo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AbrirPaginaTeste {

	public static void main(String[] args) {
		String stringURL =  "https://www.uol.com.br/";//"https://www.jucesponline.sp.gov.br/Pre_Visualiza.aspx?nire=35223261032&idproduto=";//"http://vestibular.ufrgs.br/cv2017/listao/arquivo_a.html";//  "https://www.uol.com.br/";//"http://www.guj.com.br";
        String resposta = "";
        try {
            URL url = new URL(stringURL);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer sb = new StringBuffer();
            while ((inputLine = in.readLine()) != null) sb.append(inputLine);
            resposta = sb.toString();
            System.out.println(resposta);
            in.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

	}

}
