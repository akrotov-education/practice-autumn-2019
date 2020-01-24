package lesson05.part04.task07;

public class UkrainianHen extends lesson05.part04.task07.Task07.Hen implements lesson05.part04.task07.Country {
    int getCountOfEggsPerMonth(){
        return 62;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}