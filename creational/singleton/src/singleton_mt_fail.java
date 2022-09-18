public class singleton_mt_fail {
    private static singleton_mt_fail instance;
    public String value;

    private singleton_mt_fail(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value =  value;
    }

    public static singleton_mt_fail getInstance(String value) {
        if(instance == null) {
            instance = new singleton_mt_fail(value);
        }
        return instance;
    }
}
