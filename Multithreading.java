package AcadviewAssignments.Assignment13;


class MyThread implements Runnable{

    Thread t;
    CallMe callMe;
    int num;

    public MyThread(CallMe callMe,int num) {
        this.t = new Thread(this,"MyThread");
        this.callMe = callMe;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 1; i<=num;i++){
            callMe.printNum(i);
//            try {
//                t.sleep(500);
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted");
//            }
        }
    }
}

class CallMe{

    static int i = 0;
    synchronized void printNum(int i){
        if(i>this.i){
            this.i = i;
        }else  return;
        System.out.println(i);
    }
}


public class Multithreading {

    public static void main(String[] args) {

        CallMe callMe = new CallMe();
        MyThread one = new MyThread(callMe,1000);
        MyThread two = new MyThread(callMe,1000);

//        MyThread one = new MyThread(callMe,500);
//        MyThread two = new MyThread(callMe,100);

        one.t.start();
        two.t.start();

        try{
            one.t.join();
            two.t.join();
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }
    }
}
