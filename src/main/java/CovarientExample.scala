/**
 * Created by NKumar on 12/17/2016.
 */
object CovarientExample {

  class Animal[+T]

  class Dog

  class Puppy extends Dog

  class AnimalCarer(val dog: Animal[Dog])

  def main(args: Array[String]) {
    val puppy = new Puppy
    val dog = new Dog

    val puppyAnimal: Animal[Puppy] = new Animal[Puppy]
    val dogAnimal: Animal[Dog] = new Animal[Puppy]

    val dogCarer = new AnimalCarer(dogAnimal)
    val puppyCarer = new AnimalCarer(puppyAnimal)

    println("Done.")
  }

}
