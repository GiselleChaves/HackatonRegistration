public class Aluno {
  private String nome, curso, email;
  private int matricula;

  public Aluno(int matricula, String nome, String curso, String email){
    this.matricula = matricula;
    this.nome = nome;
    this.curso = curso;
    this.email = email;
  }

  public int getMatricula(){
    return matricula;
  }

  public String getNome(){
    return nome;
  }

  public String getCurso(){
    return curso;
  }

  public String getEmail(){
    return email;
  }

  public void setMatricula(int matricula){
    if(matricula > 8){
      this.matricula = matricula;
    }else
    System.out.println("Número de matrícula inválido, informe uma matrícula.");
  }

  public void setNome(String nome){
    if(!nome.isEmpty()){
      this.nome = nome;
    }else
    System.out.println("Informe o nome completo do aluno.");
  }

  public void setCurso(String curso){
    if(!curso.isEmpty()){
      this.curso = curso;
    }else
      System.out.println("Informe um nome de curso.");
    }

  public void setEmail(String email){
    if(!curso.isEmpty()){
      this.email = email;
    }else
    System.out.println("Informe um email.");
  }

  public String toString(){
    return "Dados do Aluno - Nome: " + getNome() + ", Matrícula: " + getMatricula() + ", Curso: " + getCurso() + 
            ", Email: " + getEmail();
  }

}
