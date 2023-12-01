package cDeos.advent.code2023.day01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstPart {

	// private ArrayList<Integer> sumas;
	private ArrayList<ArrayList<String>> numeros;

	public FirstPart() {
		this.numeros = new ArrayList<>();
	}

	static String directorioEntrada = System.getProperty("user.dir") + File.separator + "src" + File.separator + "cDeos"
			+ File.separator + "advent" + File.separator + "code2023" + File.separator + "day01" + File.separator;

	public boolean load(String nombreArchivo) {

		Scanner scan;
		try {
			scan = new Scanner(new File(nombreArchivo));
		} catch (Exception e) {
			return false;
		}
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			if (linea.isEmpty())
				continue;
			String[] items = linea.split("\\D+");
			ArrayList<String> listaTemporal = new ArrayList<>();
			for (String item : items) {
				if (!item.isEmpty()) {
					listaTemporal.add(item);
				}
			}
			if (!listaTemporal.isEmpty()) {
				numeros.add(listaTemporal);
			}

		}

		scan.close();
		return true;
	}

	@Override
	public String toString() {
		return this.numeros.toString();
	}

	public static void main(String[] args) {

		FirstPart prueba = new FirstPart();
		prueba.load(directorioEntrada + "firstInput.txt");

		System.out.println(prueba.toString());

	}
}
