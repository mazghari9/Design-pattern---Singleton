/* ------- Exécution Parallèle ------- */
import java.util.concurrent.*; 
public class Client extends Thread{
	
	Semaphore sem;	//un sémaphore pour la synchronisation
	String threadName;//le nom de thread 
    
	public Client(Semaphore sem, String threadName)  
    { 
        super(threadName); 
        this.sem = sem; 
        this.threadName = threadName; 
    } 
	
	//la fonction run pour démarrer le processus de création de l'objet Terre
	public void run(){
		try 
        { 
			System.out.println(threadName + " is waiting for a permit."); 
			sem.acquire(); 
			System.out.println(threadName + " gets a permit.");
            Terre x = Terre.Creer(this.getName());
    		System.out.println(x.Message);
        } catch (InterruptedException exc) { 
        	System.out.println(exc); 
        }     
		System.out.println(threadName + " releases the permit.");
        sem.release(); 
        
    }

	public static void main(String[] args) throws InterruptedException {
		boolean key2;
		Semaphore sem = new Semaphore(1); 
		// TODO Auto-generated method stub
		Client a = new Client(sem,"first thread");
		Client b = new Client(sem,"second thread");
		Client c = new Client(sem,"third thread");
		
		a.start();
		b.start();
		c.start();
		
		a.join();
		b.join();
		c.join();
		
		System.out.println("Finish"); 
			
	}
}

/* ------- Exécution séquentiel ------- */
/*
public class Client{
	
	public void run(String a){
            Terre x = Terre.Creer(a);
    		System.out.println(x.Message);
    }

	
	public static void main(String[] args) throws InterruptedException {
		boolean key2;
		// TODO Auto-generated method stub
		Client a = new Client();
		Client b = new Client();
		Client c = new Client();
		
		a.run("a");
		b.run("b");
		c.run("c");
		
		System.out.println("Finish"); 
			
	}
}*/
