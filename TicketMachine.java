/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // para facilitar máquina con premio
    private boolean conPremio;
    //para indicar el nº máximo de billetes que puede crear la máquina
    private int maxBilletes;
    // para contar los billetes que ha creado la máquina.
    private int contBilletes;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean maquinaNormal, int maxBilletes)
    {
        price = cost;
        balance = 0;
        total = 0;
        conPremio = maquinaNormal;
        this.maxBilletes = maxBilletes;
        contBilletes = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
        contBilletes = contBilletes + 1;
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(contBilletes > maxBilletes ){
            System.out.println("Error,  la máquina no dispone de más billetes.");
        }
        else{

            if(balance >= price && conPremio == true) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
            else if(balance >= price && conPremio == false) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                System.out.println("******************************************");
                System.out.println("##################");
                System.out.println("# Ticket");
                System.out.println("# BILLETE DE REGALO. !!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("##################");
                System.out.println();
            }
            else {
                System.out.println("You must insert at least: " +
                    (price - balance) + " more cents.");

            }
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * 0745  método llamado emptyMachine que al invocarlo vacíe la máquina de todas las monedas que hay en 
     * ella y que devuelva la cantidad de dinero que había en la máquina.
     */
    public int emptyMachine(){
        int recaudacion = -1;
        if(refundBalance() == 0){

            recaudacion = recaudacion + total;  
            total = 0;
        }
        return recaudacion;
    }
}











