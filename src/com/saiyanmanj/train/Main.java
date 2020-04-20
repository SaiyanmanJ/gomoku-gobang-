package com.saiyanmanj.train;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        InitialGame initialGame = new InitialGame();
        while (true){
            System.out.println("please input the widen of board, input number must big or equal 5");
            int n = scanner.nextInt();
            if (n >= 5){
                initialGame.setBoardWidth(n);
                break;
            } else {
                System.out.println("smaller than 5, please reInput");
            }
        }

        /*玩家姓名*/
        initialGame.getWhite().setName("white");
        initialGame.getBlack().setName("black");

        /*玩家棋子符号*/
        initialGame.getWhite().chooseUserFlag();
        initialGame.getBlack().chooseUserFlag();

        System.out.printf("white use %c and black use %c \n game start \n",initialGame.getWhite().getUserFlag(),initialGame.getBlack().getUserFlag());
        int x,y;
        /*开始下棋*/
        while(initialGame.isContinueGame()){
            System.out.println("black please input first!");//黑棋先行
            x = scanner.nextInt();
            y = scanner.nextInt();
            initialGame.input(x,y,initialGame.getBlack());//落子
            initialGame.showBoard();//显示棋盘
            if (!initialGame.isContinueGame()){//判断是否需要继续下棋
                System.out.println("new round yes or no ?");
                if (scanner.next().equals("yes")){//重新开始一轮游戏
                    System.out.println("winner is：" + initialGame.getWinner());
                    initialGame.initialBoard();
                    initialGame.setContinueGame(true);
                    initialGame.setWinner("");
                    continue;
                }else{
                    break;
                }
            }

            System.out.println("white please input !");//白棋...
            x = scanner.nextInt();
            y = scanner.nextInt();
            initialGame.input(x,y,initialGame.getWhite());
            initialGame.showBoard();
            if (!initialGame.isContinueGame()){//判断是否需要继续下棋
                System.out.println("new round yes or no ?");
                if (scanner.next().equals("yes")){//重新开始一轮游戏
                    System.out.println("winner is：" + initialGame.getWinner());

                    initialGame.initialBoard();
                    initialGame.setContinueGame(true);
                    initialGame.setWinner("");
                    continue;
                }else{
                    break;
                }
            }

        }
        System.out.println("winner is：" + initialGame.getWinner());
    }
}
