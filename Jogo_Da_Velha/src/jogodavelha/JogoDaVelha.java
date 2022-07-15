package jogodavelha;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String[] args) {
	char [][] Tabuleiro = {{' ', ' ', ' '},
	                       {' ', ' ', ' '},
	                       {' ', ' ', ' '}};
	
	Scanner scanner = new Scanner(System.in);
	
	mostrarTabuleiro(Tabuleiro);
	
	while(true) {
	playerTurn(Tabuleiro, scanner);
	if (GameOver(Tabuleiro)) {
		break;
	}
	mostrarTabuleiro(Tabuleiro);
	computerTurn(Tabuleiro);
	mostrarTabuleiro(Tabuleiro);	
	
 }

}
	private static boolean GameOver(char[][] tabuleiro) {
		
		if (quemGanhou(tabuleiro, 'X')) {
			mostrarTabuleiro(tabuleiro);
			System.out.println("Parabéns. O Jogador Ganhou!");
			return true;
		}
		if (quemGanhou(tabuleiro, 'O')) {
			mostrarTabuleiro(tabuleiro);
			System.out.println("O Computador Ganhou!");
			return true;
		}

		
		for (int i= 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == ' ') {
					return false;
				}
				
			}
		}
		mostrarTabuleiro(tabuleiro);
		System.out.println("Deu velha!");
		return true;
		
	}
	private static boolean quemGanhou(char[][]tabuleiro, char simbolo) {
		if ((tabuleiro[0][0] ==  simbolo && tabuleiro[0][1] == simbolo && tabuleiro [0][2] == 'X') ||
			(tabuleiro[1][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro [1][2] == 'X')||
			(tabuleiro[2][0] == simbolo && tabuleiro[2][1] == simbolo && tabuleiro [2][2] == 'X')||
			
			(tabuleiro[0][0] == simbolo && tabuleiro[1][0] == simbolo && tabuleiro [2][0] == simbolo)||
			(tabuleiro[0][1] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro [2][1] == simbolo)||
			(tabuleiro[0][2] == simbolo && tabuleiro[1][2] == simbolo && tabuleiro [2][2] == simbolo)||
			
			(tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro [2][2] == simbolo)||
			(tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro [2][0] == simbolo)){
			return true;
		}
		return false;
	}
	private static void computerTurn(char[][] Tabuleiro) {
		Random rand = new Random();
		
		int computerMove;
		while(true) {
			computerMove = rand.nextInt(9) + 1;
			if (MovimentoValido(Tabuleiro, computerMove)) {
				break;
			}
		}
		System.out.println("O computador jogou na posição " + computerMove);
		localDaJogada(Tabuleiro, Integer.toString(computerMove), 'O');
	}
	
	
	private static boolean MovimentoValido(char Tabuleiro[][], int posicao) {
		switch(posicao) {
		case 1:
			return (Tabuleiro[0][0] == ' ') ;
		case 2:
			return (Tabuleiro[0][1] == ' ') ;
		case 3:
			return (Tabuleiro[0][2] == ' ') ;
		case 4:
			return (Tabuleiro[1][0] == ' ') ;
		case 5:
			return (Tabuleiro[1][1] == ' ') ;
		case 6:
			return (Tabuleiro[1][2] == ' ') ;
		case 7:
			return (Tabuleiro[2][0] == ' ') ;
		case 8:
			return (Tabuleiro[2][1] == ' ') ;
		case 9:
			return (Tabuleiro[2][2] == ' ') ;
		default:
			return false;
		}
	}	
	
	
	
	private static void playerTurn(char[][] Tabuleiro, Scanner scanner) {
		String playerMove;
		while (true) {
 			System.out.println("Em que posição será sua jogada? Digite um número de 1 a 9");
 			playerMove = scanner.nextLine();
 			if (MovimentoValido(Tabuleiro, Integer.parseInt(playerMove))) {
 				break;
 			} else {
 				System.out.println("Jogada inválida!");
 			}
	  }
		localDaJogada(Tabuleiro, playerMove, 'X');
}
	

	
	private static void localDaJogada(char[][] Tabuleiro, String posicao, char simbolo) {
		switch(posicao) {
		case "1":
			Tabuleiro[0][0] = simbolo;
			break;
		case "2":
			Tabuleiro[0][1] = simbolo;
			break;
		case "3":
			Tabuleiro[0][2] = simbolo;
			break;
		case "4":
			Tabuleiro[1][0] = simbolo;
			break;
		case "5":
			Tabuleiro[1][1] = simbolo;
			break;
		case "6":
			Tabuleiro[1][2] = simbolo;
			break;
		case "7":
			Tabuleiro[2][0] = simbolo;
			break;
		case "8":
			Tabuleiro[2][1] = simbolo;
			break;
		case "9":
			Tabuleiro[2][2] = simbolo;
			break;
		default:
			System.out.println("Insira uma entrada válida");

		}
	}

	private static void mostrarTabuleiro(char[][] Tabuleiro) {
		System.out.println(Tabuleiro[0][0] + "|" + Tabuleiro[0][1] + "|" + Tabuleiro[0][2] + "|");
		System.out.println(" +-+-+-");
		System.out.println(Tabuleiro[1][0] + "|"  + Tabuleiro[1][1] + "|" + Tabuleiro[1][2] + "|");
		System.out.println(" +-+-+-");	
		System.out.println(Tabuleiro[2][0] + "|" + Tabuleiro[2][1] + "|" + Tabuleiro[2][2] + "|");
	}
}