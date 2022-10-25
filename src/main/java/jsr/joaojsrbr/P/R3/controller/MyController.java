package jsr.joaojsrbr.P.R3.controller;

import javax.swing.*;

/*

    Entrada de duas variáveis do tipo inteiro
    calcular o quociente da divisão dos dois números
    calcular a potência do primeiro número pelo segundo número
    mostrar essas informações usando “interface” com usuário

 */

public class MyController {
    // data output
    private final StringBuffer mensagem = new StringBuffer();

    // options da pergunta
    private final Object[] options = { "Ficar", "Sair" };

    // entrada do primeiro número
    private int firstNumber;

    // entrada do segundo número
    private int secondNumber;

    // resultado da potência
    private int potency;

    // resultado do resto da divisão 1
    private double firstRest;

    // resultado do resto da divisão 2
    private double secondRest;

    // resultado da divisão do primeiro número pelo segundo
    private double firstDivision;

    // resultado da divisão do segundo número pelo primeiro
    private double secondDivision;

    // Soma do primeiro número pelo segundo
    private int sum;

    // bool de exception
    private boolean exception = false;


    // estrutura de instância da class
    public MyController(){
        dataInput();
        dataProcess();
        dataOutput();
        confirmEndProgram();
    }


    // Pergunta ao usuário se deseja sair do programa
    private  void confirmEndProgram(){

      final int input =  JOptionPane.showOptionDialog(null,
                "Deseja Sair do Programa ?", "Sair", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,options, options[0]
      );

      /*
        Possíveis valores:
            0 = click Ficar;
            1 = click Sair;
           -1 = close dialog;
      */

      // instância MyController de novo ou finaliza o programa
        if (input == 0) {
            new MyController();
        }else {
            System.exit(0);
        }

    }

    // Formatando a saida em String
    private void dataStringProcess(){
        final String firstDivisionMessage = "Resultado da primeira divisão ( "+firstNumber+" / "+secondNumber+" ): " + firstDivision;
        final String secondDivisionMessage = "\nResultado da segunda divisão ( "+secondNumber+" / "+firstNumber+" ): " + secondDivision;
        final String firstRestMessage = " resto da divisão: " + firstRest;
        final String secondRestMessage = " resto da divisão: " + secondRest;
        final String sumMessage = "\nResultado da soma ( "+firstNumber+" + " + secondNumber +" ): " + sum;
        final String potencyMessage = "\nResultado da potenciação ( "+firstNumber+" ^ " + secondNumber +" ): " + potency;

        mensagem.append(firstDivisionMessage.concat(firstRestMessage))
                .append(secondDivisionMessage.concat(secondRestMessage))
                .append(sumMessage)
                .append(potencyMessage);
    }

    // saida de dados com um dialog e a confirmação de finalização do programa
    private void dataOutput(){
        JOptionPane.showMessageDialog(null, mensagem);

    }


    // Processamento das operações e a saida
    private void dataProcess(){
        firstDivision  = (double) firstNumber / secondNumber;
        secondDivision = (double) secondNumber / firstNumber;
        firstRest = (double) firstNumber % secondNumber;
        secondRest = (double) secondNumber % firstNumber;
        sum = firstNumber + secondNumber;
        potency = (int) Math.pow(firstNumber,secondNumber);
        dataStringProcess();
    }

    // Entrada de dados
    private void dataInput() {
        boolean boolNumber1 = false;
        boolean boolNumber2 = false;
        do {
            try {
                // mensagem de exception caso entre com dados que não seja inteiro
                if(exception){
                    JOptionPane.showMessageDialog(null, "Entrada invalida\nPor favor digite somente números inteiros\nExemplos: 1, 2, 3,..");
                }

                // verifica se a variável firstNumber foi atribuída um valor
                if(!boolNumber1) {
                    final String dataStringInput1 = JOptionPane.showInputDialog("Digite o primeiro numero inteiro!");
                    /*
                        Possíveis valores:
                        null (fechar a dialog) = finaliza o programa;
                        default = parseInt(variável)
                    */
                    if (dataStringInput1 == null) confirmEndProgram();
                    assert dataStringInput1 != null;
                    firstNumber = Integer.parseInt(dataStringInput1);
                    boolNumber1 = true;
                }


                final String dataStringInput2 =  JOptionPane.showInputDialog("Digite o segundo numero inteiro!");
                /*
                        Possíveis valores:
                        null (fechar a dialog) = finaliza o programa;
                        default = parseInt(variável)
                 */
                if(dataStringInput2 == null) confirmEndProgram();
                assert dataStringInput2 != null;
                secondNumber = Integer.parseInt(dataStringInput2);
                boolNumber2 = true;

                exception = false;
            }  catch (NumberFormatException e) {
                // exception do parseInt [NumberFormatException]
                exception = true;
               }
        } while (!boolNumber1  || !boolNumber2);
    }
}


