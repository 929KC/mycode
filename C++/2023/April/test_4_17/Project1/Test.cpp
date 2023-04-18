#include<iostream>
#include <vector>
using namespace std;
//using namespace std;标准库中的东西存在位置
// 1,项目中,尽量不要使用using namespce std
// 2,日常练习用using namespce std
// 3,项目中,制定命名空间访问+展开常用
//1.rand为全局变量.
//2.C语言库中也有一个rand函数：error C2365: “rand”: 重定义；以前的定义是“函数”
//变量默认从全局中去找
//namespace kc
//{
//	int rand = 99;
//}
//using namespace kc;
//将命名空间展开使得里面的变量暴露出来,就像在全局域中一样，
//当上述命名空间中的变量展开后,rand就不明确了,因为库里有一个,命名空间里有一个,编译器就傻眼了

//int main()
//		printf("%d\n",rand); //int(__cdecl*)(void)
//		printf("%d\n", kc::rand);//::去使用命名空间中的变量
//	return 0;
//}
//展开常用
//using std::cout;
//using std::endl;
//
//int main()
//{
//	//指定命名空间使用
//	std::vector<int> v;
//	cout << "Hello World" << endl;
//	return 0;
//}

//int main()
//{
//	int a;
//	int b;
//	//流提取 cin
//	cin >> a >> b;
//	//流插入,endl相当于"/n"
//	cout << a << endl;
//	cout << b << endl;
//	cout << "Hello Wolrd" << endl;
//	return 0;
//}
