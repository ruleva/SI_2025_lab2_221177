#Втора лабораториска вежба по Софтверско инженерство
#Анастасија Рулева, бр. на индекс 221177

#Control Flow Graph
![silab2](https://github.com/user-attachments/assets/25270e52-cfa4-4930-b565-a5f3cdf5f889)


#Цикломатска комплексност
Цикломатската комплексност на овој код е 9. Ја пресметав со помош на формулите V(G) = E – N + 2
и V(G) = P + 1.

#Тест случаи според критериумот Every statement
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

#Тест случаи според критериумот Multiple Condition
    | Тест | Price | Discount | Quantity | Објаснување                                       |
    | ---- | ----- | -------- | -------- | ------------------------------------------------- |
    | TC1  | 200   | 0        | 1        | Ниеден услов не важи → `sum -= 30` не се извршува |
    | TC2  | 200   | 0        | 11       | Само Quantity > 10 важи                           |
    | TC3  | 200   | 0.1      | 1        | Само Discount > 0 важи                            |
    | TC4  | 200   | 0.1      | 11       | Discount и Quantity важат                         |
    | TC5  | 350   | 0        | 1        | Само Price > 300 важи                             |
    | TC6  | 350   | 0        | 11       | Price и Quantity важат                            |
    | TC7  | 350   | 0.1      | 1        | Price и Discount важат                            |
    | TC8  | 350   | 0.1      | 11       | Сите важат      

#Објаснување на напишаните unit tests

Со тестовите се покриени сите Every Statement и Multiple Condition можности
