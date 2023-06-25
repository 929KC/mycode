#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include"demo1.h"
#include <time.h>
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

//正确示例
//int x = 30;//全局变量
//
//void Print(int a, int b = 20, int c =x)
//{
//	cout << a << endl;
//	cout << b << endl;
//	cout << c << endl;
//}
//
//
//int main()
//{
//	Print(12);
//	return 0;
//}
//函数重载
//函数重载只和参数列表有关
//int  Add(int a, int b)
//{
//	return a + b;
//}
//int Add(int a, int b, int c)
//{
//	
//	return a + b + c;
//}
//double Add(double a,double b)
//{
//	return a + b;
//}
//
//int main()
//{
//	int ret1 = Add(12, 12);
//	int ret2 = Add(12, 12, 12);
//	double ret3 = Add(12.3, 32.2);
//	cout << ret1 << endl;
//	cout << ret2 << endl;
//	cout << ret3 << endl;
//	return 0;
//}

//引用
//引用仅仅变量的别名,并没有开辟新的空间,它和它引用的变量共享内存空间
//int main()
//{
//	int a = 90;
//	int& b = a;
//	int& c = b;
//	int& d = c;
//	
//	cout << "a=" << a << " &a= " << &a << endl;
//	cout << "b=" << b << " &b= "<< &b << endl;
//	cout << "c=" << c << " &c= " << &c << endl;
//	cout << "d=" << d << " &d= " << &d << endl;
//	return 0;
//}

//int main()
//{	
//	int a = 90;
//	int c = 90;
//	//引用必须初始化
//	//int& b;
//	int& b = a;
//	//引用一旦引用了一个变量,便不能引用别的变量了
//	//int b = c;
//
//	return 0;
//}

//常引用
//int main()
//{	
//	//权限不能放大,可以缩小,以及权限平移,const修饰的变量只能被读,而不能被修改，而引用类型b可读可写
//	const int a = 90;
//	//int& b = a;权限不能放大
//	//权限平移
//	const int& c = a;
//
//	return 0;
//}
//引用使用场景

//1.做参数
//void Swap(int& a, int& b)
//{
//	int temp = a;
//	 a = b;
//	 b = temp;
//	cout << "a=" << a << " b=" << b << endl;
//}
//void Swap(int *a, int  *b)
//{
//	int *temp = a;
//	a = b;
//	b = temp;
//	/*cout << "a=" << a << " b=" << b << endl;*/
//}
//int main()
//{
//	int a = 90;
//	int b = 99;
//	Swap(&a,&b);
//	/*int c = 90;
//	int* d = &c;
//	cout << "d=" << d << "&d=" << &d << endl;*/
//	/*int c = 90;
//	int* d = &c;*/
//	cout << "a=" << a << "b=" << b << endl;
//	return 0;
//}
//2.做返回值
//int& Count()
//{
//	//n保存在静态区本身就只有一份,所以出了函数没有被销毁
//	static int n = 0;
//	n++;
//	return n;
//}
//int& Add(int a, int b)
//{
//	int c = a + b;
//	return c;//c出了函数c就没了，所以打印了一个随机值
//}
//int main()
//{
//	int& ret = Add(0, 12);
//	int& ret2 = Count();
//	cout << "ret= " << ret << endl;
//	cout << "ret2= " << ret2 << endl;
//	return 0;
//}

//传值和传引用的效率比较

//struct A { int a[10000]; };
//void TestFunc1(A a) {}
//void TestFunc2(A& a) {}
//void TestRefAndValue()
//{
//	A a;
//	// 以值作为函数参数
//	size_t begin1 = clock();
//	for (size_t i = 0; i < 10000; ++i)
//		TestFunc1(a);
//	size_t end1 = clock();
//	// 以引用作为函数参数
//	size_t begin2 = clock();
//	for (size_t i = 0; i < 10000; ++i)
//		TestFunc2(a);
//	size_t end2 = clock();
//	// 分别计算两个函数运行结束后的时间
//	cout << "TestFunc1(A)-time:" << end1 - begin1 << endl;
//	cout << "TestFunc2(A&)-time:" << end2 - begin2 << endl;
//}
//
//int main()
//{
//	
//	TestRefAndValue();
//	return 0;
//}


// 值和引用的作为返回值类型的性能比较
struct A { int a[10000]; };
A a;
// 值返回
//A TestFunc1() { return a; }
//// 引用返回
//A& TestFunc2() { return a; }
//void TestReturnByRefOrValue()
//{
//	// 以值作为函数的返回值类型
//	size_t begin1 = clock();
//	for (size_t i = 0; i < 100000; ++i)
//		TestFunc1();
//	size_t end1 = clock();
//	// 以引用作为函数的返回值类型
//	size_t begin2 = clock();
//	for (size_t i = 0; i < 100000; ++i)
//		TestFunc2();
//	size_t end2 = clock();
//	// 计算两个函数运算完成之后的时间
//	cout << "TestFunc1 time:" << end1 - begin1 << endl;
//	cout << "TestFunc2 time:" << end2 - begin2 << endl;
//}
//
//int main()
//{
//	TestReturnByRefOrValue();
//	return 0;
//}

//6 引用和指针的区别
//引用和指针的不同点:
//1. 引用概念上定义一个变量的别名，指针存储一个变量地址。
//2. 引用在定义时必须初始化，指针没有要求
//3. 引用在初始化时引用一个实体后，就不能再引用其他实体，而指针可以在任何时候指向任何一个同类型
//实体
//4. 没有NULL引用，但有NULL指针
//5. 在sizeof中含义不同：引用结果为引用类型的大小，但指针始终是地址空间所占字节个数(32位平台下占
//	4个字节)
//	6. 引用自加即引用的实体增加1，指针自加即指针向后偏移一个类型的大小
//	7. 有多级指针，但是没有多级引用
//	8. 访问实体方式不同，指针需要显式解引用，引用编译器自己处理
//	9. 引用比指针使用起来相对更安全

//int main()
//{
//	int a = 10;
//
//	int& ra = a;
//	ra = 20;
//
//	int* pa = &a;
//	*pa = 20;
//	cout << "";
//	return 0;
//}


 inline int Add(int left, int right)
{
	return left + right;
}
int main()
{
	int ret = Add(12, 23);
	return 0;
}