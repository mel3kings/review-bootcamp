package algorithm;


abstract class ReaderImpl {
    protected Object authentication;
    ReaderImpl(Object authentication) throws Exception{
        if(null == authentication){
            throw new Exception();
        }else{
            this.authentication = authentication;
        }
    }
    public void reader(String x, Object authentication) {
        System.out.println("Reader Implemented");
    }

}

class DevReader extends ReaderImpl {
    public DevReader(Object authentication) throws Exception{
        super(authentication);
    }
    @Override
    public void reader(String x, Object authentication) {
        System.out.println("Dev Implemented");
    }
}



