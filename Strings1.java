import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Strings1 {
  public static void main(String[] args) throws FileNotFoundException {
	Scanner in = new Scanner(System.in);
	Scanner file;
	int[][] gradebook; 
	double[] average;
	int size;
	int size2;
	
	System.out.println("What is the name of the file containing the scores?");
	file = new Scanner(new File(in.nextLine()));
	size = file.nextInt();
	size2 = file.nextInt();
	gradebook = new int[size][size2];
	average = new double[size2];
	//System.out.println(file.next());
	while (file.hasNext()) {
		for (int j = 0; j < gradebook.length; j++) {
			for (int i = 0; i < gradebook[j].length; i++) {
				gradebook[j][i] = file.nextInt();
			}
		}
	}
	file.close();
	
	System.out.println("Array of scores:");
	for (int j = 0; j < gradebook.length; j++) {
		System.out.print("[");
		for (int i = 0; i < gradebook[j].length; i++) {
			if (i == gradebook[j].length - 1) {
				System.out.print(gradebook[j][i]);
			}
			else {
				System.out.print(gradebook[j][i] + ", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	System.out.println();
	System.out.println("Average score of each assignment:");
	for (int j = 0; j < size2; j++) {
		for (int i = 0; i < size; i++) {
			average[j] += gradebook[i][j];
		}
		average[j] /= size;
	}
	
	for (int j = 0; j < size2; j++) {
		System.out.println("Assignment #" + (j+1) + " Average = " + average[j]);
	}
	
  }
}