import helloworld.HelloWorld;

public class Test {

    public static void main(String[] args) {
        /**
         * We testing world1 where the name is null
         */
        HelloWorld world1 = new HelloWorld(null);
        System.out.println(world1.toString());
        /**
         * We testing world2 where the name is set to "Martin"
         */
        HelloWorld world2 = new HelloWorld("Martin");
        System.out.println(world2.toString());
        world2.setName("En anden Martin");
        new gui.GUI(new String[]{"helloworld"}, world1);
    }
}