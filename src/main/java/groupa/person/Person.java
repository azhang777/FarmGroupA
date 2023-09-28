package groupa.person;

public abstract class Person implements Eater,NoiseMaker {
    private String name;
    private String favPhrase;
    private int age;

    public Person(String name, String favPhrase, int age) {
        this.name = name;
        this.favPhrase = favPhrase;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavPhrase() {
        return favPhrase;
    }

    public void setFavPhrase(String favPhrase) {
        this.favPhrase = favPhrase;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
