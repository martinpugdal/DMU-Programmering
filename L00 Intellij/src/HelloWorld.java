public class HelloWorld {

    private String name;
    public HelloWorld(String name) {
        this.name = name == null ? "World" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Hello %s!", this.name);
    }
}