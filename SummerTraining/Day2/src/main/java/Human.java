
public class Human extends Animal{
	
	void eat(){
		System.out.println("Human.eat()");
	}

	public static void main(String[] args) {
		Animal animal = new Human();
		animal.eat();
	}

}
