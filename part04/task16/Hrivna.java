package lesson05.part04.task16;
import lesson05.part04.task16.Task16.Money;

class Hrivna extends Money {
    public Hrivna(double amount) {
        super(amount);
    }
    public String getCurrencyName(){
        return "UAH";
    }
}
