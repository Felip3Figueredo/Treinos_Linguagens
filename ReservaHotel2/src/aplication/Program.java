package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data Check - in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data Check - out: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro, data de checkout posterior a data de checkin.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservaton " + reservation);
			System.out.println();

			System.out.println("Digite a data de atualização de reserva: ");
			System.out.print("Data check - in: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data check - out: ");
			checkOut = sdf.parse(sc.next());

			String erro = reservation.updateDates(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva : " + erro);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();
	}

}
