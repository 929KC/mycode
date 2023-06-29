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
class A1 {
public:
	void f1() {}
private:
	int _a; //4 8 -->4
	int _age; //4 8 -->4
	char _c; //1 8  -->1
	double _d;//8 8 -->8
};
// 类中仅有成员函数
class A2 {
public:
	void f2() {}
};
// 类中什么都没有---空类
class A3
{};
class  Date
{
public:
	void Display()
	{
		cout << "year=" << _year << "month" << _month << "day" << _day;
	}
	void SetDate(int year, int month, int day)
	{
		this->_year = year;
		this->_month = month;
		this->_day = day;
	}
private:
	int _year=0;
	int _month=0;
	int _day=0;
};
int main()
{
	cout << sizeof(A1) << endl;;
	cout << sizeof(A2) << endl;
	cout << sizeof(A3) << endl;
	Date date;
	date.Display();
	date.SetDate(12, 12, 21);
	return 0;
}
//结论：一个类的大小，实际就是该类中“成员变量”之和，当然也要进行内存对齐，注意空类的大小，
//空类比较特殊，编译器给了空类一个字节来唯一标识这个类（占位）。