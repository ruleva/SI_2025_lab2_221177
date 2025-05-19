**Втора лабораториска вежба по Софтверско инженерство**

**Анастасија Рулева, бр. на индекс 221177**

**Control Flow Graph**
![silab2](https://github.com/user-attachments/assets/25270e52-cfa4-4930-b565-a5f3cdf5f889)


**Цикломатска комплексност**

Цикломатската комплексност на овој код е 9. Ја пресметав со помош на формулите V(G) = E – N + 2
и V(G) = P + 1.

**Тест случаи според критериумот Every statement**
1. allItems == null

   checkCart(null, "1234567890123456")
2. Valid item, bez popust

   List<Item> items = List.of(new Item("Item1", 100, 0, 2));
    checkCart(items, "1234567890123456")
3. Invalid name

   List<Item> items = List.of(new Item(null, 100, 0, 1));
    checkCart(items, "1234567890123456")
4. Item so popust, visoka cena

   List<Item> items = List.of(new Item("Item2", 350, 0.1, 1));
    checkCart(items, "1234567890123456")
5. Nevaliden karakter vo karticka

   List<Item> items = List.of(new Item("Item3", 50, 0, 1));
    checkCart(items, "12345678901234AB")
6. karticka e null

     List<Item> items = List.of(new Item("Item3", 50, 0, 1));
    checkCart(items, null)

**Тест случаи според критериумот Multiple Condition**
TC1: Price=200, Discount=0, Quantity=1 — no conditions met, so sum -= 30 not executed

TC2: Price=200, Discount=0, Quantity=11 — only Quantity > 10 applies

TC3: Price=200, Discount=0.1, Quantity=1 — only Discount > 0 applies

TC4: Price=200, Discount=0.1, Quantity=11 — Discount and Quantity apply

TC5: Price=350, Discount=0, Quantity=1 — only Price > 300 applies

TC6: Price=350, Discount=0, Quantity=11 — Price and Quantity apply

TC7: Price=350, Discount=0.1, Quantity=1 — Price and Discount apply

TC8: Price=350, Discount=0.1, Quantity=11 — all conditions apply

**Објаснување на напишаните unit tests**

Со тестовите се покриени сите Every Statement и Multiple Condition можности со assert
