class Person {

    private final String sex;
    private final Integer age;

    public Person(String sex, Integer age) {
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public Integer getAge() {
        return this.age;
    }
}