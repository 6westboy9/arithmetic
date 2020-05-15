package com.westboy.chapter_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author westboy
 * @since 2020/1/14
 */
public class Question_14 {

	public static void main(String[] args) {

	}

	static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	static class Dog extends Pet {
		public Dog(String type) {
			super("dog");
		}
	}

	static class Cat extends Pet {
		public Cat(String type) {
			super("cat");
		}
	}

	// ----------------------------------

	static class PetEnterQueue {
		private Pet pet;
		private long count;

		public PetEnterQueue(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return pet;
		}

		public long getCount() {
			return count;
		}

		public String getEnterPetType() {
			return this.pet.getType();
		}
	}

	static class DogCatQueue {
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private long count;

		public DogCatQueue() {
			this.dogQ = new LinkedList<>();
			this.catQ = new LinkedList<>();
			this.count = 0;
		}

		public void add(Pet pet) {
			if (pet.getType().equals("dog")) {
				this.dogQ.add(new PetEnterQueue(pet, this.count++));
			} else if (pet.getType().equals("cat")) {
				this.catQ.add(new PetEnterQueue(pet, this.count++));
			} else {
				throw new RuntimeException("err, not dog or cat");
			}
		}

		public Pet pollAll() {
			if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
				if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
					return this.dogQ.poll().getPet();
				} else {
					return this.catQ.poll().getPet();
				}
			} else if (!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			} else if (!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			} else {
				throw new RuntimeException("err, queue is empty!");
			}
		}

		public Dog pollDog() {
			if (!this.isDogQueueEmpty()) {
				return (Dog) this.dogQ.poll().getPet();
			} else {
				throw new RuntimeException("err, dog queue is empty!");
			}
		}

		public Cat pollCat() {
			if (!this.isCatQueueEmpty()) {
				return (Cat) this.dogQ.poll().getPet();
			} else {
				throw new RuntimeException("err, cat queue is empty!");
			}
		}


		public boolean isDogQueueEmpty() {
			return this.dogQ.isEmpty();
		}

		public boolean isCatQueueEmpty() {
			return this.catQ.isEmpty();
		}

		public boolean isEmpty() {
			return this.dogQ.isEmpty() && this.catQ.isEmpty();
		}
	}

}
