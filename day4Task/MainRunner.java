package day4Task;

public class MainRunner {
public static void main(String[] args) {
		
	Engine e1 = new Engine(800);
	Engine e2 = new Engine(1800);
	Car arr[] = new Car[3];
	Car obj1 = new Car(e1);
	obj1.setCarName("Honda");
	obj1.setCarPower(1000);
	Car obj2 = new Car(e2);
	obj1.setCarName("BMW");
	obj1.setCarPower(2000);
	Car obj3 = new Car(e1);
	obj1.setCarName("Toyota");
	obj1.setCarPower(3000);
	// insert into an array
	arr[0] = obj1;
	arr[1] = obj2;
	arr[2] = obj3;
	// ---- iterate the array
	// approach - 1
	for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i].getCarName()+" - "+arr[i].getCarPower());
	}
	System.out.println("-----------------------------------");
	// --- appraoch 2
	for (Car car : arr) {
		if(car.getCarPower() > 1500)
		{
			System.out.println(car.getCarName()+" --- "+car.getCarPower());
		}
	}
	
	}
}
