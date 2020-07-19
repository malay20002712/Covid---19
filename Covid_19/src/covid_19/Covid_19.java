package covid_19;

import java.util.Scanner;

public class Covid_19 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String symptoms[]= {"Fever","Fatigue","Cough","Sneezing","Aches & pains"
							,"Runny or stuffy nose","Sore throat","Diarrhea","Headaches"
							,"Shortness of breath","Loss of taste/smell"
						   };
		int cov_19=0,flu=0,cold=0;
		String ch=null,choice=null;			
	do
	{
		for(String x:symptoms)
		{
			System.out.println("\nDo you have "+x+"?(Yes/No)");
			ch=sc.next();
			switch(ch)
			{
				case "No" : break;
				case "no" : break;
				case "Yes" : 
							switch(x)
							{
								case "Fever":cov_19+=4;cold+=1;flu+=4;
								break;
								case "Fatigue":cov_19+=3;cold+=3;flu+=3;
								break;
								case "Cough":cov_19+=4;cold+=2;flu+=4;
								break;
								case "Sneezing":cold+=4;
								break;
								case "Aches & pains":cov_19+=3;cold+=4;flu+=4;
								break;
								case "Runny or stuffy nose":cov_19+=1;cold+=4;flu+=3;
								break;
								case "Sore throat":cov_19+=3;cold+=4;flu+=3;
								break;
								case "Diarrhea":cov_19+=1;flu+=3;
								break;
								case "Headaches":cov_19+=3;cold+=1;flu+=4;
								break;
								case "Shortness of breath":cov_19+=3;
								break;
								case "Loss of taste/smell":cov_19+=4;
								break;								
							}
							break;
				case "yes" :
							switch(x)
							{
								case "Fever":cov_19+=4;cold+=1;flu+=4;
								break;
								case "Fatigue":cov_19+=3;cold+=3;flu+=3;
								break;
								case "Cough":cov_19+=4;cold+=2;flu+=4;
								break;
								case "Sneezing":cold+=4;
								break;
								case "Aches & pains":cov_19+=3;cold+=4;flu+=4;
								break;
								case "Runny or stuffy nose":cov_19+=1;cold+=4;flu+=3;
								break;
								case "Sore throat":cov_19+=3;cold+=4;flu+=3;
								break;
								case "Diarrhea":cov_19+=1;flu+=3;
								break;
								case "Headaches":cov_19+=3;cold+=1;flu+=4;
								break;
								case "Shortness of breath":cov_19+=3;
								break;
								case "Loss of taste/smell":cov_19+=4;
								break;								
							}
							break;													
			}			
		}
		if(cov_19>flu&&cov_19>cold) 
		{
			System.out.println("\n::WARNING::\nYou may have Corona-Virus!\nContact your nearest covid-care facility asap.\nCovid_19 Helpline No.(24x7/Tollfree) : 1075");			
		}
		else if(cov_19<flu&&flu>cold) 
		{
			System.out.println("\nDon't worry take some meds and rest for few days,you may have just a minor flu.");			
		}
		else if(cov_19<cold&&flu<cold) 
		{
			System.out.println("\nDon't worry take some meds and rest for few days,you may have just a minor cold.");			
		}
		cov_19=0;cold=0;flu=0;
		System.out.println("\nDo you want to continue?(Yes/No) : ");
		choice=sc.next();
	}while(choice.equals("yes")||choice.equals("Yes"));
		sc.close();
	}
}
