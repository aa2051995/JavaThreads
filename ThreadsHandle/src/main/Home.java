package main;

public class Home  {
   public Home() {
      
   }

  
   public void printEven(String name) throws InterruptedException {
     int i =0;
      while(i<50) {
    	  i+=1;
    	   if(i%2==0)
            System.out.println("thread "+name+" "+i);
      
      }
         
      
   }

   
   public void printODD(String name) throws InterruptedException {
      int i =0;
       while(i<50) {
    	  i +=1; 
    	  if(i%2 != 0)
    		  System.out.println("thread "+name+ " "+i);
       }
   }

   public static void main(String[] args) {
      final Home demo = new Home();

      Runnable runA = new Runnable() {

         public void run() {
            try {
               demo.printODD(Thread.currentThread().getName());
               
            } catch (InterruptedException ix) {
               System.out.println("Interrupted Exception!");
            } catch (Exception x) {
               System.out.println("Exception thrown."+x);
            }
         }
      };

      Runnable runB = new Runnable() {

         
         public void run() {
            try {
				demo.printEven(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
      };

      try {
         Thread threadA1 = new Thread(runA, "A");
         threadA1.start();

         Thread threadB1 = new Thread(runB, "B");
         threadB1.start();
         Thread.sleep(500);

//
//         threadA1.interrupt();
//         threadB1.interrupt();
      } catch (InterruptedException x) {
      }
   }
}