package br.com.nou.task.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.nou.task.IStartProcessTask;

@Service("importsTask")
public class ImportsTask implements IStartProcessTask, InitializingBean {

	private static final Logger logger = Logger.getLogger(ImportsTask.class);
	
	private boolean executar = false;
	private Thread thread;
	private Long tempoEspera = 8000L;
	@Value("${thread.tempo.espera}")
	private String configTempoEspera;
	
	private final static Integer 	INFORME_DIARIO 			= 209;
	private final static Integer 	BALANCETE 				= 50;
	private final static Integer 	CODIGO_SISTEMA_CVM 		= 1963;
	private final static String 	SENHA_SISTEMA_CVM 		= "2340";
	protected static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
	private final Map<Chave, File> arqs = new HashMap<Chave, File>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug(this.getClass().getName() + " inicializou com sucesso");
	}

	@Override
	public void start(long tempoParaIniciar) {
		if (executar == false) {
			return;
		}
		
		this.thread = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					Thread.sleep(tempoParaIniciar);
				} catch (InterruptedException e1) {
					throw new RuntimeException("Erro ao esperar para iniciar a thread ", e1);
				}

				if (configTempoEspera != null && !configTempoEspera.isEmpty()) {
					tempoEspera = Long.parseLong(configTempoEspera);
				}
				
				

				while (isStart()) {

					try {						
						try {
							
						} catch (Exception e) {
							logger.error("Erro no download do arquivo: "+e);
						}
						// rotinaExecRepositorio.executarAtualizarFinandealer();
						logger.info("Executando download da Clearing");						

					
					

						Thread.sleep(10);
					} catch (InterruptedException e) {
						logger.error(e);
					} catch (Exception e) {
						logger.error(e);
						throw new RuntimeException(e);
					}
					try {
						synchronized (this) {
							Thread.sleep(tempoEspera);
						}
					} catch (InterruptedException e) {
						logger.info("Fetcher Parado" );
						throw new RuntimeException(e);
					}
				}
			}

		});
		thread.setName("boletasCleringFtpTask");
		thread.start();
		
	}

	@Override
	public void stop() {
		if (thread != null) {
			this.thread.interrupt();
			this.thread = null;
		}
		this.executar = false;
		
	}

	@Override
	public boolean isStart() {
	
		return executar;
	}

	@Override
	public void setStart(boolean executar) {
		
		this.executar = executar;
	}
	
	public File criarFile() {
		File file = new File(  "C://teste/" +  "arquivo.zip");
		return file;
	}
	
	protected boolean fazerDownload(final Date fechamento, final File file) {			
		try{
			
			realizarDownloads(arqs);			  
		} catch(Exception e){
			logger.warn(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	
	private boolean realizarDownloads(Map<Chave, File> arqs) {
		boolean ingnore = true;
		for (Entry<Chave, File> item : arqs.entrySet()) {
			urlDownloadFile(item.getKey().getUrl(), item.getValue(), ingnore);
		}
		return true;
	}
	public static class Chave {
		private String id;
		private String url;

		public Chave(final String id, final String url) {
			this.id = id;
			this.url = url;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
	public static boolean urlDownloadFile(final String urlSt, final File file, final boolean ignore) {
		FileOutputStream out = null;
		InputStream in = null;

		try {
			final URL url = new URL(urlSt);
			final URLConnection conn = url.openConnection();
			conn.setConnectTimeout(1000 * 6000 * 60);
			conn.setReadTimeout(1000 * 6000 * 60);

			out = new FileOutputStream(file);
			in = conn.getInputStream();

			// realizar a copia do arquivo.
			copiar(in, out, file);

		} catch (Exception e) {
			if (!ignore)
				throw new RuntimeException(e);
			else
				e.printStackTrace();

		} finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (file.exists() && file.length() == 0) {
				file.delete();
				
			}
		}

		return true;
	}
	public static void copiar(final InputStream in, final OutputStream out, final File file) throws Exception {

		final byte[] buff = new byte[1024];


		try {

			int read = -1;
			while ((read = in.read(buff)) != -1) {
				out.write(buff, 0, read);
				out.flush();

			}

		} catch (Exception e) {
			throw new Exception(e);
		} finally {

			
		}
	}
}
