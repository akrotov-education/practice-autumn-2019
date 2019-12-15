package lesson05.part04.task16;

class Ruble extends Money {


    public Ruble(double amount) {
        super(amount);
    }

    public String getCurrencyName(){
        return "RUB";
    }
}