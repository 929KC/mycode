#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	int a = 0x11223344;
	int* pa = &a;
	*pa = 0;
	/*char* pa = &a;
	*pa = 0;*/
	return 0;
}

//#include <stdio.h>
////��ʾʵ��
//int main()
//{
//	int n = 10;
//	char* pc = (char*)&n;
//	int* pi = &n;
//	printf("%p\n", &n);
//	printf("%p\n", pc);
//	printf("%p\n", pc + 1);//pcΪ�ַ�ָ�� һ��char��ֻһ���ֽ� pc+1��ζ�ŵ�ַ��1
//	printf("%p\n", pi);
//	printf("%p\n", pi + 1);//piΪ�ַ�ָ�� һ��int��ֻһ���ֽ� pi+1��ζ�ŵ�ַ��4
//	return  0;
//}