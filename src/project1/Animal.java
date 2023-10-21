/** Cтворити проект, пакет.
 *  Створити клас Animal з ім'ям String, int віком, хвостом Boolean.
 *  У класі перевизначити метод toString, щоб висновок був наступним «Ім'я: Васька, вік: 45, хвіст: ні».
 *  У класі Animal перевизначити методи equals & hashCode.
 */

package project1;

import java.util.Objects;

public class Animal {
        private final String name;
        private final int age;
        private final Boolean hasTail;

        public Animal(String name, int age, Boolean hasTail) {
            this.name = name;
            this.age = age;
            this.hasTail = hasTail;
        }

        @Override
        public String toString() {
            return "Ім'я: " + name + ", вік: " + age + ", хвіст: " + (hasTail ? "так" : "ні");
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return age == animal.age && Objects.equals(name, animal.name) && Objects.equals(hasTail, animal.hasTail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hasTail);
    }

    static class NewAnimal {
            public static void main(String[] args) {
                Animal animal = new Animal("Васька", 45, false);
                System.out.println(animal);
            }
        }
    }


