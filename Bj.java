import java.util.Scanner;
import java.util.Random;

public class Bj {
    public static Scanner s =new Scanner(System.in);
    public static void main(String[] args) {

    boolean x=true;
    int aces=0;
    int daces=0;
    int zo=0;
    int hit=2;//Hit or Stand primitive
    int playerp=0;//Dealt card code (p)
    int playertp=0;//Total card points (p)
    int dealerp=0;//Dealt card code (d)
    int dealertp=0;//Sum of card codes
    int tencard=0;//Total card points (d)
    int scr=0;
    int c;
    String points="";
    String dcp="";
    String dc="";
    String answer;

        System.out.println("\n\t.::BlackJack::.");
        System.out.println("\n\t.:Ready to play?:.");

        while(x==true){
        System.out.println("\n\tPlease enter [yes] or [no]\n");
        answer=s.next();
        x=ans(answer);
        }
        s.nextLine();

        System.out.println("\n\t::The dealer will give you 2 cards::\n");
        
        for(c=0;c<2;c++){
            System.out.println("\t\t::Press enter::\n");
            s.nextLine();
            playerp=randy();
            playertp+=ten(playerp);
            if(ace(playerp,playertp)==true){//ACER
                playertp+=10;
                aces++;
            };
            
            if (c!=1){
                dcp=cardy(playerp);
            }else{
                System.out.println("\n::The cards in your hand::");
                points="\n\t\t["+playertp+"] points\n";
                dcp+=cardy(playerp);
            }
            System.out.println("\n"+dcp);
            System.out.println(points);
            
        } 
        
        System.out.println("\n::The dealer will draw 2 cards for himself::\n");
        for(c=0;c<2;c++){
            System.out.println("\t::Press enter::\n");
            s.nextLine();
            dealerp=randy();
            dealertp+=dealerp;
            tencard+=ten(dealerp);
            if(ace(dealerp,tencard)==true){
                tencard+=10;
                daces++;
            }
            
            if(c!=1){
                dc=cardy(dealerp);
                scr=dealerp;
            }else{
                System.out.println("\n::Dealer's cards::");
                if((ten(scr))==1){
                    dc+="\n\t\t[A+ ?] points\n";
                }else{
                    dc+="\n\t\t["+ten(scr)+"+ ?] points\n";
                }
                dc+=facedown();
            }
            System.out.println("\n"+dc);
        }
            // if((playertp>21)&&(dealertp>21)){
            //     System.out.println("\n\t::Both the dealer and you Busted -You win-::\n");
            //     System.exit(0);
            // }else if(playertp>21){
            // if(playertp>21){
            //     System.out.println("\n\t::BUSTED-You lose-::\n");
            //     System.exit(0);
            // }
            // }else if(dealertp>21){
            //     System.out.println("\n\t::Dealer Busted -You win-::\n");
            //     System.exit(0);
            // }


        while(hit==2){
             System.out.println("\n\t\t::[ HIT ] or [STAND]::\n");  
            answer=s.next();
            hit=ansG(answer);
            if(hit==0){
                zo=1;
                for(int no=0;no<zo;no++){

                  System.out.println("\tThe dealer will give u one more card\n");  
                  System.out.println("\t\t::Press enter::\n");
                  s.nextLine();
                    playerp=randy();
                    playertp+=ten(playerp);
                    if(ace(playerp,playertp)==true){//ACER
                        playertp+=10;
                        aces++;
                        
                    }else {
                        while((playertp>21)&&(aces>0)){//RACER
                            playertp-=10;
                            aces--;
                        }

                    };

                    points="\n\t\t["+playertp+"] points\n";
                    System.out.println("\t::Your cards are::\n");
                    dcp+=cardy(playerp);
                    System.out.println(dcp);
                    System.out.println(points);
                    if(playertp>21){
                        System.out.println("\n\t::BUSTED-You lose-::\n");
                        System.exit(0);
                    }
                }
            hit=2;
            }else if(hit==1){
               
                System.out.println("\n\t\t::Dealer revealed it's card::");
                dc=cardy(scr)+cardy(faceup(dealertp,scr));
                System.out.println("\n"+dc+"\n");
                System.out.println("\t\t["+tencard+"] points\n");
                s.nextLine();

                while(tencard<17){
                    System.out.println("\n\t::The dealer will now draw a card::");
                    System.out.println("\n\t::Press ENTER::\n");
                    s.nextLine();
                    dealerp=randy();
                    dealertp+=dealerp;
                    tencard+=ten(dealerp);
                    if(ace(dealerp,tencard)==true){
                        tencard+=10;
                        daces++;
                    }else{
                        while((tencard>21)&&(daces>0)){
                            tencard-=10;
                            daces--;
                        }
                    }
                    dc+=cardy(dealerp);
                    System.out.println("\n\t::The dealer's cards are::");
                    System.out.println("\n"+dc+"\n");
                    System.out.println("\n\t\t["+tencard+"] points\n");
                }
                if(tencard>21){
                    System.out.println("\n\t::Dealer BUSTED-You win-::\n");
                    System.exit(0);
                }
                break;
            }
        
        
        } 

        compa(playertp,tencard);

    s.close();
       
    }
 
    public static int randy(){
        Random n=new Random();
        int r=n.nextInt(13)+1;
        return r; 
    }

    public static String cardy(int n){
        switch (n){
            case 1:
            return
            "   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n";
            case 2:
            return
            "   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";
            case 3:
            return
            "   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            
            case 4:
            return 
            "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";  

            case 5:
            return 
            "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";

            case 6:
            return 
            "   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____9|\n";

            case 7:
            return
            "   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n"; 
            case 8:
            return 
            "   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";
            case 9:
            return
            "   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____6|\n";
            case 10:
            return
            "   _____ \n" +
            "  |I0  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___0I|\n";
            case 11:
            return
            "   _____\n" +
            "  |J  mm|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";
            case 12:
            return
            "   _____\n" +
            "  |Q  WW|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            case 13:
            return
            "   _____\n" +
            "  |K  MM|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n"; 

            default:
            return "Error";
        }
    }

    public static int ten(int playerp){
        if(playerp>10){
            return 10;
        }
        else return playerp;
    }

    public static boolean ace(int ace,int tc){
        int z=tc+10;
        boolean y=false;
        if(ace==1){
            if(z<=21){
                return y=true;
            }else{
                return y;
            }
            
        }
        return y;
    }

    public static String facedown(){
        return 
        "   _____\n" +
        "  |::x::|\n"+ 
        "  |xx:xx|\n"+ 
        "  |:x:x:|\n"+ 
        "  |xx:xx|\n"+ 
        "  |::x::|\n";
    }

    public static boolean ans(String answer){
        boolean x=true;
        if((answer.equalsIgnoreCase("yes"))){
            System.out.println("\n\t[o] Welcome to java BlackJack!\n");
            return x=false;
            
        }else if((answer.equalsIgnoreCase("no"))){
            System.out.println("\n\t[o] Verry well! Have a nice day!\n");
            System.exit(0);
        }else{

            return x;
        }
        return x;   
    }
    public static int ansG(String answer){
        int x=2;
        if((answer.equalsIgnoreCase("hit"))){
            System.out.println("\n\t\t[o] You chose to .HIT.\n");
            return x=0;
            
        }else if((answer.equalsIgnoreCase("stand"))){
            System.out.println("\n\t\t[o] You chose to .STAND.\n");
            return x=1;
        }else{
            return x;
        }
    }
    public static int faceup(int a,int b){
        int x=a-b;
        return x;
    }
    public static void compa(int p,int d){
        if(d>21){
            System.out.println("\n\t\t::Dealer BUSTED:: -You win-\n\n");
            System.exit(0);
        }else if(p>d){
            System.out.println("\n\t\t::You Win::\n\n");
            System.exit(0);
        }else if(p==d){
            System.out.println("\n\t\t::It's a PUSH::\n\n");
            System.exit(0);
        }else{
            System.out.println("\n\t\t::You Lost::\n\n");
            System.exit(0);
        }
    }
}
