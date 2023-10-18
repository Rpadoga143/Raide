import java.util.Scanner;


class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
   
    String ticket, day,date;
    int x = 0;
    int y = 10;
    int time;
    
    double P_RICE;
    double price1 = 320.78;
    double price2 = 290.78;
    double price3 = 290.65;
    double price4 = 275.35;
    double price5 = 260.45;
  
        
    
    System.out.print("Do you want to get a Ticket? Y / N? "); 
    ticket = myObj.nextLine();
   
    while(!ticket.equals("Y")){
    return; 
    }
    
       
    
    if (ticket.equals("Y")) {
    System.out.print("Enter the Day:");
    day = myObj.nextLine();
    System.out.println(day.toUpperCase());

    if (day.equals("sunday")) {
    
    System.out.print("Your ticket price is Php " + price1 );

    day = myObj.nextLine();
        
    }
    else if(day.equals("friday")){
  
    System.out.println("Friday-Saturday:\n60Php 290.65 for children under 13");
    System.out.println("Php 275.35 for seniors 60 and older" );
    System.out.println("Php 290.78 for adults before 5:00pm" );
    System.out.println("Php 380.35 for adults after 5:00pm" );
    }
    
    
    
    else {
        System.out.println("Monday-Thursday: Php 290.65 before 5:00pm");
        System.out.println("Php 320.78 after 5:00pm");
           }
    }
    
    System.out.print("Enter age: ");
    int age = myObj.nextInt();
    System.out.print("Enter hours: ");
    int hours = myObj.nextInt();
    System.out.print("Enter minutes: ");
    int minutes = myObj.nextInt();
      
    if(age <= 13)
    { 
    System.out.print("Your ticket price is Php " + price3 );
    } 
         
    else if(age >= 60)
    { 
    System.out.print("Your ticket price is Php " + price4 );
    }
    else if(age <= 60)
    { 
    System.out.print("Your ticket price is Php " + price1 );
    }  
      else if(hours <= 17)
    { 
    System.out.print("Your ticket price is Php " + price2 );
    } 
    else{
    System.out.print("Your ticket price is Php " + price1 );
    }
       
    
   
     


        
     
     
     
     
     
     }
      
       }  
  

