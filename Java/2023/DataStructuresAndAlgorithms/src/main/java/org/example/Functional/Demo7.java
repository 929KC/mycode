//package org.example.Functional;
//
//import org.example.Functional.model.User;
//
//import java.util.Optional;
//import java.util.function.Supplier;
//
//public class Demo7 {
//    public static void main(String[] args) {
//        User user = new User("张三","12");
//        Optional<User> user1 = Optional.ofNullable(user);
//        Optional<String> s = user1.map(user2 -> user2.getUsername());
//        s.ifPresent(s2-> System.out.println(s2));
//    }
//
//   private static Optional<User> getUser() {
//       User user = new User("张三","12");
//       //返回的类型为Optional<User>,返回之前是无法保证这个对象一定是非空,所以当可能是null时,我们
//       //返回一个Optional.empty()
//       return user==null?Optional.empty(): Optional.of(user);
//   }
//}
