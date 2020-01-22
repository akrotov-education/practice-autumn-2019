package lesson05.part04.task07;

public class MoldovanHen extends lesson05.part04.task07.Task07.Hen implements lesson05.part04.task07.Country {
    int getCountOfEggsPerMonth(){
        return 67;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
