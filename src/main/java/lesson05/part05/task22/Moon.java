package lesson05.part05.task22;

public class Moon implements Planet {
    private static Moon Instance;
    private Moon(){

    }
    public static Moon getInstance(){
        if(Instance==null){
            Instance = new Moon();
        }
        return Instance;
    }
}
