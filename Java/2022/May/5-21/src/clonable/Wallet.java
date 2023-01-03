package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 19:02
 */

public class Wallet implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    double money = 99;
//    @Override
//    public String toString() {
//        return "Wallet{" +
//                "money=" + money +
//                '}';
//    }
}
