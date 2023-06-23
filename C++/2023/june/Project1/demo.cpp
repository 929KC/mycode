#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include"demo1.h"
using namespace std;
//int rand = 10;
//int main()
//{
//
//	printf("%dln", rand);//rand库中是一个函数,此时打印的时候,编译器是没办法区别上述定义的全局变量还是要使用库里面的函数
//	return 0;
//}

//namespace kc 
//{
//	int rand = 99;
//	int time = 9090;
//	int a = 9091;
//	int Add(int a, int b) 
//	{
//		return a + b;
//	}
//	struct Person {
//		int age = 0;
//		
//	};
//}
//using kc::time;
//using namespace kc; //命名空间名称引用,如果该空间中与库中的内容有冲突依旧会报错
//int main()
//{
//	kc::Person p;
//	printf("%d\n", kc::rand);
//	printf("%d\n", kc::Add(12, 12));
//	printf("%d\n", time);
//	printf("%d\n", a);
//	printf("%d\n", p.age);
//	return 0;
//}

//int main()
//{
//	
//	int a;
//	int c;
//	int d;
//	cin >> c;
//	cin >> d;
//	cout << "Hello World" << endl;
//	cout << 12 << endl;
//	cout << 'l' << endl;
//	cout << 'a' << endl;
//	//cout << 'a', 'b', 'd';只会打印a
//
//	return 0;
//}

//缺省
//void Func(int a = 90)
//{
//	cout << a << endl;
//}
//
//int main()
//{
//
//	Func();
//	Func(100);
//}


//全缺省
//void Func(int a = 0, int b = 90, int d = 78)
//{
//
//	cout << "a=" << a << endl;
//	cout << "b=" << b  << endl;
//	cout << "d=" << d << endl;
//}
//int main()
//{
//	Func();
//	Func(90, 90, 90);
//	return 0;
//}

//半缺省
//void Func(int a, int b = 90, int c = 90)
//{
//	cout << "a=" << a << endl;
//	cout << "b=" << b << endl;
//	cout << "c=" << c<< endl;
//}
//
//int main()
//{
//	Func(12);
//	Func(23,90,89);
//
//	return 0;
//}


//缺省参数必须从右往左给,不然就会报错
//void Func(int a=90, int b , int c = 90)
//{
//	cout << "a=" << a << endl;
//	cout << "b=" << b << endl;
//	cout << "c=" << c << endl;
//}
//
//int main()
//{
//	Func(12,12);
//	Func(23, 90, 89);
//
//	return 0;
//}

//14+20++11+25+16+18+9 慢慢的罪恶感
//void Func2(int a) 
//{
//	cout << "a=" <<a << endl;
//}
////缺省参数不能在函数声明和定义时同时使用,不然编译器无法确定到底使用那个,
//void Func(int a=90)
//{
//	cout << "a=" << a << endl;
//}
//int main()
//{
//	Func(12);
//	Func2(12);
//	return 0;
//}

