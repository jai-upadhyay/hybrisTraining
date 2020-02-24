package Assignment1;

public class Item {
	 String itemName;
     double price;
     int quantity;
     ItemType type;

     public Item(String itemName, double price, int quantity, ItemType type){
         this.itemName = itemName;
         this.price = price;
         this.quantity = quantity;
         this.type = type;  
     }

     double calculateTax(){
         double totalTax = 0;         
         switch(this.type) {
         case RAW:
        	 totalTax = this.price * (0.125);
        	 break;
         case MANUFACTURED:
        	  totalTax = ((0.125) * this.price)  + ((0.02)*(1+0.125)*this.price) ;    
        	 break;
         case IMPORTED:
        	 totalTax = ((0.10)*this.price);
             if(this.price + totalTax <= 100){
                 totalTax += 5;
             }else if(this.price + totalTax <= 200){
                 totalTax += 10;
             }else{
                 totalTax += (totalTax + this.price) * (0.05);
             }
        	 break;
        	 default:
        		 return -1;
         }         
         return totalTax;
     }
}
