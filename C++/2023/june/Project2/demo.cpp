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
//class A1 {
//public:
//	void f1() {}
//private:
//	int _a; //4 8 -->4
//	int _age; //4 8 -->4
//	char _c; //1 8  -->1
//	double _d;//8 8 -->8
//};
//// ���н��г�Ա����
//class A2 {
//public:
//	void f2() {}
//};
//// ����ʲô��û��---����
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
//���ۣ�һ����Ĵ�С��ʵ�ʾ��Ǹ����С���Ա������֮�ͣ���ȻҲҪ�����ڴ���룬ע�����Ĵ�С��
//����Ƚ����⣬���������˿���һ���ֽ���Ψһ��ʶ����ࣨռλ����

//1. thisָ��������
//2. thisָ�����Ϊ����

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
//ָ��pȷʵ��һ����Ŀ�ָ�룬����ִ�е�һ�����ʱ��
//���򲢲����������һ����벢û�жԿ�ָ��p���н����ã�
//��ΪShow�ȳ�Ա������ַ��û�д浽�������棬��Ա�����ĵ�ַ�Ǵ��ڹ�������εġ�
//������ִ�еڶ������ʱ������Ϊ�ڴ�ķǷ����ʶ�������ִ�еڶ������ʱ��
//�����˳�Ա����PrintA�����ﲢ�������ʲô��������ͬ�ϣ���
//����PrintA�����д�ӡ�˳�Ա����_a����Ա����_aֻ��ͨ����thisָ����н����ò��ܷ��ʵ���
//��thisָ���ʱ���յ���nullptr���Կս��н����ñ�Ȼ�ᵼ�³���ı�����
//int main()
//{
//	 A* p = nullptr;
//	 //p->Show();       //��һ�����,��������
//	 p->PrintA();     //�ڶ������,��������,��Ϊû�н�����
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
//	//��������:�������ٶ��󣬲�������������(int,double,long,ָ��)
//	Date()
//	{
//
//	}
//	~Date()// ��������
//	{
//		cout << "����ɵ��,���첻����,�÷���!!!" << endl;
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

//δ���忽�����캯��,������Ĭ�ϵĿ�������,�������Ͱ����ֽ�ֱ�ӿ���,�Զ������ͻ���Ҫ�����俽������
//int main()
//{
//	//1.���캯��
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
//		cout << "��������" << endl;
//	}
//
//	void Print()
//	{
//		cout << _ps << endl;// ��ӡջ�ռ��ַ
//	}
//private:
//	int* _ps;
//	int _size;
//	int _capacity;
//};
//int main()
//{
//	Stack s1;
//	s1.Print();// ��ӡs1ջ�ռ�ĵ�ַ
//	Stack s2(s1);// ���Ѵ��ڵĶ���s1��������s2
//	s2.Print();// ��ӡs2ջ�ռ�ĵ�ַ
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
		cout << _year << "��" << _month << "��" << _day << "��" << endl;
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
