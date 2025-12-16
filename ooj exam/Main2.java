class Fun{
    double area(int a){
        return 3.14*a*a;
    }
    double area(int a, int b){
        return 0.5*a*b;
    }

}
class Main2{
    public static void main(String[] args) {
        Fun F= new Fun();
        System.out.println("THe area of cirlce"+F.area(14));
        System.out.println("the area of trapezium"+F.area(10,15));
    }
}
 