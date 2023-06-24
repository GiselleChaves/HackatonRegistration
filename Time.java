public class Time{
  private String nomeTime;
  private int proximaNota, proximoAluno, qntTimes=15;
  private final static int tamAlunos=6, tamNotas=5, qntAvaliadores=5;
  private static int tamTime=0;
  private Aluno[] alunos;
  private double[][] notas;

  public Time(String nomeTime){
    if(tamTime < qntTimes){
      alunos = new Aluno[tamAlunos];
      tamTime++;
    }
    this.nomeTime = nomeTime;
    proximaNota = 0;
    proximoAluno = 0;
    notas = new double[qntAvaliadores][tamNotas];
      for(int i=0; i<tamNotas;i++){
        for(int j=0; j<qntAvaliadores;j++){
          notas[j][i] = -1.0;
        };
      }
    }

  /**
   * @param matricula
   * @return true se o aluno é localizado no array ou false se não localizado.
   */
  public boolean contemAluno(int matricula){
    for(Aluno alunoIteracao:alunos){
      if(alunoIteracao == null){
        break;
      }
      if(alunoIteracao.getMatricula() == matricula){
        return true;
      }
    }
    return false;
  }

  /**
   * @param aluno
   */
  public void adicionaAluno(Aluno aluno){ 
    if(proximoAluno < tamAlunos){
      if(proximoAluno == tamAlunos-1 && !Time.testaCurso(aluno.getCurso(), alunos)){
        System.out.println("Todos os alunos são do mesmo curso. Não adicionado.");
        return;
      }     
      alunos[proximoAluno] = aluno;
      proximoAluno++;
      System.out.println("\nAluno(a) " + aluno.getNome() + " registrado no time: " + getNomeTime());
    }else{
      System.out.println("\n>>> Número máximo de alunos inscritos no time atingido, não adicionado. <<<");
    }
  }

      
  public static boolean testaCurso(String curso, Aluno[] alunos){
    for(Aluno aluno:alunos){
      if(aluno == null){
        break;
      }
      if(!curso.equals(aluno.getCurso()));
        return true;
      }
      return false;
    }
  
  /**
   * @param nomeTime
   * @param times
   */
  public static void buscaTimes(String nomeTime, Time[] times){
    for(Time time:times){
      if(time == null){
        break;
      }
      if(nomeTime.equals(time.getNomeTime())){
        System.out.println("\nTime cadastrado");
        return;
      }
    }
    System.out.println("Time não cadastrado");
  }

      
  /**
   * @param nota
   * @param avaliador
   * @return true se a nota do avaliador for adicionada ao time, false se não adicionada
   */
  public boolean adicionaNotas(double nota, int avaliador){
      for(int i=0; i<tamNotas; i++){
        if(notas[avaliador][i] < 0){
            notas[avaliador][i] = nota;
            return true;
          }
      }
      return false;
  }


  /**
   * @return matriz com as notas do time
   */
  public double[][] getNotas(){
    return notas;
  }

  /**
   * @param times
   */
  public static void notaMaisAlta(Time[] times){
    double notaMaisAlta=0.0, soma=0.0;
    Time time=null; 
    for(int i=0; i<tamTime; i++){
      soma=0;
      if(times[i] != null){   
        double[][] notas = times[i].getNotas(); //notas recebe as notas dos times
        
        for(int j=0; j<tamNotas; j++){
          for(int k=0; k<qntAvaliadores; k++){
            if (notas[k][j] >= 0)
              soma = soma + notas[k][j];
          }
          if(notaMaisAlta < soma){
              notaMaisAlta = soma;
              time = times[i];
          }
        }
      }
    }
    System.out.println("\nA nota mais alta é: " + notaMaisAlta + " do time: " + time.getNomeTime());
  }

  /**
   * @param times
   */
  public static void notaAcima20(Time[] times){
    double[] notaAcima20= new double[15]; 
    int proximaNota=0;
    double soma=0.0;
    Time time=null; 
    for(int i=0; i<tamTime; i++){
      soma=0;
      if(times[i] != null){   
        double[][] notas = times[i].getNotas(); //notas recebe as notas dos times
        
        for(int j=0; j<tamNotas; j++){
          for(int k=0; k<qntAvaliadores; k++){
            if (notas[k][j] >= 0)
              soma = soma + notas[k][j];
          }
        }
        if(soma > 20){
          System.out.println("Nota:" + soma + " Time: " + times[i].getNomeTime());
        }
      }
    }  
  }

  
  /**
   * @param nomeTime
   */
  public void mostraNotas(String nomeTime){
    double[][] notas = getNotas(); //notas recebe as notas dos times
    for(int i=0; i<qntAvaliadores; i++){
      System.out.println("Notas do avaliador " + i + ": ");
      for(int j=0; j<tamNotas; j++){
        System.out.print("\t" + (notas[i][j] == -1.0 ? "N/A" : notas[i][j])); //if ternario
      }
      System.out.println("\n");
    }
  }
  

  /**
   * 
   */
  public void retornaAlunos(){
    for(Aluno aluno:alunos){
      if(aluno != null){
        System.out.println(aluno);
      }
    }
  }
    
  /**
   * @param time
   */
  public void imprimeDadosTime(Time time){
    System.out.print("\nNome do Time: " + time.getNomeTime());
    System.out.print("\nParticipantes do Time: \n");
    retornaAlunos();
    }


  public String toString(){
    return "Time: " + getNomeTime();
  }

  public String getNomeTime() {
    return nomeTime;
  }

  public int getProximaNota() {
    return proximaNota;
  }

  public void setNomeTime(String nomeTime) {
    this.nomeTime = nomeTime;
  }

  public void setProximaNota(int proximaNota) {
    this.proximaNota = proximaNota;
  }
}
