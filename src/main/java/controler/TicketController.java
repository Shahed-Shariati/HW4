package controler;

import repository.TicketRepository;
import utility.TicketList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class TicketController {
    private static TicketList ticketList = new TicketList();

    public static void reserveTicket(String idUser,String idCinemaMovie,String ticketCount)
    {
        int idUserInt = Integer.parseInt(idUser);
        int idTicket = Integer.parseInt(idCinemaMovie);
        int index = Integer.parseInt(ticketCount);
        for (int i = 0; i < index ; i++) {
            TicketRepository.reserveTicket(idTicket,idUserInt);
        }
         int count = countTicketSell(idTicket);
         CinemaMovieController.setSell(idTicket,count);

    }

    private static int getIdCinemaMovie(int idTicket){
        return TicketRepository.getIdCinemaMovie(idTicket);
    }
    public static void deleteTicket(String idTicket)
    {
        int id = Integer.parseInt(idTicket);
        String[] dateStr =  TicketRepository.getTicketDateAndTime(id);
        if(dateStr[0] != null) {
            LocalDate localDate = LocalDate.now();
            String timeStr = new SimpleDateFormat("HH:mm:").format(Calendar.getInstance().getTime());
            Date dateSql = null;
            Date timeSql = null;
            Date timeNow = null;
            Date today = null;
            try {
                today = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
                dateSql = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr[0]);
                timeSql = new SimpleDateFormat("HH:mm").parse(dateStr[1]);
                timeNow = new SimpleDateFormat("HH:mm").parse(timeStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

//            if ( (dateSql.after(today) || dateSql.equals(today)) && (timeSql.after(timeNow)|| timeSql.equals(timeNow))) {
//                int count = countTicketSell(getIdCinemaMovie(id));
//                CinemaMovieController.setSell(getIdCinemaMovie(id),count-1);
//                TicketRepository.deleteTicket(id);
//
             if(dateSql.after(today)){
               int count = countTicketSell(getIdCinemaMovie(id));
               CinemaMovieController.setSell(getIdCinemaMovie(id),count-1);
               TicketRepository.deleteTicket(id);
             }else if(dateSql.equals(today) && timeSql.before(timeNow)){
                 int count = countTicketSell(getIdCinemaMovie(id));
                 CinemaMovieController.setSell(getIdCinemaMovie(id),count-1);
                 TicketRepository.deleteTicket(id);


            } else {
                System.out.println("---------------------------------- cant delete ticket------------------------- ");

            }
        }else {
            System.out.println("-----------------------Ticket not find---------------------------------");
        }
    }

    public static void showTicketList(String cinemaId){
         ticketList.clear();
         int id = Integer.parseInt(cinemaId);
         ticketList = TicketRepository.getTicketList(id);

         ticketList.show();
    }


    private static int countTicketSell(int id)
    {
      return   TicketRepository.countTicketSell(id);
    }
}
