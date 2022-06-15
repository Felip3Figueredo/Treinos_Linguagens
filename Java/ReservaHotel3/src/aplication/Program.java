package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int number = sc.nextInt();
			System.out.print("Data Check - in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data Check - out: ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservaton " + reservation);
			System.out.println();
		
			System.out.println("Digite a data de atualização de reserva: ");
			System.out.print("Data check - in: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data check - out: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservaton " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Formato de data invalido.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		sc.close();
	}

}
