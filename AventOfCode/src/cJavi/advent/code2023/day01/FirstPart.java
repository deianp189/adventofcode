package cJavi.advent.code2023.day01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class FirstPart {
	static BufferedReader input;
	
	static int result = 0;
	public static void readInput() throws FileNotFoundException {
		input = new BufferedReader(new FileReader("C:\\Users\\JaviNL\\Documents\\GitHub\\adventofcode\\AventOfCode\\src\\cJavi\\advent\\code2023\\day01\\input"));
	}
	
	public static void solve() throws IOException {
		String line;
		int firstDigit = -1, lastDigit = 0;
		while((line = input.readLine()) != null) {
			for(char digit : line.toCharArray()) {
				if(Character.isDigit(digit)) {
					if(firstDigit == -1) {
						firstDigit = (int) digit;
					} else {
						lastDigit = (int) digit;
					}
				}
			}
		}
		if(firstDigit == -1) return;
		result += firstDigit * 10 + lastDigit;
	}
    public static void main(String[] args) {
        System.out.println("Day 1 - First Part");
        System.out.println(Paths.get("").toAbsolutePath());
    	try {
			readInput();
			solve();
			
			System.out.println(String.valueOf(result));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
         
    }
}
