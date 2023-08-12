import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        int amount = 1000;
        boolean registered = true;
        int expected = 30;

        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        int amount = 1_000_000;
        boolean registered = true;
        int expected = 500;

        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndZero() {
        BonusService service = new BonusService();
        int amount = 0;
        boolean registered = true;
        int expected = 0;

        int actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        int amount = 100;
        boolean registered = false;
        int expected = 1;

        int actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndNegative() {
        BonusService service = new BonusService();
        int amount = -100;
        boolean registered = true;
        int expected = 0;

        int actual = service.calculate(amount, registered);

        Assertions.assertNotEquals(expected, actual);
        // it must be Equal, but state is not considerate,
        // or it should throw an error
    }
}
