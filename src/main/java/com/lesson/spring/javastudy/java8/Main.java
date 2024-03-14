package com.lesson.spring.javastudy.java8;

import com.lesson.spring.javastudy.java8.Dog.Baby;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("dog1", 3 );
        Dog dog2 = new Dog("dog2", 5);
        Dog dog3 = new Dog("dog3", 2);
        Dog dog4 = new Dog("dog4", 8);
        Dog dog5 = new Dog("dog5", 3);

        dog1.addBaby("dogBaby1", 1);
        dog1.addBaby("dogBaby1_2", 0);

        dog2.addBaby("dogBaby2_1", 1);
        dog2.addBaby("dogBaby2_2", 0);

        dog3.addBaby("dogBaby3_1", 1);
        dog3.addBaby("dogBaby3_2", 0);

        dog4.addBaby("dogBaby4_1", 2);
        dog4.addBaby("dogBaby4_2", 4);

        dog5.addBaby("dogBaby5_1", 1);
        dog5.addBaby("dogBaby5_2", 0);
        dog5.addBaby("dogBaby5_3", 0);

        List<Dog> dogs = List.of(dog1, dog2, dog3, dog4, dog5);
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

//        int intValue = integers.stream()
//                .reduce(0, (x, y) -> x + y);

//        int intValue = integers.stream()
//                .reduce(0, Integer::sum);

//        integers.stream()
//                .filter()
//
//
//        int sum = integers.stream()
//                .mapToInt(x -> x).sum();
//
//        System.out.println(sum);
//

        // predicate
        List<Dog> dogList = dogs.stream()
                .filter(dogPredicate())
                .toList();

        boolean test = dogPredicate().test(dog1);
        System.out.println(test);

        for (Dog dog : dogList) {
            System.out.println(dog);
        }

        // map -> Stream<Stream<Baby>>
        // flatMap -> Stream<Baby>
//        List<Baby> babies = dogs.stream()
//                .flatMap(dog -> dog.getBabies().stream())
//                .filter(baby -> baby.getAge() == 0).toList();
//
//        for (Baby baby : babies) {
//            System.out.println(baby);
//        }
        // Stream<Dog>
    }



    public static Predicate<Dog> dogPredicate() {
        return (dog) -> dog.getAge() > 5;
    }

}
