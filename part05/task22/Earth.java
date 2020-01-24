package lesson05.part05.task22;

public class Earth implements Planet{
    private static Earth Instance;
    private Earth(){

    }
    public static Earth getInstance(){
        if(Instance==null){
            Instance = new Earth();
        }
        return Instance;
    }
}
