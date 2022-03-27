package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
	static Scanner scan = new Scanner(System.in);
	
	public static String regexStr(String temp, String regex, String error) {
		boolean check = true;
		do {
			if(temp.matches(regex)) {
				check = false;
			} else {
				System.out.println(error);
				temp = scan.nextLine();
			}
		} while (check);
		return temp;
	}
	
	public static String regexAge(String temp, String regex) {
		boolean check = true;
		while(check) {
			try {
				if(Pattern.matches(regex, temp)) {
					DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate age = LocalDate.parse(temp, formater);
					LocalDate now = LocalDate.now();
					int current = Period.between(age, now).getYears();
					if(current<100 && current>18) {
						check = false;
					} else {
						throw new AgeException("Age must greater than 18 and less than 100");
					}
				} else {
					throw new AgeException("Invalid formatter, date of birth must in form dd/mm/yyyy!");
				}
			} catch (AgeException e) {
				System.out.println(e.getMessage());
				temp = scan.nextLine();
			}
		}
		return temp;
	}
}
