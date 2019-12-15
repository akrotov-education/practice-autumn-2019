package lesson05.part04.task07;

public class UkrainianHen extends Task07.Hen implements Country{
    int getCountOfEggsPerMonth(){
        return 62;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}