package br.com.nou.task;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("dataMiningTask")
public class DataMiningTask implements IStartProcessTask, InitializingBean{

	@Override
	public void start(long timeStart) {

		new Thread() {
			
			public void run() {
				System.out.println("Estou executando");
				 try {
					Thread.sleep(1500L );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}.start();
		
	}

	@Override
	public void stop() {
	}

	@Override
	public boolean isStart() {
		return true;
	}

	@Override
	public void setStart(boolean executar) {
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Task DataMining");
	}


}
