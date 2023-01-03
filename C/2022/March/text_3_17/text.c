#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

//void prints(char  **arr)
//{
//	printf("%s\n", *arr);
//}
//
//int main()
//{
//	char* arr[5] = { "hello","bit" };
//	prints(arr);
//
//	return 0;
//}
void prints(int   **pa)
{
	printf("%d\n", *(*pa));
}
int main()
{
	int a = 0;
	int* p = &a;
	int* pa = &p;
	prints(pa);
	return 0;
}