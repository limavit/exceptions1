package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Data de check in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Date de check out: ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Entre com os dados atualizados da reserva: ");
			System.out.print("Check in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check out: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reserva: " + reservation);
		
		}
		catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Formato de data inválido.");
		}
		catch (DomainException e) {
			// TODO: handle exception
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro genérico, favor entrar em contato com o administrador do sistema.");
		}
		
		
		sc.close();

	}

}
