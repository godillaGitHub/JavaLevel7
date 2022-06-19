package level7;

/*
Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
удалось покушать (хватило еды), сытость = true.
3. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
наполовину сыт (это сделано для упрощения логики программы).
4. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
потом вывести информацию о сытости котов в консоль.
5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ////////////////////////////////////////////////////
        Plate plate = new Plate(100);
        plate.info();

        System.out.println();

        ////////////////////////////////////////////////////
        Random random = new Random();

        //сгенерируем количество кошек
        int countCats = random.nextInt(2, 5);
        System.out.println("Количество кошек: " + countCats);

        //создадим кошек
        Cat[] cats = new Cat[countCats];
        for (int i = 0; i < cats.length; i++) {

            //сгенерируем аппетит у кошки
            int appetite = random.nextInt(1,5);
            cats[i] = new Cat("Барсик №" + (i+1), appetite, true);
            cats[i].info();
        }

        System.out.println();

        ////////////////////////////////////////////////////

        //сгенерируем на какой итерации подкинем кошкам еды
        int numIteration = random.nextInt(countCats-1);

        //сгенерируем сколько подкинем еды в тарелку
        int countFood = random.nextInt(5);

        int j = 0;
        //кошки будут есть, пока есть еда в тарелке
        while (plate.getFoodCount() > 0) {

            int countCatsNotEnoughFood = 0;
            for (int i = 0; i < cats.length; i++) {

                //подкинем еды в тарелку
                if (j == numIteration) {
                    plate.increaseFood(countFood);
                    plate.info();
                }

                //Сейчас выясним кто останется сыт, а кто нет
                if (cats[i].enoughFood(plate)) {
                    cats[i].eat(plate);
                }
                else {
                    countCatsNotEnoughFood += 1;
                }
                //Thread.sleep(1000);
                cats[i].info();
                plate.info();

                j += 1;

            }

            //может быть такая ситуация когда еда в тарелке есть,  а всем при всем котам стало мыло еды
            if (countCatsNotEnoughFood == (countCats - 1)) {
                break;
            }

        }

        System.out.println("\nСтолько раз коты ели из тарелки " + j);

    }
}
