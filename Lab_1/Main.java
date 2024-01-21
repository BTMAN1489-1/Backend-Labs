class Cat{
    private String name;
    private int age;
    private String lord;
    
    Cat(String name, int age, String lord){
        this.name = name;
        this.age = age;
        this.lord = lord;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public int get_age(){
        return this.age;
    }

    public String get_lord(){
        return this.lord;
    }
    
    public void say_meow(){
        if (age <= 1){
            System.out.println("мяу");
        }else {
            System.out.println("МЯУУУ");
        }
    }
    
    public void squeeze_milk(){
        System.out.println("облизал молоко");
    }
    
    public void jump(){
        System.out.println("Прыг-скок");
    }
    
}

public class Main{
	public static void main(String[] args) {
		Cat kitty = new Cat("Бобик", 10, "Мастер Чиф");
		kitty.say_meow();
        kitty.get_age();
	}
}