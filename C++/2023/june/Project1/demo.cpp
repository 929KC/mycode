#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include"demo1.h"
using namespace std;
//int rand = 10;
//int main()
//{
//
//	printf("%dln", rand);//rand������һ������,��ʱ��ӡ��ʱ��,��������û�취�������������ȫ�ֱ�������Ҫʹ�ÿ�����ĺ���
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
//using namespace kc; //�����ռ���������,����ÿռ�������е������г�ͻ���ɻᱨ��
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
//	//cout << 'a', 'b', 'd';ֻ���ӡa
//
//	return 0;
//}

//ȱʡ
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


//ȫȱʡ
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

//��ȱʡ
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


//ȱʡ����������������,��Ȼ�ͻᱨ��
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

//14+20++11+25+16+18+9 ����������
//void Func2(int a) 
//{
//	cout << "a=" <<a << endl;
//}
////ȱʡ���������ں��������Ͷ���ʱͬʱʹ��,��Ȼ�������޷�ȷ������ʹ���Ǹ�,
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

//��ȷʾ��
//int x = 30;//ȫ�ֱ���
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
//��������
//��������ֻ�Ͳ����б��й�
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

//����
//���ý��������ı���,��û�п����µĿռ�,���������õı��������ڴ�ռ�
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
//	//���ñ����ʼ��
//	//int& b;
//	int& b = a;
//	//����һ��������һ������,�㲻�����ñ�ı�����
//	//int b = c;
//
//	return 0;
//}

//������
//int main()
//{	
//	//Ȩ�޲��ܷŴ�,������С,�Լ�Ȩ��ƽ��,const���εı���ֻ�ܱ���,�����ܱ��޸ģ�����������b�ɶ���д
//	const int a = 90;
//	//int& b = a;Ȩ�޲��ܷŴ�
//	//Ȩ��ƽ��
//	const int& c = a;
//
//	return 0;
//}
//����ʹ�ó���

//1.������
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
//2.������ֵ
//int& Count()
//{
//	//n�����ھ�̬��������ֻ��һ��,���Գ��˺���û�б�����
//	static int n = 0;
//	n++;
//	return n;
//}
//int& Add(int a, int b)
//{
//	int c = a + b;
//	return c;//c���˺���c��û�ˣ����Դ�ӡ��һ�����ֵ
//}
//int main()
//{
//	int& ret = Add(0, 12);
//	int& ret2 = Count();
//	cout << "ret= " << ret << endl;
//	cout << "ret2= " << ret2 << endl;
//	return 0;
//}

