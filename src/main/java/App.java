public class App {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Java Application Started");
        System.out.println("   CI/CD Pipeline Working!");
        System.out.println("=================================");

        while(true) {
            try {
                Thread.sleep(10000);
                System.out.println("Application running inside Docker container...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
