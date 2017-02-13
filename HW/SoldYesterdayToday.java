package HW;

public class SoldYesterdayToday {

	public static void main(String[] args) {
		int salesTrend = 0;
		int soldYesterday = 10;
		int soldToday = 10;

		if (soldYesterday > soldToday) {
			salesTrend = -1;
		} else if (soldYesterday < soldToday) {
			salesTrend = 1;
		}
		
		System.out.println(salesTrend);

	}

}
