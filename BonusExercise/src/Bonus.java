
class Bonus
{ 

static String dayResult;
static String monthResult;

static boolean isLeap(int year) 
{  
	return (((year % 4 == 0) 
			&& (year % 100 != 0)) 
			|| (year % 400 == 0)); 
} 

static boolean isValidDate(int day, int month, int year) 
{ 
	if (month < 1 || month > 12) 
		return false; 
	if (day < 1 || day > 31) 
		return false; 

	if (month == 2) 
	{ 
		if (isLeap(year)) 
			return (day <= 29); 
		else
			return (day <= 28); 
	} 
 
	if (month == 4 || month == 6 || month == 9 || month == 11) 
		return (day <= 30); 

	return true; 
} 

static void printBonusDatesBetween(int fromYear, int toYear) 
{ 

	for (int year = fromYear; year <= toYear; year++) 
	{ 
		String str = String.valueOf(year); 
		String rev = str; 
		rev = reverse(rev); 

		int day = Integer.parseInt(rev.substring(2, 4)); 
		int month = Integer.parseInt(rev.substring(0,2));

		if (isValidDate(day, month, year)) 
		{ 
			if(Integer.toString(day).length() == 1) {
				dayResult = "0" + Integer.toString(day);
			}else {
				dayResult = Integer.toString(day);
			}
			if(Integer.toString(month).length() == 1) {
				monthResult = "0" + Integer.toString(month);
			}else {
				monthResult = Integer.toString(month);
			}
			System.out.println(year+ "-" + monthResult+ "-" + dayResult);
		} 
	} 
} 

static String reverse(String input) 
{ 
	String reversed = new StringBuilder(input).reverse().toString();
	
	return reversed;
	} 	
} 


