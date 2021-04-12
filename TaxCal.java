public class TaxCal{
	static float income;
	static float Couplet(float wIncome, float hIncome) {
            float married = 264000;
            float mpfIncome = Mpf(wIncome)+ Mpf(hIncome);
            mpfIncome -= married;
            float stax = StanTax(mpfIncome+264000);
            float ptax = ProTax(mpfIncome);
            if (stax < ptax)
            {
                if (stax <= 0)
                    return 0;
                return stax;
            }
            else
            {
                if (ptax <= 0)
                    return 0;
                return ptax;
            }
		 }
		 static float Single(float income){
            float married = 132000;
            float mpfIncome = Mpf(income);
            mpfIncome -= married;
            float stax = StanTax(mpfIncome+ 132000);
            float ptax = ProTax(mpfIncome);
            if (stax < ptax)
            {
                if (stax <= 0)
                    return 0;
                return stax;
            }
            else
            {
                if (ptax <= 0)
                    return 0;
                return ptax;
            }
        }
		static float StanTax(float income){
            float tax;
            tax = income * 0.15f;
            return tax;
        }
		 static float ProTax(float income){
            float tax;

            if (income>=200000) 
            {
                tax = 16000;
                income -= 200000;
                tax += income * 0.17f;
                return tax;
            }
            else if(income > 150000)
            {
                tax = 9000;
                income -= 150000;
                tax += income *= 0.14f;
                return tax;
            }
            else if (income > 100000)
            {
                tax = 4000;
                income -= 100000;
                tax += income *= 0.10f;
                return tax;
            }
            else if (income > 50000)
            {
                tax = 1000;
                income -= 50000;
                tax += income *= 0.06f;
                return tax;
            }
            else
            {
                tax = 0;
                tax += income *= 0.02f;
                return tax;
            }           
        }
		static float Mpf(float income){
            float x;
            income /= 12;
            if (income < 7100)
            {
                return income * 12;
            }
            else if (income < 30000)
            {
                x = income * 0.05f;
                return (income - x) * 12;
            }
            else {
                return (income - 1500) * 12;
            }
        }
	
	public static void main (String args[]){
		 while (true){
			  float stax;
              float ptax;
              float tax;
              float mpfIncome;
              float married;
              float hIncome;
              float wIncome;
			  
			  System.out.println("Are you married? yes = 1, no = 2");
			  
			  String input = System.console().readLine();

			  int i = Integer.parseInt(input);  
			  if (i == 1){
					married = 264000;
                    System.out.println("Input your self salary!");
					input = System.console().readLine();
					wIncome = Float.parseFloat(input);
                    System.out.println("Input your spouse salary!");
					input = System.console().readLine();
					hIncome = Float.parseFloat(input);
                    float sinTax = Single(wIncome) + Single(hIncome);
                    tax = Couplet(wIncome, hIncome);
                    if (tax <= sinTax)
                    {
                        System.out.println("Your tax: " + Float.toString(tax));
                    }
                    else
                    {
                       System.out.println("Your tax and you shold divorce: " + Float.toString(sinTax));
                    }
			  }
			  else{
					System.out.println("Input your total salary!");
                    int intTemp = Integer.parseInt(System.console().readLine());
                    income = (float)intTemp;
                    tax = Single(income);

                    System.out.println("Your stax: " + Float.toString(tax));
			  }
		 }	
	}
}