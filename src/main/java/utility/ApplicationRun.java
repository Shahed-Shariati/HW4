package utility;

import controler.CinemaController;
import controler.LoginController;
import controler.MovieController;
import controler.UserController;
import model.User;
import repository.UserRepository;

import java.util.Scanner;

public class ApplicationRun {
private Scanner input = new Scanner(System.in);
private LoginController loginController = new LoginController();
private User user;





public void runApplication(){

    while (true){
        Menu.loginMenu();
        System.out.println("choice login or sing up");
        String input = getUserInput().trim();
   //--------------------------------------------------------------- Login -----------------------------------------------------------------
        if(input.equalsIgnoreCase("1")){
           System.out.println("Enter user name and password");

           String[] username = getUserInput().trim().split(" +");

           user = UserRepository.login(username[0],username[1]);

           if(user == null){
               System.out.println("user name or password is wrong");
           }else {
               System.out.println("----------------------------------"+user.getFirstName()+" is login "+"--------------------------------------");
               while (true) {

   //-----------------------------------------------------------------admin menu----------------------------------------------------------
                   if (user != null && user.getRoleId() == 1) {
                       Menu.adminMenu();
                       //  System.out.println("enter (back) to return back menu");
                       String inputAdmin = getUserInput().trim();
                       if (inputAdmin.equalsIgnoreCase("1")) {
                           CinemaController.showCinemaList();
                       } else if (inputAdmin.equalsIgnoreCase("2")) {
                           CinemaController.showCinemaList();
                           System.out.println("choice id cinema for authentication");
                           String input1 = getUserInput().trim();
                           System.out.println("enter active or inactive(active/inactive)");
                           String active = getUserInput().trim();
                           CinemaController.authenticationCinema(input1,active);
                       } else if (inputAdmin.equalsIgnoreCase("3")) {
                           break;
                       } else {
                           System.out.println("wrong choic");
                       }



    //--------------------------------------------------------------------cinema menu----------------------------------------------------------------------
                   } else if (user != null && user.getRoleId() == 3) {
                      Menu.cinemaMenu();
                      String inputCinema = getUserInput().trim();
                      if(inputCinema.equals("1")){
                          MovieController.showMovieList();
                      }else if(inputCinema.equals("2")){
                          if(CinemaController.checkAuthenticationAccount(user)) {

                                  System.out.println("Enter information movie:\n"
                                          + "moviename time type\n"
                                          + "enter 'back' to return menu\n"
                                          + "(Example:squadGame 2 action)");
                                  String[] inputMovie = getUserInput().trim().split(" +");

                                  if (inputMovie[0].equalsIgnoreCase("back")) {
                                      System.out.println();
                                  } else if (inputMovie.length < 3) {
                                      System.out.println("Wrong input");
                                  } else {
                                      try{
                                          CinemaController.addMovieToList(inputMovie[0], inputMovie[1], inputMovie[2]);
                                      }catch (NumberFormatException e){
                                          System.out.println("Time is wrong");
                                      }

                                  }

                          }
                          else {
                              System.out.println(" ------------------your account is not Authentication --------------------------");
                          }
                      }else if(inputCinema.equals("3")){
                          if(CinemaController.checkAuthenticationAccount(user)) {
                              MovieController.showMovieList();
                              System.out.println("select id movie to add scene:(Enter back to return main menu)");
                              String[] movieId = getUserInput().trim().split(" +");
                              if(movieId[0].equalsIgnoreCase("back")){
                                  System.out.println();
                              }else  {
                                  System.out.println("Enter date and time and count ticket:\n(Example: 2021-1-4 21:00 20)");
                                  String[] dateTime = getUserInput().trim().split(" +");
                                  if(dateTime.length == 3) {
                                      try {
                                          CinemaController.addScene(user.getId(), movieId[0], dateTime[0], dateTime[1], dateTime[2]);
                                          System.out.println("------------------------success-------------------  ");
                                      }catch (NumberFormatException e){
                                          System.out.println("time is wrong");
                                      }
                                  }else {
                                      System.out.println("Wrong input");
                                  }
                              }
                          }else {
                              System.out.println(" ------------------your account is not Authentication --------------------------");
                          }
                      }else if(inputCinema.equals("4")) {
                          if(CinemaController.checkAuthenticationAccount(user)) {
                              String idUser = String.valueOf(user.getId());
                              CinemaController.showTicketList(idUser);
                              System.out.println("Enter id ticket to delete \n" +
                                      "(Enter back to return main menu)");
                              String ticketId = getUserInput().trim();
                              if (ticketId.equalsIgnoreCase("back")) {
                                  System.out.println();
                              } else {
                                  try{
                                  CinemaController.deleteTicket(ticketId);

                                  }catch (NumberFormatException e){
                                      System.out.println("Id is wrong");
                                  }
                              }
                          }else {
                              System.out.println(" ------------------your account is not Authentication --------------------------");
                          }
                      }else if(inputCinema.equals("5")){
                              String cinemaId = String.valueOf(user.getId());
                              UserController.cinemaProfit(cinemaId);
                      }else if(inputCinema.equals("6")){
                       break;
                      }else {
                          System.out.println("your choice is wrong");
                      }
//-------------------------------------------------------user menu-----------------------------------------------------------------------------------------------------
                   } else if(user != null && user.getRoleId() == 2){
                         Menu.userMenu();
                       System.out.println("choice ");
                         String userInput = getUserInput().trim();
                         if (userInput.equals("1")){
                             UserController.showCinemaMovie();
                         }else if(userInput.equals("2")){
                            UserController.showCinemaMovie();
                             System.out.println("Choice id :\n (Enter back to return main menu:)");
                             String reserveTicketID = getUserInput().trim();
                             if(reserveTicketID.equalsIgnoreCase("back")){
                                 System.out.println();
                             }else {
                                 try {
                                     System.out.println("Enter ticket count:");
                                     String ticketCount = getUserInput().trim();
                                     UserController.reserveTicket(user,reserveTicketID,ticketCount);
                                 }catch (NumberFormatException e){
                                     System.out.println(" id or number ticket is wrong");
                                 }

                             }
                         }else if(userInput.equals("3")){
                             System.out.println("Enter movie date for search:\n(Enter back to return main menu:)");
                             String movieDate = getUserInput().trim();
                             if(movieDate.equalsIgnoreCase("back")){
                                 System.out.println();
                             }else {
                                 try {
                                     UserController.searchByDateMovie(movieDate);
                                 }catch (IllegalArgumentException e){
                                     System.out.println("your date is wrong");
                                 }
                             }
                         }else if (userInput.equals("4")){
                             System.out.println("Enter movie name for search:\n(Enter back to return main menu:)");
                             String movieName = getUserInput().trim();
                             if(movieName.equalsIgnoreCase("back")){
                                 System.out.println();
                             }else {
                                 UserController.searchByNameMovie(movieName);
                             }

                         }else
                             if(userInput.equals("5")){
                             break;
                         }else {
                             System.out.println("wrong choice");
                         }
                   }else
                       if (username == null) {
                       System.out.println("username or password is wrong:");
                   }
               }
           }
      //------------------------------------------------------------------Sing up--------------------------------------------------------------------------
        }else if (input.equalsIgnoreCase("2")){
            System.out.println("Enter your information to sing up");
             Menu.singUpMenu();
            System.out.println("Choice account type:");
            String singUpInput = getUserInput().trim();
            if(singUpInput.equalsIgnoreCase("1")){
                System.out.println("Enter cinema_name username password\n" +
                        "                 (Example: RexAbadan user pass) ");
               String[] singUpInput1 = getUserInput().trim().split(" +");
                UserController.singUp("3",singUpInput1[0],singUpInput1[1],singUpInput1[2],"0");
            }else if(singUpInput.equalsIgnoreCase("2")){
                System.out.println("Enter Firstname  Lastname  address Username Password");
                String[] singUpInput2 = getUserInput().trim().split(" +");
                UserController.singUp("2",singUpInput2[0],singUpInput2[1],singUpInput2[2],singUpInput2[3],singUpInput2[4],"0");
            }else if(singUpInput.equalsIgnoreCase("back")){
                System.out.println();
            }
        }else if(input.equalsIgnoreCase("3")){
            break;
        }

    }
}

    private String getUserInput()
    {
        return input.nextLine();
    }

}

