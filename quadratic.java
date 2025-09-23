import java.util.Scanner;
class quadratic{
    public static void main(String[] args)
    {
        Scanner s= new Scanner(System.in);
        float d,a,b,c;
        double r1,r2;
        System.out.println("Enter the coefficient of a ,b and c");
        a= s.nextFloat();
        b=s.nextFloat();
        c=s.nextFloat();
        d= b*b -4*a*c;
        if (a==0){
            System.out.println("not a quadratic equation");
            System.out.println("REESAV SUBEDI 1BF24cs248");
        }
        else{
        if (d==0){
            r1=(-b)/(2*a);
            System.out.println("Roots are real and equal "+r1);
        }
        else if (d>0){
            r1=((-b)+ (Math.sqrt(d)))/(double)(2*a); 
            r2=((-b)-(Math.sqrt(d)))/(double)(2*a);
            System.out.println("real and distinct"+r1);
            System.out.println(+r2);
        }
        else
        {
            r1= (-b)/(2*a);
            r2= Math.sqrt(-1*d)/(2*a);
            System.out.println("roots are imaginary"+r1+r2);
        }
    }
        
    }
}
