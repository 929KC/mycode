package inner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 15:35
 */

public class Text2 {
    public static void main(String[] args) {
        IPlayGame ip = () ->{
            System.out.println("学生打游戏！");
        };
       playGame(ip);
        System.out.println("---------------");
        IPlayGame ip2 = ()-> {
            System.out.println("老师打游戏！");
        };
        playGame(ip2);
    }

    public static void  playGame(IPlayGame i){
        System.out.println("开始游戏");
        i.PlayGame();
        System.out.println("结束游戏");
    }

}

interface IPlayGame {
    void PlayGame();
}
