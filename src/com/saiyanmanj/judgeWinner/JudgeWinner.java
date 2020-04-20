package com.saiyanmanj.judgeWinner;

import com.saiyanmanj.User.User;

public class JudgeWinner {
    private String winnerName;
    private boolean hasWinner = false;
    private boolean continueGame = true;

    public void judge(char[][] board, User user){//判断该玩家是不是赢家
        for (int i = 0; i < board.length && isContinueGame(); i++) {
            for (int j = 0; j < board[i].length && isContinueGame(); j++) {
                if(board[i][j] == user.getUserFlag()){
                    if(count(board,i,j)){
                        setHasWinner(true);
                        setWinnerName(user.getName());
                        setContinueGame(false);
                    }
                }
            }
        }
    }
    public boolean count(char[][] board,int x,int y){//判断五子棋是否有5个棋子在一条线上
        int i,j;

        /*水平*/
        for (i = y;i - 1 > -1 && board[x][i - 1] == board[x][y];i--);
        for (j = y;j + 1 < board.length && board[x][j + 1] == board[x][y];j++);
        if (j - i >= 4)  return true;

        /*垂直*/
        for (i = x;i - 1 > -1 && board[i - 1][y] == board[x][y];i--);
        for (j = x;j + 1 < board.length && board[j + 1][y] == board[x][y];j++);
        if (j - i >= 4 ) return true;
        /*右对角线*/
        int startX = 0,endX = 0;
        for (i = x,j = y;  i - 1 > 0 && j + 1< board.length && board[x][y] == board[i - 1][j + 1]; i--,j++)
            startX = i;
        for (i = x,j = y;  i + 1 < board.length && j - 1 > 0 && board[x][y] == board[i + 1][j - 1]; i++,j--)
            endX = i;
        if(endX - startX >= 4) return true;
        /*左对角线*/
        for (i = x,j = y;i - 1 > -1 && j - 1 > -1 && board[x][y]==board[i - 1][y - 1];i--,j--) {
            startX = i;
        }
        for (i = x,j = y;i + 1 < board.length && j + 1 < board.length && board[x][y]==board[i + 1][y + 1];i++,j++) {
            endX = i;
        }
        if(endX - startX >= 4) return true;

        return false;
    }

    public boolean isContinueGame() {
        return continueGame;
    }

    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public boolean isHasWinner() {
        return hasWinner;
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }
}
