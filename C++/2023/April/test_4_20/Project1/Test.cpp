#include<iostream>
using namespace std;


//引用是给变量的别名
//int main()
//{
//	int a = 0;
//	int& b = a;//引用
//	cout << b << endl;
//	cout << &a << endl;//取地址
//	cout << &b << endl;
//	a++;
//	b++;
//	return 0;
//}

//int main()
//{
//	//int& b 引用必须在定义的时候初始化
//	//一个变量可以有多个引用
//	int a = 1;
//	int& b = a;
//	int& c = b;
//	int& d = c;
//	a++;
//	int x = 10;
//	//引用一旦引用了一个实体,再也不能引用给实体
//	b = x;//x赋值给b
//	return 0;
//}
//

//引用实际运用场景
void Swap(int& r1, int& r2)
{
	int temp = r1;
	r1 = r2;
	r2 = temp;
}

int main()
{
	int a = 90;
	int b = 12;
	return 0;
}