import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Olívia Maria Araujo de Souza";
        String tipoConta = "Corrente";
        double saldo = 2500.00;
        Scanner leitura = new Scanner(System.in);
        int escolha;
        String mensagem = """
                *******************************************************************
                Dados iniciais do cliente:
                
                Nome:           %s
                Tipo conta:     %s
                Saldo inicial:  R$ %.2f
                *******************************************************************
                """.formatted(nome, tipoConta, saldo);
        System.out.println(mensagem);
        mensagem = """
                
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                """;

        do{
            System.out.println(mensagem);
            escolha = leitura.nextInt();
            switch (escolha){
                case 1:
                    consultarValor(saldo);
                    break;

                case 2:
                    saldo = receberValor(saldo, leitura);
                    System.out.println("Saldo atualizado R$ " + saldo);
                    break;
                case 3:
                    saldo = transferirValor(saldo, leitura);
                    System.out.println("Saldo atualizado R$ " + saldo );
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(escolha != 4);
    }

    public static void consultarValor(double saldoAtual){
        System.out.println("O saldo atual é de R$" + saldoAtual );
    }
    public static double receberValor(double saldo, Scanner leitura){
        System.out.println("Informe o valor a receber");
        double dinheiroRecebido = leitura.nextDouble();
        saldo = saldo + dinheiroRecebido;
        return saldo;
    }
    public static double transferirValor(double saldo, Scanner leitura){
        System.out.println("Informe o valor que deseja transferir:");
        double dinheiroTransferido = leitura.nextDouble();
        if(dinheiroTransferido > saldo){
            System.out.println("Saldo insuficiente para transferência");
        }else {
            saldo = saldo - dinheiroTransferido;
        }
        return saldo;
    }
}