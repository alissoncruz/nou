package nou.test.robo;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;

public class PesquisaInternet {
	public static void main(String[] args) {
		
		Gson gson = new Gson(); // Or use new GsonBuilder().create();
		 
		
		wikipedia("João Batista");
	}
    public static void wikipedia(String quote) {  
        try {  
            final String google = "https://esaj.tjsp.jus.br/cpopg/search.do?conversationId=&dadosConsulta.localPesquisa.cdLocal=-1&cbPesquisa=NMPARTE&dadosConsulta.tipoNuProcesso=UNIFICADO&dadosConsulta.valorConsulta=Jo%C3%A3o+Batista+Cardoso&uuidCaptcha=";  
            final String charset = "UTF-8";  
      
            URL url = new URL(google + URLEncoder.encode(quote + "wikipedia", charset));  
            Reader reader = new InputStreamReader(url.openStream(), charset);  
            GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);  
      
            Gson g = new Gson();
            // Mostra o titulo e a url do primeiro resultado  
            System.out.println(results.getResponseData().getResults().get(0).getTitle());  
            System.out.println(results.getResponseData().getResults().get(0).getUrl());  
              
              
        }catch(Exception e) {  
              
            e.printStackTrace();  
        }  
    }  
      
    public class GoogleResults {  
  
        private ResponseData responseData;  
        public ResponseData getResponseData() { return responseData; }  
        public void setResponseData(ResponseData responseData) { this.responseData = responseData; }  
        public String toString() { return "ResponseData[" + responseData + "]"; }  
  
         class ResponseData {  
            private List<Result> results;  
            public List<Result> getResults() { return results; }  
            public void setResults(List<Result> results) { this.results = results; }  
            public String toString() { return "Results[" + results + "]"; }  
        }  
  
         class Result {  
            private String url;  
            private String title;  
            public String getUrl() { return url; }  
            public String getTitle() { return title; }  
            public void setUrl(String url) { this.url = url; }  
            public void setTitle(String title) { this.title = title; }  
            public String toString() { return "Result[url:" + url +",title:" + title + "]"; }  
        }  
  
    }  
}  