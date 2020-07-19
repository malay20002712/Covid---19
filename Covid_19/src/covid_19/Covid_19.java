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
		String ch=null,choice=null;		
		int cov_19=0,flu=0,cold=0;		
		/* These are the main Counter variables that will count the 
		 * Dominance Factor of a particular symptom over the available 
		 * three types of illness that covers this whole program.
		 * _____________________________________________________________
		 * The Three illness are :
		 * ->COVID-19.
		 * ->FLU.
		 * ->COLD. 
		 * 
		 * The symptoms in symptoms[] are all the symptoms that'll be 
		 * of our importance.
		 * _____________________________________________________________
		 * ::Dominance-Factor::
		 * ->Common(c) :+4
		 * ->Sometimes(s) :+3
		 * ->Mild(m) :+2
		 * ->Rare(r) :+1
		 * ->NO(n) :+0
		 * _____________________________________________________________
		 * 				
		 * ________________::SYMPTOMS-CHART::________________		   
		 * |     			|			   |	  |			|
		 * |Symptoms|Illness|	 cov_19    |cold  |	flu 	|
		 * |________________|______________|______|_________|
		 * |->Fever  		:		c		r	 	c		|
		 * |->Fatigue		:		s		s		s		|	
		 * |->Cough  		:		c		m		c		|
		 * | .												|
		 * | .												|			
		 * | .												|
		 * |->Loss of		:		c		n		n		|
		 * |  taste/smell 									|
		 * |________________________________________________|  
		 * 
		 * _____________________________________________________________
		*/
					
	do//For controlled termination of program. 
	{ 
		for(String x:symptoms)
		{
			System.out.println("\nDo you have "+x+"?(Yes/No)");
			ch=sc.next();
			switch(ch)//First switch decides if a person has that symptom or not.
			{
				case "No" : break;
				case "no" : break;
				case "Yes" : 
							switch(x)/*Second switch decides the Dominance Factor of
									   that particular symptom over the three illness
									   discussed earlier.Refer SYMPTOMS-CHART 
									   and Dominance-Factor.									   
									*/
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
							}//End of second switch.
							break;													
			}//End of first switch.			
		}
		if(cov_19>flu&&cov_19>cold)//If the person has CORONA virus possibly. 
		{
			System.out.println("\n::WARNING::\nYou may have Corona-Virus!"
					+ "\nContact your nearest covid-care facility asap."
					+ "\nCovid-19 Helpline No.(24x7/Tollfree) : 1075");			
		}
		else//If the person has either FLU or COLD or both. 
		{				
			if(flu==cold)
			{
			  System.out.println("\nDon't worry take some meds and rest for few days,"			
					+ "you may have just a minor cold/flu.");						
			}
			else if(flu>cold)
			{
				System.out.println("\nDon't worry take some meds and rest for few days,"
						+ "you may have just a minor flu.");
			}
			else
				System.out.println("\nDon't worry take some meds and rest for few days,"
						+ "you may have just a minor cold.");
		}
		cov_19=0;cold=0;flu=0;//Resetting the counter variables for a new person.		
		System.out.println("\nDo you want to continue?(Yes/No) : ");
		choice=sc.next();//For controlled termination of program.
	}while(choice.equals("yes")||choice.equals("Yes"));
		sc.close();
	}
}
