import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {
        // TC1: allItems == null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567890123456"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // TC2: valid item, no discount, valid card
        double result2 = SILab2.checkCart(List.of(new Item("Apple", 2, 100, 0.0)), "1234567890123456");
        assertEquals(200.0, result2);

        // TC3: item with null name
        RuntimeException ex3 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(new Item(null, 1, 100, 0.0)), "1234567890123456"));
        assertTrue(ex3.getMessage().contains("Invalid item!"));

        // TC4: price > 300 triggers penalty and discount
        double result4 = SILab2.checkCart(List.of(new Item("TV", 1, 400, 0.1)), "1234567890123456");
        assertEquals(330.0, result4);

        // TC5: invalid character in card number
        RuntimeException ex5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(new Item("Pen", 1, 50, 0.0)), "1234abcD5678!@#$"));
        assertTrue(ex5.getMessage().contains("Invalid character"));

        // TC6: cardNumber is null
        RuntimeException ex6 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(new Item("Pen", 1, 50, 0.0)), null));
        assertTrue(ex6.getMessage().contains("Invalid card number!"));
    }

    @Test
    void testMultipleConditionPenalty() {
        // T F F (price > 300)
        double res1 = SILab2.checkCart(List.of(new Item("A", 1, 350, 0.0)), "1234567890123456");
        assertEquals(320.0, res1);

        // F T F (discount > 0)
        double res2 = SILab2.checkCart(List.of(new Item("B", 1, 100, 0.1)), "1234567890123456");
        assertEquals(60.0, res2);

        // F F T (quantity > 10)
        double res3 = SILab2.checkCart(List.of(new Item("C", 11, 10, 0.0)), "1234567890123456");
        assertEquals(80.0, res3);

        // T T F
        double res4 = SILab2.checkCart(List.of(new Item("D", 1, 400, 0.1)), "1234567890123456");
        assertEquals(330.0, res4);

        // T F T
        double res5 = SILab2.checkCart(List.of(new Item("E", 15, 400, 0.0)), "1234567890123456");
        assertEquals(5970.0, res5);

        // F T T
        double res6 = SILab2.checkCart(List.of(new Item("F", 15, 100, 0.1)), "1234567890123456");
        assertEquals(1320.0, res6);

        // T T T
        double res7 = SILab2.checkCart(List.of(new Item("G", 20, 400, 0.2)), "1234567890123456");
        assertEquals(6370.0, res7);

        // F F F
        double res8 = SILab2.checkCart(List.of(new Item("H", 1, 100, 0.0)), "1234567890123456");
        assertEquals(100.0, res8);
    }
}
