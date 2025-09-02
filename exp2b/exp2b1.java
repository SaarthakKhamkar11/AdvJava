import java.util.*;

interface waiting{
    public void takeorder();
}

interface cooking{
    public void preparemeal();
}

interface getpaid{
    public void processpayment();
}

class Waiter implements waiting{
    @Override
    public void takeorder(){
        System.out.println("Waiter is taking an order of a customer.");
    }
}

class Chef implements cooking{
    @Override
    public void preparemeal(){
        System.out.println("Chef is preparing an order of a customer.");
    }
}

class Cashier implements getpaid{
    @Override
    public void processpayment(){
        System.out.println("Cashier is handling the cheque of a customer.");
    }
}

public class exp2b1{
    public static void main (String[] args){
        waiting waiter = new Waiter();
        cooking chef = new Chef();
        getpaid cashier = new Cashier();

        waiter.takeorder();
        chef.preparemeal();
        cashier.processpayment();
    }
}