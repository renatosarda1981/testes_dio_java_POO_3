import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {
    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {
    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de cofre (digital ou fisico):");
        String tipoCofre = scanner.nextLine();

        if (tipoCofre.equalsIgnoreCase("digital")) {
            System.out.println("Defina a senha do cofre:");
            int senhaCofre = scanner.nextInt();
            CofreDigital cofreDigital = new CofreDigital(senhaCofre);

            System.out.println("Confirme a senha para abrir o cofre:");
            int confirmacaoSenha = scanner.nextInt();

            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");
            } else {
                cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
            }

        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            CofreFisico cofreFisico = new CofreFisico();
            //System.out.println("Insira a chave para abrir o cofre (simulação, sem validação):");
            //scanner.next(); // Simula a entrada da chave

            cofreFisico.imprimirInformacoes();

        } else {
            System.out.println("Tipo de cofre inválido. Escolha entre 'digital' ou 'fisico'.");
        }

        scanner.close();
    }
}
