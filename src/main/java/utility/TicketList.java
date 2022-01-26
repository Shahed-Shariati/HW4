package utility;



import model.Ticket;

import java.util.Arrays;

public class TicketList {


    private Ticket[] Tickets;
    int index = 0;
    public TicketList(){
        Tickets =new Ticket[]{};

    }

    public Ticket[] getTickets() {
        return Tickets;
    }

    public int getSumUnit(){
        int sum = 0;
        for (Ticket item:Tickets) {
        //    sum += item.getUnit();
        }
        return sum;
    }
    public boolean add(Ticket element) {
        int length = Tickets.length;
        Tickets = Arrays.copyOf(Tickets, length + 1);
        Tickets[length] = element;
        return true;
    }
    public Ticket get(int id){
        for (Ticket item: Tickets ) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return Tickets.length == 0;
    }
    public int size(){
        return Tickets.length;
    }


    public void clear()
    {
        Tickets =new Ticket[]{};
    }
//    public void edit(int id,String name,int unit){
//        get(id).setName(name);
//        get(id).setUnit(unit);
//    }
    public void add(int index, Ticket element){
        int length = Tickets.length;
        Tickets = Arrays.copyOf(Tickets, length + 1);
        for (int i = Tickets.length - 1; i > index; i--) {
            Tickets[i] = Tickets[i - 1];
        }
        Tickets[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i <Tickets.length ; i++) {
            if(Tickets[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private  void removeByIndex(int index)
    {

        if(Tickets.length > 0 && index <= Tickets.length-1) {
            for (int arrayIndex = index; arrayIndex < Tickets.length - 1; arrayIndex++) {
                Tickets[arrayIndex] = Tickets[arrayIndex + 1];
            }
            Tickets = Arrays.copyOf(Tickets, Tickets.length - 1);
        }
    }

    public void addAll(Ticket[] Ticket){
        for (Ticket item: Ticket) {
            add(item);
        }
    }
//    public void showTicketComplete()
//    {
//        System.out.println("id    ||  Ticket name  ||  unit ||  score  ||");
//        for (Ticket Ticket:Tickets) {
//            System.out.println( Ticket.getId()+ "\t\t\t"+ Ticket.getName() +"\t\t\t\t"+    Ticket.getUnit()+"\t\t\t"+   Ticket.getScore());
//        }
//    }
    public void show(){
        System.out.println("id  ||   Cinema name   ||   Filme Name   ||        date      ||        time       ");
        for (Ticket Ticket: Tickets) {
            System.out.println(Ticket);
        }
    }

    public boolean contains(Ticket Ticket)
    {


        for (Ticket item: Tickets) {
            if(item != null) {
                if (item.getId() == Ticket.getId()) {

                   return true;
                }
            }
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(Tickets)
//                ;
//    }

}
