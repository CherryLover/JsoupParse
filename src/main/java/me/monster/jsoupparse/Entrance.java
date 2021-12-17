package me.monster.jsoupparse;

/**
 * @description
 * @author: Created jiangjiwei in 2021/12/3 10:47 上午
 */
public class Entrance {
    public static void main(String[] args) {
        InfoHelper.INSTANCE.printInfos();

        System.out.println(System.getProperty("user.dir"));

        Parse.INSTANCE.parse("https://zh.birdpoty.com/2021-winners");
    }
}
