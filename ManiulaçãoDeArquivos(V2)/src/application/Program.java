package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.entities.Products;
public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Products> products = new ArrayList<>();
		
		System.out.print("Enter the path of file: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String vet[] = line.split(",");
				Products p = new Products(vet[0], Double.parseDouble(vet[1]), Integer.parseInt(vet[2]));
				products.add(p);
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String pathArchive = "C:\\Temp\\out\\summary.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathArchive))){
			for(Products p : products) {
				bw.write(p.toString());
				bw.newLine();
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			sc.close();
		}
	}
}
