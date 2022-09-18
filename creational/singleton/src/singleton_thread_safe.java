public final class singleton_thread_safe {
    private static singleton_thread_safe instance;
    public String value;

    private singleton_thread_safe(String value) {
        this.value = value;
    }

    public static singleton_thread_safe getInstance(String value) {
        if(instance == null) {
            synchronized (singleton_thread_safe.class) {
                if(instance == null) {
                    instance = new singleton_thread_safe(value);
                }
            }
        }
        return  instance;
    }
}
