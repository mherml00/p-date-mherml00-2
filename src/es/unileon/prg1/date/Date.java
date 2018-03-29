package es.unileon.prg1.date;

import java.util.*;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 2018;
	}

	// Constructor mal programado: Permite crear fechas no validas
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(Date another) {
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}
	
	public int getYear(){
		return this.year;
	}

	boolean isSameIf(Date another) {
		if (this.isSameYear(another) && this.isSameMonth(another) && this.isSameDay(another)) {
			return true;
		}
		return false;
	}

	boolean isSameDayIf(Date another) {
		if (this.day == another.getDay()){
			return true;
		}
		return false;
	}

	boolean isSameMonthIf(Date another) {
		if (this.month == another.getMonth()){
			return true;
		}
		return false;
	}

	boolean isSameYearIf(Date another){
		if (this.year == another.getYear()){
			return true;
		}
		return false;
	}

	boolean isSame(Date another) {
		return (this.isSameYear(another) && this.isSameMonth(another) && this.isSameDay(another));
	}

	boolean isSameDay(Date another) {
		return (this.day == another.getDay());
	}

	boolean isSameMonth(Date another) {
		return (this.month == another.getMonth());
	}

	boolean isSameYear(Date another){
		return (this.year == another.getYear());
	}

	void getMonthName() {
		switch(this.month) {
			case 1:
				System.out.println("January");
				break;
			case 2:
				System.out.println("February");
				break;
			case 3:
				System.out.println("March");
				break;
			case 4:
				System.out.println("April");
				break;
			case 5:
				System.out.println("May");
				break;
			case 6:
				System.out.println("June");
				break;
			case 7:
				System.out.println("July");
				break;
			case 8:
				System.out.println("August");
				break;
			case 9:
				System.out.println("September");
				break;
			case 10:
				System.out.println("October");
				break;
			case 11:
				System.out.println("November");
				break;
			case 12:
				System.out.println("December");
				break;
		}
	}

	boolean isDayRight() {
		boolean right = false;
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (this.day >= 1 && this.day < 32) {
					right = true;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (this.day >= 1 && this.day < 31) {
					right = true;
				}
				break;
			case 2:
				if (this.day >= 1 && this.day < 29) {
					right = true;
				}
				break;
		}
		return right; 
	}

	void getSeasonName() {
		if (this.month == 3 || this.month == 4 || this.month == 5) {
			System.out.println("Primavera");
		} else if (this.month == 6 || this.month == 7 || this.month == 8) {
			System.out.println("Verano");
		} else if (this.month == 9 || this.month == 10 || this.month == 11) {
			System.out.println("Otoño");
		} else {
			System.out.println("Invierno");
		}
	}

	void getMonthsLeft() {
		int monthsLeft = 12 - this.month;
		System.out.println(monthsLeft	);
	}
	
	void getDaysLeftOfMonth() {
		int daysLeft = 0;
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysLeft = 31 - this.day;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysLeft = 30 - this.day;
				break;
			case 2:
				daysLeft = 28 - this.day;
				break;
		}
		System.out.println(daysLeft);
	}

	void getMonthsSameDays() {
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("Abril, Junio, Septiembre y Noviembre");
				break;
			case 2:
				System.out.println("Febrero");
				break;
		}
	}

	int daysPast() {
		int days = 0;
		for (int i = 1; i < this.month; i++) {
			switch(i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days += 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days += 30;
				break;
			case 2:
				days += 28;
				break;	
			}
		}
		days += this.day;
		return days;
	}	
	
	//con while
	int numRandomTriesEqualDate1() {
		int dia = -1, mes = -1;
		int intentos = 0;
		while(dia != this.day && mes != this.month) {
			dia = (int) (Math.random()*30+1);
			mes = (int) (Math.random()*11+1);
			//System.out.println(dia);
			//System.out.println(mes);
			intentos++;
		}
		return intentos;
	}

	//con do-while
	int numRandomTriesEqualDate2() {
		int dia = -1, mes = -1;
		int intentos = 0;
		do {
			dia = (int) (Math.random()*30+1);
			mes = (int) (Math.random()*11+1);
			//System.out.println(dia);
			//System.out.println(mes);
			intentos++;
		} while(dia != this.day && mes != this.month);
		return intentos;
	}

	void dayOfWeek() {
		//Partimos de que el 1 del 1 de 2018 fue lunes
		int dias = this.daysPast();
		int resto = dias%7;
		switch(resto) {
			case 1:
				System.out.println("Lunes");
				break;
			case 2:
				System.out.println("Martes");
				break;
			case 3:
				System.out.println("Miercoles");
				break;
			case 4:
				System.out.println("Jueves");
				break;
			case 5:
				System.out.println("Viernes");
				break;
			case 6:
				System.out.println("Sabado");
				break;
			case 0:
				System.out.println("Domingo");
				break;
		}
	}

	Date tomorrow() {
		Date tomorrow = new Date();
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				if (this.day == 31) {
					tomorrow = new Date(1, this.month+1, this.year);
				} else {
					tomorrow = new Date(this.day+1, this.month, this.year);
				}
				break;
			case 12:
				if (this.day == 31) {
					tomorrow = new Date(1, 1, this.year+1);
				} else {
					tomorrow = new Date(1, this.month+1, this.year);
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (this.day == 30) {
					tomorrow = new Date(1, this.month+1, this.year);
				} else {
					tomorrow = new Date(this.day+1, this.month, this.year);
				}
				break;
			case 2:
				if (this.day == 28) {
					tomorrow = new Date(1, this.month+1, this.year);
				} else {
					tomorrow = new Date(this.day+1, this.month, this.year);
				}
				break;	
			}
			return tomorrow;
	}

	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}

}
