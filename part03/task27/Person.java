package lesson05.part03.task27;

public class Person implements RepkaItem {
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public void pull(Person person) {
        System.out.println(this.name + " за " + person.getNamePadezh());
    }

    @Override
    public String getNamePadezh() {
        return namePadezh;
    }

}

