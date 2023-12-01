package cJavi.advent.code2023.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class SecondPart {
static BufferedReader input;
	
	static int result = 0;
	public static void readInput() throws FileNotFoundException {
		input = new BufferedReader(new FileReader("C:\\Users\\JaviNL\\Documents\\GitHub\\adventofcode\\AventOfCode\\src\\cJavi\\advent\\code2023\\day01\\input"));
	}
	
	public static void solve() throws IOException {
		String line;
		
		while((line = input.readLine()) != null) {
			int firstDigit = -1, lastDigit = 0;
			int startNumIndex = 0;
			for(int i = 0; i < line.length(); i++) {
				int digit = 0;
				if(Character.isDigit(line.charAt(i))) {
					digit = Integer.valueOf(String.valueOf(line.charAt(i)));	
					
				}
				else if((digit = toNumber(line.substring(startNumIndex, i))) == -1){
					continue;
				}
				
				startNumIndex = i+1;
				if(firstDigit == -1) {
					firstDigit = digit;
					lastDigit = digit;
				} else {
					lastDigit = digit;
				}
			}
			if(firstDigit == -1) continue;
			
			result += firstDigit * 10 + lastDigit;
		}
		
	}
	
	public static int toNumber(String str) {
		
		switch(str) {
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		default:
			return -1;
		}
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
