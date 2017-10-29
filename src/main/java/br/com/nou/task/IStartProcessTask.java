package br.com.nou.task;

public interface IStartProcessTask {
	public void start(final long timeStart);
	public void stop();
	
	public boolean isStart();
	public void setStart(boolean starting) ;

}
