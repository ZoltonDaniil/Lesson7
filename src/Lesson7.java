/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */


import java.util.Random;

public class Lesson7 {
    public static void main(String[] args) {
        Dish dish = new Dish();
        Cat[] cats = generatorCat();
        for (int i = 0; i < cats.length; i++) {
            System.out.println("В миске " + dish.getMeal());
            if (cats[i].getNeedEat() <= dish.getMeal() && cats[i].getNeedEat() != 0) {

                cats[i].setSatiety(true);
                dish.setMeal(dish.getMeal()-cats[i].getNeedEat());
                printCat(cats[i]);
            }
            else printCat(cats[i]);


        }

    }

    private static Cat[] generatorCat() {
        Random random = new Random();
        int a = 0;
        while (true) {
            a = random.nextInt(10);
            if(a > 0) break;

        }


        Cat[] cats = new Cat[a];
        for (int i = 0; i < cats.length; i++) {
            int b = random.nextInt(3);

         cats[i] = new Cat("Cat" + i);
        }

        return cats;
    }

    private static void printCat(Cat cat) {

            if (cat.isSatiety() == true) System.out.printf("Кот %s съел %d еды из миски\n", cat.getName(),cat.getNeedEat());
            else System.out.printf("Кот %s несъел %d еды из миски \n", cat.getName(),cat.getNeedEat());

    }


}
