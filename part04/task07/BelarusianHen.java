package lesson05.part04.task07;

public class BelarusianHen extends lesson05.part04.task07.Task07.Hen implements lesson05.part04.task07.Country {
    int getCountOfEggsPerMonth(){
        return 29;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
