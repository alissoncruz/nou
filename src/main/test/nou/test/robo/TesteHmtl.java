package nou.test.robo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteHmtl {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("F:/nou/arquivos/lotofacil/lotofacil.htm"));
			try {
				while (br.ready()) {
					String linha = br.readLine();
					linha = linha.trim();
					System.out.println(linha);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
