package com.saiyanmanj.chessBoard;

import java.util.Scanner;

public class Board {//棋盘类
    private char[][] chessBoard;//棋盘数组
    private int chessBoardWidth;//棋盘数组的大小（正方形）

    public boolean input(int x,int y,char c){//落子
        boolean isWrong = true;
        while(isWrong == true){
            if (x - 1 < 0 || x - 1 >= chessBoardWidth || y - 1 < 0 || y - 1 >= chessBoardWidth){
                System.out.println("outBound error please reInput");
            } else if (chessBoard[x - 1][y - 1] != '+'){
                System.out.println("this point has been used,please reInput");
            }else {
                isWrong = false;
            }
            if (isWrong == true){
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
        }
        chessBoard[x - 1][y - 1] = c;
        return true;
    }

    public void print(){//打印棋盘
        System.out.printf("%4d",0);
        for (int i = 0; i < chessBoardWidth; i++) {
            System.out.printf("%4d",i + 1);
        }
        System.out.println();
        for (int i = 0; i < chessBoardWidth; i++) {
            System.out.printf("%4d",i + 1);
            for (int j = 0; j < chessBoardWidth; j++) {
                System.out.printf("%4c",chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard() {//初始化棋盘
        chessBoard = new char[chessBoardWidth][chessBoardWidth];
        for (int i = 0; i < chessBoardWidth; i++) {
            for (int j = 0; j < chessBoardWidth; j++) {
                chessBoard[i][j] = '+';
            }
        }
    }

    public int getChessBoardWidth() {
        return chessBoardWidth;
    }

    public void setChessBoardWidth(int chessBoardWidth) {
        this.chessBoardWidth = chessBoardWidth;
        setChessBoard();
    }
}
