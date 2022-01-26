package utility;



import model.Cinema;

import java.util.Arrays;

public class CinemaList {

    private static String dotted = "---------------------------------------------------------";
    private Cinema[] Cinemas;
    int index = 0;
    public CinemaList(){
        Cinemas =new Cinema[]{};

    }

    public Cinema[] getCinemas() {
        return Cinemas;
    }

    public int getSumUnit(){
        int sum = 0;
        for (Cinema item:Cinemas) {
        //    sum += item.getUnit();
        }
        return sum;
    }
    public boolean add(Cinema element) {
        int length = Cinemas.length;
        Cinemas = Arrays.copyOf(Cinemas, length + 1);
        Cinemas[length] = element;
        return true;
    }
    public Cinema get(int id){
        for (Cinema item: Cinemas ) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return Cinemas.length == 0;
    }
    public int size(){
        return Cinemas.length;
    }


    public void clear()
    {
        Cinemas =new Cinema[]{};
    }
//    public void edit(int id,String name,int unit){
//        get(id).setName(name);
//        get(id).setUnit(unit);
//    }
    public void add(int index, Cinema element){
        int length = Cinemas.length;
        Cinemas = Arrays.copyOf(Cinemas, length + 1);
        for (int i = Cinemas.length - 1; i > index; i--) {
            Cinemas[i] = Cinemas[i - 1];
        }
        Cinemas[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i <Cinemas.length ; i++) {
            if(Cinemas[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private  void removeByIndex(int index)
    {

        if(Cinemas.length > 0 && index <= Cinemas.length-1) {
            for (int arrayIndex = index; arrayIndex < Cinemas.length - 1; arrayIndex++) {
                Cinemas[arrayIndex] = Cinemas[arrayIndex + 1];
            }
            Cinemas = Arrays.copyOf(Cinemas, Cinemas.length - 1);
        }
    }

    public void addAll(Cinema[] Cinema){
        for (Cinema item: Cinema) {
            add(item);
        }
    }
//    public void showCinemaComplete()
//    {
//        System.out.println("id    ||  Cinema name  ||  unit ||  score  ||");
//        for (Cinema Cinema:Cinemas) {
//            System.out.println( Cinema.getId()+ "\t\t\t"+ Cinema.getName() +"\t\t\t\t"+    Cinema.getUnit()+"\t\t\t"+   Cinema.getScore());
//        }
//    }
    public void show(){
        System.out.println(" id  ||  Cinema name  ||  is active");
        for (Cinema cin: Cinemas) {
            if(cin != null) {
                System.out.println(cin);
            }
        }
        System.out.println(dotted);
    }

    public boolean contains(Cinema Cinema)
    {


        for (Cinema item: Cinemas) {
            if(item != null) {
                if (item.getId() == Cinema.getId()) {

                   return true;
                }
            }
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(Cinemas)
//                ;
//    }

}
