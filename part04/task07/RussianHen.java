package lesson05.part04.task07;

public class RussianHen extends lesson05.part04.task07.Task07.Hen implements lesson05.part04.task07.Country {
    int getCountOfEggsPerMonth(){
        return 58;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}