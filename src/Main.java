import java.util.ArrayList;
import java.util.List;

abstract class Pessoa {
    private String cpf;
    private String nome;
    private int idade;

    public Pessoa(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método para incrementar a idade
    public void fazerAniversario() {
        idade++;
    }
}

class Disciplina {
    private String codigo;
    private String nome;
    private String semestre;

    public Disciplina(String codigo, String nome, String semestre) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}

class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String cpf, String nome, int idade, String matricula) {
        super(cpf, nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void pagarMensalidade() {
        System.out.println("Mensalidade paga pelo aluno: " + getNome());
    }
}

class Professor extends Pessoa {
    private String centro;

    public Professor(String cpf, String nome, int idade, String centro) {
        super(cpf, nome, idade);
        this.centro = centro;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public void darAula() {
        System.out.println("Professor " + getNome() + " dando aula no centro " + centro);
    }
}

class Visitante extends Pessoa {
    public Visitante(String nome, String cpf, int idade) {
        super(cpf, nome, idade);
    }
}

class Bolsista extends Aluno {
    public Bolsista(String cpf, String nome, int idade, String matricula) {
        super(cpf, nome, idade, matricula);
    }

    @Override
    public void pagarMensalidade() {
        System.out.println("Aluno bolsista " + getNome() + " está isento de pagar mensalidade.");
    }
}

class Regular extends Aluno {
    public Regular(String cpf, String nome, int idade, String matricula) {
        super(cpf, nome, idade, matricula);
    }

    @Override
    public void pagarMensalidade() {
        System.out.println("Mensalidade paga regularmente pelo aluno: " + getNome());
    }
}

class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("Nome do aluno: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }
    }

    public void imprimirInformacoes() {
        System.out.println("Código da turma: " + codigo);
        System.out.println("Disciplina: " + disciplina.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos matriculados:");
        listarAlunos();
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Instanciando 3 objetos de Disciplina
        Disciplina disciplina1 = new Disciplina("D1", "Matemática", "1º Semestre");
        Disciplina disciplina2 = new Disciplina("D2", "História", "2º Semestre");
        Disciplina disciplina3 = new Disciplina("D3", "Física", "2º Semestre");

        // Instanciando 3 objetos de Aluno
        Aluno aluno1 = new Regular("111111111", "Maria", 20, "A001");
        Aluno aluno2 = new Regular("222222222", "Pedro", 22, "A002");
        Aluno aluno3 = new Bolsista("333333333", "Ana", 19, "A003");

        // Instanciando 1 objeto de Professor
        Professor professor1 = new Professor("444444444", "João", 35, "Centro 1");

        // Instanciando 2 objetos de Visitante
        @SuppressWarnings("unused")
        Visitante visitante1 = new Visitante("Visitante1", "555555555", 25);
        @SuppressWarnings("unused")
        Visitante visitante2 = new Visitante("Visitante2", "666666666", 30);

        // Instanciando 3 objetos de Turma
        Turma turma1 = new Turma("T1", disciplina1, professor1);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);

        Turma turma2 = new Turma("T2", disciplina2, professor1);
        turma2.adicionarAluno(aluno2);
        turma2.adicionarAluno(aluno3);

        Turma turma3 = new Turma("T3", disciplina3, professor1);
        turma3.adicionarAluno(aluno1);
        turma3.adicionarAluno(aluno3);

        // Imprimindo informações das turmas
        System.out.println("Informações das turmas:");
        System.out.println("------------------------");
        System.out.println("Turma 1:");
        turma1.imprimirInformacoes();
        System.out.println("------------------------");
        System.out.println("Turma 2:");
        turma2.imprimirInformacoes();
        System.out.println("------------------------");
        System.out.println("Turma 3:");
        turma3.imprimirInformacoes();
    }
}
