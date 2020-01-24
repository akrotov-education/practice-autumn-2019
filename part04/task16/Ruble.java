package lesson05.part04.task16;
import lesson05.part04.task16.Task16.Money;

class Ruble extends Money {
    public Ruble(double amount) {
        super(amount);
    }
    public String getCurrencyName(){
        return "RUB";
    }
}