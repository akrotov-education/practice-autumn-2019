package lesson05.part04.task07;

public  class RussianHen extends Task07.Hen implements Country{
    int getCountOfEggsPerMonth(){
        return 58;
    }
    String getDescription(){
        return "Я - курица." + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}