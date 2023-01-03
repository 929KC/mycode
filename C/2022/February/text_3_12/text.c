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
////演示实例
//int main()
//{
//	int n = 10;
//	char* pc = (char*)&n;
//	int* pi = &n;
//	printf("%p\n", &n);
//	printf("%p\n", pc);
//	printf("%p\n", pc + 1);//pc为字符指针 一个char就只一个字节 pc+1意味着地址加1
//	printf("%p\n", pi);
//	printf("%p\n", pi + 1);//pi为字符指针 一个int就只一个字节 pi+1意味着地址加4
//	return  0;
//}