package lesson05.part05.task22;

public class Sun implements Planet {
    private static Sun Instance;
    private Sun(){

    }
    public static Sun getInstance(){
        if(Instance==null){
            Instance = new Sun();
        }
        return Instance;
    }
}
