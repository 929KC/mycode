#include<iostream>
using namespace std;


//�����Ǹ������ı���
//int main()
//{
//	int a = 0;
//	int& b = a;//����
//	cout << b << endl;
//	cout << &a << endl;//ȡ��ַ
//	cout << &b << endl;
//	a++;
//	b++;
//	return 0;
//}

//int main()
//{
//	//int& b ���ñ����ڶ����ʱ���ʼ��
//	//һ�����������ж������
//	int a = 1;
//	int& b = a;
//	int& c = b;
//	int& d = c;
//	a++;
//	int x = 10;
//	//����һ��������һ��ʵ��,��Ҳ�������ø�ʵ��
//	b = x;//x��ֵ��b
//	return 0;
//}
//

//����ʵ�����ó���
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