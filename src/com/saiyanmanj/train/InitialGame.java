package com.saiyanmanj.train;

import com.saiyanmanj.User.User;
import com.saiyanmanj.chessBoard.Board;
import com.saiyanmanj.judgeWinner.JudgeWinner;

public class InitialGame {//初始化游戏
    private User white = new User();//白子
    private User black = new User();//黑子
    private Board board = new Board();//棋盘
    private JudgeWinner judgeWinner = new JudgeWinner();//判断赢家
    private boolean isContinueGame = true;//是否继续下棋
    private String winner;//赢家

    private int points;


    public void initialBoard(){
        judgeWinner.setContinueGame(true);
        judgeWinner.setHasWinner(false);
        judgeWinner.setWinnerName("");
        points = 0;
        board.setChessBoard();
    }

    public void showBoard(){
        board.print();
    }

    public void setBoardWidth(int n){
        board.setChessBoardWidth(n);
    }

    public void input(int x,int y,User user){
        if (board.input(x,y,user.getUserFlag()) == true)
            points++;
    }

    public User getWhite() {
        return white;
    }

    public void setWhite(User white) {
        this.white = white;
    }

    public User getBlack() {
        return black;
    }

    public void setBlack(User black) {
        this.black = black;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public JudgeWinner getJudgeWinner() {
        return judgeWinner;
    }

    public void setJudgeWinner(JudgeWinner judgeWinner) {
        this.judgeWinner = judgeWinner;
    }

    public boolean isContinueGame() {
        if (points==board.getChessBoardWidth() * board.getChessBoardWidth()){//旗子已满
            isContinueGame = false;
        }else {
            judgeWinner.judge(board.getChessBoard(),black);//判断是否有赢家
            judgeWinner.judge(board.getChessBoard(),white);
            isContinueGame = judgeWinner.isContinueGame();
            winner = judgeWinner.getWinnerName();
        }
        return isContinueGame;
    }

    public void setContinueGame(boolean continueGame) {
        isContinueGame = continueGame;
    }

    public String getWinner() {
        if (winner==null) return "no winner";
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
