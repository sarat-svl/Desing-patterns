public final class singleton_single_thread {
    private static singleton_single_thread instance;
    public String value;

    private singleton_single_thread(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value =  value;
    }

    public  static singleton_single_thread getInstance(String value) {
        if(instance == null) {
            instance = new singleton_single_thread(value);
        }
        return instance;
    }

}
