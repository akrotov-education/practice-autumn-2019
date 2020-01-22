package lesson05.part04.task16;
import lesson05.part04.task16.Task16.Money;

class USD extends Money {
    public USD(double amount) {
        super(amount);
    }
    public String getCurrencyName(){
        return "USD";
    }
}
