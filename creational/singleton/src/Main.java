public class Main {
    public static class singlethread{
        public void execute() {
            System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n");
            singleton_single_thread instance = singleton_single_thread.getInstance("FOO");
            singleton_single_thread another_instance = singleton_single_thread.getInstance("BAR");
            System.out.println(instance.value);
            System.out.println(another_instance.value);
        }
    }

    public  static  class failed_multithread {
        static class ThreadFoo implements Runnable {
            @Override
            public void run() {
                singleton_mt_fail singleton = singleton_mt_fail.getInstance("FOO");
                System.out.println(singleton.value);
            }
        }
        static class ThreadBar implements Runnable {
            @Override
            public void run() {
                singleton_mt_fail singleton = singleton_mt_fail.getInstance("BAR");
                System.out.println(singleton.value);
            }
        }
        public void execute() {
            System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n");
            Thread threadFoo = new Thread(new ThreadFoo());
            Thread threadBar = new Thread(new ThreadBar());
            threadFoo.start();
            threadBar.start();
        }
    }

    public  static  class safe_multithread {

        public void execute(){
            System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n");
            Thread threadFoo = new Thread(new ThreadFoo());
            Thread threadBar = new Thread(new ThreadBar());
            threadFoo.start();
            threadBar.start();
        }

        static class ThreadFoo implements Runnable {
            @Override
            public void run() {
                singleton_thread_safe singleton = singleton_thread_safe.getInstance("FOO");
                System.out.println(singleton.value);
            }
        }

        static class ThreadBar implements Runnable {
            @Override
            public void run() {
                singleton_thread_safe singleton = singleton_thread_safe.getInstance("BAR");
                System.out.println(singleton.value);
            }
        }
    }
    public static void main(String[] args) {

//         singlethread instance =  new singlethread();
//         instance.execute();

//        failed_multithread instance = new failed_multithread();
//        instance.execute();

        safe_multithread instance = new safe_multithread();
        instance.execute();

    }
}
