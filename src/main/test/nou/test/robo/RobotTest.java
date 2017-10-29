package nou.test.robo;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RobotTest {
	
    private static final String URL_SITE = "https://esaj.tjsp.jus.br/cpopg/search.do?conversationId=&dadosConsulta.localPesquisa.cdLocal=-1&cbPesquisa=NMPARTE&dadosConsulta.tipoNuProcesso=UNIFICADO&dadosConsulta.valorConsulta=Jo%C3%A3o+Batista+Cardoso&uuidCaptcha=";

	public static void main(String[] args) throws Exception{
		
		String palavraChave= "cardoso";
		try {
			Document document = getDocument(palavraChave);
			Elements receitas = getReceitas(document);
			imprimeReceitas(receitas);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static Document getDocument(String palavraChave) throws Exception {
        return Jsoup.connect(URL_SITE ).get();
    }
	public static Elements getReceitas(Document document) {
        return document.select("a[href].titulo.f21.g.i.tp.mb5.l.w100");
    }
	
    public static void imprimeReceitas(Elements receitas) {
        for(Element receita : receitas) {
            System.out.println("------------------------------------------------------");
            System.out.println("Receita: " + receita.text());
            System.out.println("Link para os ingredientes: " + receita.attr("href"));
            System.out.println("------------------------------------------------------");
        }
    }
}
