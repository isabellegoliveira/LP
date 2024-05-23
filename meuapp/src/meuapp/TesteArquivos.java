package meuapp;

import java.io.*;
import java.util.Scanner;

public class TesteArquivos {
    public static void main(String[] args) {
        String path = "teste.txt";
        try {
            escritor(path);
            leitor(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        String linha = in.nextLine();
        buffWrite.write(linha + "\n");
        buffWrite.close();
        in.close();
    }

    private static void leitor(String path) throws IOException {
        File arquivo = new File(path);
        if (arquivo.exists()) {
            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha;
            while ((linha = buffRead.readLine()) != null) {
                System.out.println(linha);
            }
            buffRead.close();
        } else {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }
}
