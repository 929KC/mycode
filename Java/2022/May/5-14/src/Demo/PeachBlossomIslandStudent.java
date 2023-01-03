package Demo;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 09:32
 */

public class PeachBlossomIslandStudent {
   private String name;
   private String sex;
   private double height;
  public static  String  teacher="黄药师";

    //静态方法
    public static void flute(){

        System.out.println("碧海潮生曲");
    }

    public static void sword(){
        System.out.println("落英神剑掌");
    }
    //成员方法
    public void study(PeachBlossomIslandStudent  this){
        this.name="叶子秋";
        System.out.println("好好学习");
      }

    public static void main(String[] args) {
        PeachBlossomIslandStudent s=new PeachBlossomIslandStudent();
        s.name="陈玄风";
        s.sex="男";
        s.height=1.90;
        PeachBlossomIslandStudent s2=new PeachBlossomIslandStudent();
        s2.name="梅超风";
        s2.sex="女";
        s2.height=1.70;
    }
}
