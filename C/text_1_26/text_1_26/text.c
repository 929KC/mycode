#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include <string.h>

//void resever(char* arr)
//{
//	char* left = arr;
//	char* right = arr + strlen(arr) - 1;
//	while (left < right)
//	{
//		char temp = *left;
//		*left = *right;
//		*right = temp;
//		left++;
//		right--;
//	}
//}
//
//int Strlen(char* str)
//{
//	char* temp = str;
//	while (*temp++)
//	{
//		;
//	}
//
//	return temp - str - 1;
//}
//
//void test1(char* arr)
//{
//	int len = Strlen(arr);
//
//	printf("%d", len);
//}
//
//void test()
//{
//	char arr[1024] = { 0 };
//
//	scanf("%s", arr);
//
//	test1(arr);
//	//resever(arr);
//
//	printf("%s", arr);
//}

//编写代码计算一个整数存储在内存中二进制的1的个数

//int main()
//{
//	int number = 0;
//	int count = 0;
//
//	scanf("%d", &number);
//
//	for (int i = 0; i < 32; i++)
//	{
//		if (1 == ((number >> i) & 1))
//		{
//			count++;
//		}
//	}
//	printf("%d", count);
//
//
//	return 0;
//}
//不能创建临时变量（第三个变量），实现两个数的交换。

//int main()
//{
//	int a = 3;
//	int b = 5;
//	printf("a=%d b=%d\n", a, b);
//	a = a ^ b;
//	b = a ^ b;
//	a = a ^ b;
//	printf("a=%d b=%d\n", a, b);
//	return 0;
//}

//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int count = 0;
//	scanf("%d %d", &a, &b);
//	c = a ^ b;
//	for (int i = 0; i < 32; i++)
//	{
//		if (1 == ((c >> i) & 1))
//		{
//			count++;
//		}
//	}
//	printf("%d", count);
//	return 0;
//}

//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	printf("偶数位：");
//	for (int i = 0; i < 32; i += 2) {
//		printf("%d ", (a >> i) & 1);
//	}
//	printf("\n");
//	printf("奇数位：");
//	for (int i = 1; i < 32; i += 2)
//	{
//		printf("%d ", (a >> i) & 1);
//	}
//	return 0;
//}

int main()
{
	int number = 0;
	scanf("%d", &number);
	for (int i = 1; i <= number; i++)
	{
		for (int j = 1; j <=number - i; j++)
		{
			printf(" ");
		}

		for (int k = 1; k <= 2 * i - 1; k++)
		{
			printf("*");
		}

		printf("\n");

	}

	for (int i = 1; i<=6; i++)
	{
		for (int j = 1; j <= i;j++)
		{
			printf(" ");
		}
		for (int k = 11; k >= 2*i-1; k--)
		{
			printf("*");
		}
		printf("\n");
	}
	
	
	return 0;
}