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
//		cout << "���Ǻ�ѧ��" << endl;
//		return 1;
//	}
//	//����д��������
//	void ShowInfo(int i);
//	void ShowInfo()
//	{
//		cout << "age=" << _age << " name=" << _name << " address=" << _address << endl;
//	}
//private:
//	int _age = 19;
//	string _name = "Ҷ�ﺮ";
//	string _address = "���ϳ���";
//	
//};
////::���������ָ����Ա�����Ǹ�������
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

// ���м��г�Ա���������г�Ա����
class A1 {
public:
	void f1() {}
private:
	int _a; //4 8 -->4
	int _age; //4 8 -->4
	char _c; //1 8  -->1
	double _d;//8 8 -->8
};
// ���н��г�Ա����
class A2 {
public:
	void f2() {}
};
// ����ʲô��û��---����
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
//���ۣ�һ����Ĵ�С��ʵ�ʾ��Ǹ����С���Ա������֮�ͣ���ȻҲҪ�����ڴ���룬ע�����Ĵ�С��
//����Ƚ����⣬���������˿���һ���ֽ���Ψһ��ʶ����ࣨռλ����