#include<iostream>
using namespace std;

//struct Demo
//{
//	int a = 90;
//	int b = 90;
//	int  Add(int left ,int right)
//	{
//		return left + right;
//    }
//};
//class Person
//{
//public:
//	int  Print()
//	{
//		cout << "我是好学生" << endl;
//		return 1;
//	}
//	//可以写函数声明
//	void ShowInfo(int i);
//	void ShowInfo()
//	{
//		cout << "age=" << _age << " name=" << _name << " address=" << _address << endl;
//	}
//private:
//	int _age = 19;
//	string _name = "叶秋寒";
//	string _address = "湖南郴州";
//	
//};
////::这里的用于指定成员属于那个作用域
//void Person ::ShowInfo(int i)
//{
//	cout << i << endl;
//}
//int main()
//{
//	Demo demo;
//	Person person;
//	int ret = person.Print();
//	cout << demo.a << endl;
//	cout << demo.b << endl;
//	cout << demo.Add(12,12) << endl;
//	cout << demo.Add(12, 12) << endl;
//	cout << ret << endl;
//	person.ShowInfo();
//	person.ShowInfo(12);
//	cout << " " << "" << endl;
//	return 0;
//}

// 类中既有成员变量，又有成员函数
//class A1 {
//public:
//	void f1() {}
//private:
//	int _a; //4 8 -->4
//	int _age; //4 8 -->4
//	char _c; //1 8  -->1
//	double _d;//8 8 -->8
//};
//// 类中仅有成员函数
//class A2 {
//public:
//	void f2() {}
//};
//// 类中什么都没有---空类
//class A3
//{};
//class  Date
//{
//public:
//	void Display()
//	{
//		cout << "year=" << _year << " month" << _month << " day" << _day;
//	}
//	void SetDate(int year, int month, int day)
//	{
//		_year = year;
//		_month = month;
//		_day = day;
//	}
//private:
//	int _year=0;
//	int _month=0;
//	int _day=0;
//};
//int main()
//{
//	/*cout << sizeof(A1) << endl;;
//	cout << sizeof(A2) << endl;
//	cout << sizeof(A3) << endl;*/
//	Date date;
//	date.SetDate(12, 12, 21);
//	date.Display();
//	return 0;
//}
//结论：一个类的大小，实际就是该类中“成员变量”之和，当然也要进行内存对齐，注意空类的大小，
//空类比较特殊，编译器给了空类一个字节来唯一标识这个类（占位）。

//1. this指针存在哪里？
//2. this指针可以为空吗？

//#include <iostream>
//using namespace std;
//class A
//{
//public:
//	void PrintA()
//	{
//		cout << _a << endl;
//	}
//	void Show()
//	{
//		cout << "Show()" << endl;
//	}
//private:
//	int _a;
//};
//指针p确实是一个类的空指针，但当执行第一句代码时，
//程序并不会崩溃。第一句代码并没有对空指针p进行解引用，
//因为Show等成员函数地址并没有存到对象里面，成员函数的地址是存在公共代码段的。
//当程序执行第二句代码时，会因为内存的非法访问而崩溃。执行第二句代码时，
//调用了成员函数PrintA，这里并不会产生什么错误（理由同上），
//但是PrintA函数中打印了成员变量_a，成员变量_a只有通过对this指针进行解引用才能访问到，
//而this指针此时接收的是nullptr，对空进行解引用必然会导致程序的崩溃。
//int main()
//{
//	 A* p = nullptr;
//	 //p->Show();       //第一句代码,正常运行
//	 p->PrintA();     //第二句代码,程序会崩溃,因为没有解引用
//	 return 0;
//}

//class Time
//{
//public:
//	~Time()
//	 {
//		cout << "~Time()" << endl;
//	 }
//private:
//	int _hour;
//	int _minute;
//	int _second;
//
//};
//class  Date
//{
//public:
////	void Display()
////	{
////		cout << "year=" << _year << " month" << _month << " day" << _day;
////	}
////	void SetDate(int year, int month, int day)
////	{
////		_year = year;
////		_month = month;
////		_day = day;
////	}
//	//析构函数:作用销毁对象，不包含内置类型(int,double,long,指针)
//	Date()
//	{
//
//	}
//	~Date()// 析构函数
//	{
//		cout << "我是傻逼,今天不开心,好烦啊!!!" << endl;
//	}
//	Date(int year, int month, int day)
//	{
//		_year = year;
//		_month = month;
//		_day = day;
//	}
//	/*Date(const Date & d)
//	{
//		_year = d._year;
//		_month = d._month;
//		_day = d._day;
//	}
//	Date(const Date  *d)
//	{
//		_year = d->_year;
//		_month = d->_month;
//		_day = d->_day;
//	}*/
//	/*Date( Date  d)
//	{
//		_year = d._year;
//		_month = d.>_month;
//		_day = d._day;
//	}*/
//private:
//	int _year=0;
//	int _month=0;
//	int _day=0;
//	Time _t;
//};

//未定义拷贝构造函数,会生成默认的拷贝构造,内置类型按照字节直接拷贝,自定义类型还需要调用其拷贝构造
//int main()
//{
//	//1.构造函数
//	Date d1;
//	Date d2(12, 12, 12);
//	Date d3(d2);
//	Date d4(d2);
//	cout << "";
//	return 0;
//}

//class Stack
//{
//public:
//	Stack(int capacity = 4)
//	{
//		_ps = (int*)malloc(sizeof(int) * capacity);
//		_size = 0;
//		_capacity = capacity;
//	}
//	Stack(const Stack & s)
//	{
//		cout << "拷贝构造" << endl;
//	}
//
//	void Print()
//	{
//		cout << _ps << endl;// 打印栈空间地址
//	}
//private:
//	int* _ps;
//	int _size;
//	int _capacity;
//};
//int main()
//{
//	Stack s1;
//	s1.Print();// 打印s1栈空间的地址
//	Stack s2(s1);// 用已存在的对象s1创建对象s2
//	s2.Print();// 打印s2栈空间的地址
//	cout << "";
//	cout << &s1 << endl;
//	cout << &s2 << endl;
//
//	return 0;
//}
class Date
{
public:
	Date(int year = 0, int month = 1, int day = 1)
	{
		_year = year;
		_month = month;
		_day = day;
	}
	void Print()
	{
		cout << _year << "年" << _month << "月" << _day << "日" << endl;
	}
	bool operator==(const Date& d)
	{
		return _year == d._year
			&& _month == d._month
			&& _day == d._day;
	}
		 
private:
	int _year;
	int _month;
	int _day;
};

int main()
{
	Date d1;
	Date d2(d1);
	cout << "Hello" << endl;
	return 0;
}
