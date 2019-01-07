package activeMq;

public class ActiveMqRun {
	public static void main(String ...args) {
		Producter producter = new Producter();
        producter.init();
        ActiveMqRun testMq = new ActiveMqRun();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 2
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 3
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 4
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 5
        new Thread(testMq.new ProductorMq(producter)).start();
        
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        new Thread(testMq.new ConsumerMq(comsumer)).start();
        new Thread(testMq.new ConsumerMq(comsumer)).start();
        new Thread(testMq.new ConsumerMq(comsumer)).start();
        new Thread(testMq.new ConsumerMq(comsumer)).start();
	}
	
	private class ProductorMq implements Runnable{
        Producter producter;
        public ProductorMq(Producter producter){
            this.producter = producter;
        }

        @Override
        public void run() {
            while(true){
                try {
                    producter.sendMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	private class ConsumerMq implements Runnable{
        Comsumer comsumer;
        public ConsumerMq(Comsumer comsumer){
            this.comsumer = comsumer;
        }

        @Override
        public void run() {
            while(true){
                try {
                    comsumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
