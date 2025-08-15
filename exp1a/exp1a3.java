abstract class Bank{
    public abstract double interest(double time, double principal);
}

class SBI extends Bank{
    @Override
    public double interest(double time, double principal){
        return principal*time*0.05;
    }
}

class PNB extends Bank{
    @Override
    public double interest(double time, double principal){
        return principal*time*0.07;
    }
}   

public class exp1a3{
    public static void main(String[] args) {
        PNB pnb = new PNB();
        SBI sbi = new SBI();
        System.out.println("Principal: 10000, Time: 6 years, Bank: SBI, Interest: " + sbi.interest(6,10000));
        System.out.println("Principal: 5000, Time: 4 years, Bank: PNB, Interest: " + pnb.interest(4,5000));
    }
}