package Assignment1;

import java.util.Scanner;

public class Application {
	static Scanner scanner;
	
	public static Item ScanInput() {
		scanner = new Scanner(System.in);
		System.out.println("Please enter the details of the Item: \n Item Name : ");
	    String name = scanner.nextLine();
	    System.out.println("Item Type : ");
	    String type = scanner.nextLine();
	    ItemType itemType = ItemType.valueOf(type);
	     System.out.println("Item Price : ");
	    double price = scanner.nextDouble();			    
	    System.out.println("Item Quantity : ");
	    int quantity = scanner.nextInt();
	    scanner.nextLine();
	    return new Item(name, price, quantity, itemType);	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        String repeat = "y";
			while(repeat.equalsIgnoreCase("y")){
				try {					
				    Item item = ScanInput();//				    
				    double totalTax = item.calculateTax();
				    System.out.println(" Item Name : "+ item.itemName+"\n Item Price : " + item.price*item.quantity + "\n Sales Tax liability per item : " + totalTax+ " \n Final price : "+ (item.price+totalTax)*item.quantity);
				    System.out.println("Do you want to enter details of any other item (y/n) : ");
				    repeat = scanner.nextLine();	
				}catch(Exception e) {
					System.out.println("Please check the input!");
					System.out.println("Do you want to enter details of any other item (y/n) : ");
				    repeat = scanner.nextLine();	
					continue;
				}
			}
			System.out.println("Thankyou!");
	 
		}
	}

