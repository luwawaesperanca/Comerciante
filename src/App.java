import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Variável para armazenar o número de produtos a serem cadastrados
        int input;
        // Arrays para armazenar os dados dos produtos
        String[] nomes;
        double[] precos;
        double[] precosVenda;
        // Variáveis para armazenar o número de produtos em cada categoria de lucro
        int lucroAbaixo10 = 0;
        int lucroEntre10e20 = 0;
        int lucroAcima20 = 0;
        int lucrotal = 0;
        // Variáveis para armazenar o total de compra e venda        
        double totalCompra = 0.0;
        double totalVenda = 0.0;

        double lucro;
        double percentualLucro;
    
      


        System.out.println("Controle de Produtos");
        System.out.println("---------------------");

        var sc = new Scanner(System.in);
        System.out.print("Serao digitados dados de quantos produtos? ");
        input = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        nomes = new String[input];
        precos = new double[input];
        precosVenda = new double[input];

        for (int i = 0; i < input; i++) {

            System.out.println("Produto " + (i + 1) + ":");
            System.out.print("Digite o nome do produto: ");
            nomes[i] = sc.nextLine();
            System.out.print("Digite o preco de custo do produto: ");
            precos[i] = sc.nextDouble();
            System.out.print("Digite o preco de venda do produto: ");
            precosVenda[i] = sc.nextDouble();
            sc.nextLine(); // Consume the newline character

            if (precosVenda[i] < precos[i]) {
                System.out.println("O preco de venda nao pode ser menor que o preco de custo.");
                i--; // Decrement i to repeat this iteration
            } else {
                 lucro = precosVenda[i] - precos[i];
                 percentualLucro = (lucro / precos[i]) * 100;

                if (percentualLucro < 10) {
                    lucroAbaixo10++;
                    totalCompra += precos[i];
                    lucrotal += lucro;
                    totalVenda += precosVenda[i];
                } else if (percentualLucro >= 10 && percentualLucro <= 20) {
                    lucroEntre10e20++;
                    totalCompra += precos[i];
                    lucrotal += lucro;
                    totalVenda += precosVenda[i];
                }
                else {
                    lucroAcima20++;
                    totalCompra += precos[i];
                    totalVenda += precosVenda[i];
                    lucrotal += lucro;
                }
                System.out.println("Produto cadastrado com sucesso!");
            }

        }
        System.out.println("\nRelatório de Produtos:");
        System.out.println("-----------------------------------");
        System.out.println("Lucro abaixo de 10%: "+lucroAbaixo10);
        System.out.println("Lucro entre 10% e 20%: "+lucroEntre10e20);
        System.out.println("Lucro acima de 20%: "+lucroAcima20);
        System.out.println("Valor total de compra: "+totalCompra);
        System.out.println("Valor total de venda: "+totalVenda);
        System.out.println("Lucro total: "+lucrotal);
        sc.close();
    }
}
