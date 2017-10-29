package nou.test.robo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LerHtml {

	public static void main(String[] args) {
		List<String> bloco = new ArrayList<String>();
		List<String> bloco1 = new ArrayList<String>();
		List<String> lista = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("F:/nou/arquivos/lotofacil/lotofacil.htm"));

			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("th")) {
					String[] header = linha.split(">");
					for (String s : header) {
						lista.add(s);
					}
				}
				if (linha.contains("tr")) {
					String header = "";
				}
				// System.out.println(linha);
			}

			for (String limpar : lista) {
				//bloco1.add(trataBloco1(limpar));
			}
			for (String s : bloco1) {
				// bloco.add(trataBloco2(s));
			}

			for (String b : bloco) {
				// System.out.println(b);
			}

			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static String trataBloco1(final String linha) {
		String conteudo = "";
		List<String> lista = new ArrayList<String>();
		lista.add("<font>");
		lista.add("color");
		lista.add("height");
		lista.add("width");
		lista.add("Arial");
		lista.add("table");
		lista.add("/>");
		lista.add("<");
		lista.add("th");
		lista.add("cellpadding");
		lista.add("/");
		lista.add("border");
		lista.add("small");
		lista.add("face");
		lista.add("=");

		conteudo = linha;

		for (String tag : lista) {
			conteudo = conteudo.replace(tag, "").trim();

		}
		return conteudo;
	}

	public static String trataBloco2(final String linha) {
		String segundoTratamento = linha;
		List<String> tags = new ArrayList<String>();
		tags.add("#");
		tags.add("");

		for (String tag : tags) {
			if (segundoTratamento.contains("#")) {
				// System.out.println(segundoTratamento);
				segundoTratamento = tag.replace(segundoTratamento, "");
				// System.out.println("depois: " + segundoTratamento);
			}
			segundoTratamento = tag;
		}

		return segundoTratamento;
	}
}
