import java.util.Scanner;

public class Menu{
  private static int opcao, matricula;
  private static String nomeTime, nomeAluno, curso, email;
  private static int avaliador, contTimes, tam=8, tamAlunos=6;
  private static double nota;
  private static Time[] times;
  private static Aluno[] alunos;

  public static void primeiroMenu(){
    Scanner in = new Scanner(System.in);
    contTimes = 0;
    times = new Time[15];
    
    do{
      System.out.println("\n...::: Bem Vindo às inscrições da Hackatona! :::...");
      System.out.println("\n  ----------------------Menu----------------------");
      System.out.println("1 - Criar um novo time");
      System.out.println("2 - Inscrever um novo aluno em um time");
      System.out.println("3 - Adicionar nota a um time");
      System.out.println("4 - Buscar alunos que participaram da Hackatona");
      System.out.println("5 - Buscar time com maior pontuação");
      System.out.println("6 - Buscar times com pontuação acima de 20 pontos");
      System.out.println("7 - Mostrar dados de um time");
      System.out.println("8 - Verificar se time está cadastrado");
      System.out.println("0 - Para sair");
      System.out.print("\n>> Informe a ação que gostaria de fazer: ");
      opcao = in.nextInt();

    switch(opcao){
      case 1: //Criar um novo time
        Time novoTime;
        if(contTimes < 15){
          System.out.print("\nInforme o nome do time: ");
          nomeTime = in.next();
          novoTime = new Time(nomeTime);
          times[contTimes] = novoTime;
          contTimes++;
          System.out.println("\n"+ contTimes + "° Time - Nome: "+ "\"" + novoTime.getNomeTime() + "\"" +" criado com sucesso.\n");
          break;
      }else{
        System.out.println("\n>>> Limite de times já alcançado. <<<");
      }
        break;

      case 2://Inscrever um novo aluno em um time
        System.out.print("\nInforme o nome do time em que o aluno deve ser inscrito: "); 
        nomeTime = in.next();  
        for(Time time:times){
          if(time == null){
            break;
          }  
          if(time.getNomeTime().equals(nomeTime)){
            System.out.print("Informe a matrícula do aluno: "); 
            matricula = in.nextInt();
            if(time.contemAluno(matricula) == false){
              System.out.print("Informe o nome do aluno a ser inscrito: "); 
              nomeAluno = in.next();        
              System.out.print("Informe o curso do aluno: "); 
              curso = in.next();
              System.out.print("Informe o email do aluno: "); 
              email = in.next();        
              Aluno aluno = new Aluno(matricula, nomeAluno, curso, email);
              time.adicionaAluno(aluno);
              break;
            }            
          }else
            System.out.println("Time não cadastrado.");
        }
          break;     

      case 3://Adicionar nota a um time
        String nomeTime;
        System.out.print("\nInforme o time que receberá a nota: ");
        nomeTime = in.next();
        System.out.print("Informe a nota a ser adicionada: ");
        nota = in.nextDouble();
        if(nota>0 && nota<=5){
          System.out.print("Informe o avaliador: ");
          avaliador = in.nextInt();
          for(Time time:times){
            if(times == null){
              break;
            }
            if(time.getNomeTime().equals(nomeTime)){
              if(time.adicionaNotas(nota, avaliador)){
                System.out.println("Nota adicionada com sucesso! ");
                break;
              }else{
                System.out.println("Nota não inserida. Todas as notas do time já foram recebidas.");
                break;
              }
            }
          }
        }else{
          System.out.println("Nota acima do valor permitido.");
      }
        break;
          
        
      case 4: //Buscar alunos que participaram da Hackatona
        System.out.println("\nOs alunos que participaram da Hackatona são: ");
        for(Time time:times){
          if(time != null)
          time.retornaAlunos();          
        }
          break;
        
   
      case 5: //Buscar times com maior pontuação
        Time.notaMaisAlta(times);
        break;
      
      case 6: //Mostrar times com pontuação acima de 20
        System.out.println("\nTimes com pontuação acima de 20 pontos: \n");
        Time.notaAcima20(times);
        break;

      case 7: //Mostrar dados de um time
        System.out.print("\nInforme o nome do time que deseja ver os dados:");
        nomeTime = in.next();
        for(Time time:times){
          if(time == null){
            break;
          }
          if(nomeTime.equals(time.getNomeTime())){
            time.imprimeDadosTime(time,times);
            System.out.println("As notas do time " + nomeTime + " são: ");
            time.mostraNotas(nomeTime);
            break;
          }
        }
        break;

      case 8:
        System.out.print("\nInforme o nome do time que deseja verfificar:");
        nomeTime = in.next();
        Time.buscaTimes(nomeTime, times);
        break;        

      case 0:
        System.out.println("\n.::Sistema sendo encerrado::.");
        break;

      default: 
        System.out.println("Opção inválida.");
        break;
    }
    }while(opcao != 0);
  }  
}

