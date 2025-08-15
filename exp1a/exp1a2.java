interface Payment {
    public double processpayment(double amount);
}

class CreditCard implements Payment {

    public double processpayment(double amount) {
        return amount;
    }
}

class DebitCard implements Payment {

    public double processpayment(double amount) {
        return amount;
    }
}

class UPI implements Payment {
 
    public double processpayment(double amount) {
        return amount;
    }
}

public class exp1a2 {
    public static void main(String args[]) {
        CreditCard cre = new CreditCard();
        DebitCard deb = new DebitCard();
        UPI upi = new UPI();

        System.out.println("CreditCard Amount: " + cre.processpayment(500.7));
        System.out.println("DebitCard Amount: " + deb.processpayment(4000.1));
        System.out.println("UPI Amount: " + upi.processpayment(777.8));
    }
}
