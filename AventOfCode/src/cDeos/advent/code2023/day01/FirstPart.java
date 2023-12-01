package cDeos.advent.code2023.day01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstPart {

	private ArrayList<ArrayList<String>> numeros;
	private ArrayList<Integer> suma;

	public FirstPart() {
		this.numeros = new ArrayList<>();
		this.suma = new ArrayList<>();
	}

	public Integer sumaTotal() {
		Integer suma = 0;
		for (Integer numero : this.suma) {
			suma += numero;
		}
		return suma;
	}

	public void procesarNumeros() {
		for (ArrayList<String> sublista : this.numeros) {
			for (int i = 0; i < sublista.size(); i++) {
				String elemento = sublista.get(i);
				if (elemento.length() > 1) {
					// Numero de múltiples digitos
					sublista.remove(i);
					for (int j = elemento.length() - 1; j >= 0; j--) {
						sublista.add(i, String.valueOf(elemento.charAt(j)));
					}
				} else if (elemento.length() == 1 && sublista.size() == 1) {
					// Numero de un solo dígito y está solo en la sublista
					sublista.add(elemento); // Repetir el digito
				}
			}
		}
	}

	public void add() {
		for (ArrayList<String> lista : this.numeros) {
			this.suma.add(Integer.parseInt(lista.get(0) + lista.get(lista.size() - 1)));
		}
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
		return this.numeros.toString() + "\n" + this.suma.toString();
	}

	public static void main(String[] args) {

		FirstPart primerReto = new FirstPart();
		primerReto.load(directorioEntrada + "firstInput.txt");

		primerReto.procesarNumeros();
		primerReto.add();
		System.out.println(primerReto.toString());
		System.out.println();
		System.out.println(primerReto.sumaTotal());

	}
}
