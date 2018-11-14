package com.fatihkabakci.stackandqueue.AnimalShelter;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnimalShelter {
	
	Deque<Animal> shelter;
	
	public AnimalShelter() {
		shelter = new ArrayDeque<Animal>();
	}
	
	public void enqueue(Animal pet) {
		shelter.add(pet);
	}
	
	public Animal dequeueAny() {
		return shelter.remove();
	}
	
	private Animal dequeue(AnimalType type) {
		Deque<Animal> temp = new ArrayDeque<Animal>();
		while(!shelter.isEmpty()) {
			Animal pet = shelter.remove();
			if(pet.getClass().getSimpleName().toUpperCase().equals(type.name())) {
				while(!temp.isEmpty())
					shelter.addFirst(temp.removeLast());
				return pet;
			}else {
				temp.add(pet);
			}
		}
		return null;
	}
	
	public Cat dequeueCat() {
		return (Cat) dequeue(AnimalType.CAT);
	}
	
	public Dog dequeueDog() {
		return (Dog) dequeue(AnimalType.DOG);
	}
	
	public static void main(String[] args) {
		Dog d1 = new Dog(1);
		Dog d2 = new Dog(2);
		Dog d3 = new Dog(3);
		Dog d4 = new Dog(4);
		Dog d5 = new Dog(5);
		
		Cat c1 = new Cat(6);
		Cat c2 = new Cat(7);
		Cat c3 = new Cat(8);
		Cat c4 = new Cat(9);
		Cat c5 = new Cat(10);
		Cat c6 = new Cat(11);
		
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(d1);
		shelter.enqueue(d2);
		shelter.enqueue(c1);
		shelter.enqueue(d3);
		shelter.enqueue(c2);
		shelter.enqueue(c3);
		shelter.enqueue(d4);
		shelter.enqueue(c4);
		shelter.enqueue(c5);
		shelter.enqueue(c6);
		shelter.enqueue(d5);
		
		System.out.println(shelter.dequeueCat().id);
		System.out.println(shelter.dequeueCat().id);
		System.out.println(shelter.dequeueAny().id);
		System.out.println(shelter.dequeueAny().id);
		System.out.println(shelter.dequeueCat().id);
	}
}