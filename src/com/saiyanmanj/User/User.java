package com.saiyanmanj.User;

import java.util.Scanner;

public class User {//玩家
    private String name;//姓名
    private char userFlag;//棋子符号

    static char[] flag = {'o','x'};
    static boolean[] chosen = new boolean[2];

    public void chooseUserFlag(){
        if (chosen[0] == true && chosen[1] == true){
            System.out.println("all player has been chosen");
            return;
        }
        if (chosen[0] == false && chosen[1] == false)
            System.out.println("choose a flag to yourself, input 0, o is your flag, input 1, x is your flag");
        if (chosen[0]==true){
            System.out.printf("the other player has chosen, you just have one choice, that is to use %c \n",flag[1]);
            setUserFlag(flag[1]);
            chosen[1] = true;
            return;
        }
        if (chosen[1]==true){
            System.out.printf("the other player has chosen, you just have one choice, that is to use %c \n",flag[0]);
            setUserFlag(flag[0]);
            chosen[0] = true;
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            int n = scanner.nextInt();
            if (n==0){
                setUserFlag(flag[0]);
                chosen[0] = true;
                break;
            }else if (n==1){
                setUserFlag(flag[1]);
                chosen[1] = true;
                break;
            }else {
                System.out.println("wrong number,please input 0 or 1!");
            }
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(char userFlag) {
        this.userFlag = userFlag;
    }
}
