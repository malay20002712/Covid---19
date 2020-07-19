package covid19projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Covid19predictor {

	public static Scanner s = new Scanner(System.in);

	static void initialise(String[] disease, String[][] diseaseChart) {
		System.out.println("Welcome to Corona self Assessment Test, test yourself and be assertive!! Jai hind");
		disease[0] = "Fever";
		disease[1] = "Fatigue";
		disease[2] = "cough";
		disease[3] = "sneezing";
		disease[4] = "Runny Nose";
		disease[5] = "Sore throat";
		disease[6] = "Dirrhea";
		disease[7] = "headache";
		disease[8] = "Shortness of breathness";
		disease[9] = "loss of taste";
		disease[10] = "loss of smell";
		diseaseChart[0][0] = "Common";
		diseaseChart[0][1] = "Rare";
		diseaseChart[0][2] = "Common";
		diseaseChart[1][0] = "Sometimes";
		diseaseChart[1][1] = "Sometimes";
		diseaseChart[1][2] = "Common";
		diseaseChart[2][0] = "Common";
		diseaseChart[2][1] = "mild";
		diseaseChart[2][2] = "common";
		diseaseChart[3][0] = "No";
		diseaseChart[3][1] = "Common";
		diseaseChart[3][2] = "No";
		diseaseChart[4][0] = "Rare";
		diseaseChart[4][1] = "Common";
		diseaseChart[4][2] = "Sometimes";
		diseaseChart[5][0] = "Sometimes";
		diseaseChart[5][1] = "Common";
		diseaseChart[5][2] = "Sometimes";
		diseaseChart[6][0] = "Rare";
		diseaseChart[6][1] = "No";
		diseaseChart[6][2] = "Sometimes";
		diseaseChart[7][0] = "Sometimes";
		diseaseChart[7][1] = "Rare";
		diseaseChart[7][2] = "Common";
		diseaseChart[8][0] = "Sometimes";
		diseaseChart[8][1] = "No";
		diseaseChart[8][2] = "No";
		diseaseChart[9][0] = "Common";
		diseaseChart[9][1] = "Sometimes";
		diseaseChart[9][2] = "Sometimes";
		diseaseChart[10][0] = "Common";
		diseaseChart[10][1] = "Sometimes";
		diseaseChart[10][2] = "Sometimes";

	}

	public static void main(String[] args) {
		String disease[] = new String[11];
		String diseaseChart[][] = new String[11][3];
		initialise(disease, diseaseChart);
		boolean x = true;
		while (x) {
			boolean y = true;
			while (y) {
				System.out.print("name: ");
				String name = s.next();
				Pattern p = Pattern.compile("[^A-Za-z]");
				Matcher m = p.matcher(name);
				if (m.find()) {
					System.out.println("format of entering the name is wrong enter it correctly. ");
					y = true;
				} else {
					y = false;
				}
			}
			y = true;
			while (y) {
				
				System.out.print("age: ");
				String age = s.next();
				System.out.println();
				Pattern p = Pattern.compile("[^0-9]");
				Matcher m = p.matcher(age);
				if (m.find()) {
					System.out.println("enter the age of the person correctly: ");
					y = true;
				} else {
					y = false;
				}

			}
			y = true;
			while (y) {
				
				System.out.println("enter your phone number: ");
				String phoneNumber = s.next();
				Pattern p = Pattern.compile("[^0-9]");
				Matcher m = p.matcher(phoneNumber);
				if (m.find()) {
					System.out.println("enter the correct phone number");
					y = true;
					continue;
				}
				int num = phoneNumber.length();
				if (num < 10) {
					System.out.println("Please enter the correct phone number ");
					y = true;
				} else {
					y = false;
				}
			}
			selfAssessmentTest(disease, diseaseChart);

		}

	}

	static void selfAssessmentTest(String[] disease, String[][] diseaseChart) {
		System.out.println("enter yes or no for the following symptoms if you have or not: ");
		int[][] corona = new int[11][3];
		for (int[] row : corona) {
			Arrays.fill(row, 0);
		}
		String answer = new String();
		boolean ans = false;
		for (int i = 0; i < 11; i++) {
			System.out.println("do you have " + disease[i] + " :");
			answer = s.next();
			ans = (answer.equalsIgnoreCase("yes"));
			add(corona, i, ans, diseaseChart);
		}
		calculate(corona);

	}

	static void add(int[][] corona, int i, boolean ans, String[][] diseaseChart) {
		for (int j = 0; j < 3; j++) {
			if (!ans) {
				while (j < 3) {
					corona[i][j] = 0;
					j++;
				}
				break;
			} else if (diseaseChart[i][j] == "Sometimes" || diseaseChart[i][j] == "Rare"
					|| diseaseChart[i][j] == "No") {
				corona[i][j] = 0;
			} else {
				corona[i][j]++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	static void calculate(int[][] corona) {
		@SuppressWarnings("rawtypes")
		ArrayList l = new ArrayList<>();
		l.add("Corona");
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			sum += corona[i][0];
		}
		l.add(sum);
		sum = 0;
		l.add("Fever");
		for (int i = 0; i < 11; i++) {
			sum += corona[i][1];
		}
		l.add(sum);
		sum = 0;
		l.add("Flu");
		for (int i = 0; i < 11; i++) {
			sum += corona[i][2];
		}
		l.add(sum);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 6; i += 2) {
			if ((int) l.get(i) > max) {
				max = (int) l.get(i);
			}
		}

		for (int i = 1; i < 6; i += 2) {
			if ((int) l.get(i) == max) {
				System.out.println("all the symptoms says that you are infected by " + l.get(i - 1));
				String test = (String) l.get(i - 1);
				if (test.equalsIgnoreCase("corona")) {
					System.out.println("You should consult a doctor hence. Toll free number : 1075");
				} else if (test.equalsIgnoreCase("fever")) {
					System.out.println("Take care of your self, you need not consult a doctor stay at home"
							+", taking medicines will help you");
				} else if (test.equalsIgnoreCase("flu")) {
					System.out.println("Staying at home and taking care of yourself would help you.");
				}
				break;
			}
		}
		System.out.println("Namaste.");
	}
}

