public class Main {
    public static void main(String[] args) {

        BonusService service = new BonusService();

        int bonus = service.calculate(5000, true);
        System.out.println(bonus);

    }

}
