#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int x = 5, y = 7;
//void swap()
//{
//	int z;
//	z = x;
//	x = y;
//	y = z;
//}
//
//int main()
//{
//	int x = 3, y = 8;
//	swap();
//	printf("%d,%d\n", x, y);
//	return 0;
//}

//int main()
//{
//	double x[5] = { 2.0,4.0,6.0,8.0,10.0 };
//	char c1[] = { '1','2','3','4','5' };
//	char c2[] = { '\x10','\xa','8'};
//	int y[3 + 5] = { 0,1,3,5,7,9 };
//	for (int i = 0; i < 3; i++)
//	{
//		printf("%c", c2[i]);
//	}
//	return 0;
//}
//int IsSleapYear(int y) 
//{
//	if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))
//	{
//		return 1;
//	}
//	else
//	{
//		return 0;
//	}
//}
//int main()
//{
//	int year = 0;
//	for (int year=1000;year<=2000;year++)
//	{
//		if (IsSleapYear( year) == 1) {
//			printf("%d " ,year);
//		}
//	}
//	return 0;
//}
//void swap(int *x, int *y)
//{
//	int tmp = *x;
//	*x = *y;
//	*y = tmp;
//}
//
//int main()
//{
//	int a = 0;
//	int b = 0;
//	scanf("%d %d", &a, &b);
//	swap(&a, &b);
//	printf("%d %d",a,b);
//	return 0;
//}
//#include <math.h>
//int IsPrime(int x)
//{
//	//2~n-1试除
//	//2~sqrt(n)试除
//	
//	for (int j = 2; j <= sqrt(x); j++)
//	{
//		if (x % j == 0)
//		{
//			return 0;
//		}
//	}
//	return 1;
//}
//
//int main()
//{
//	for (int i = 100; i <= 200; i++)
//	{
//		if (IsPrime(i) == 1)
//		{
//			printf("%d ", i);
//		}
//	}
//	return 0;
//}
//void PrintfGraph(int row, int col)
//{
//	for (int i = 1;i <=row; i++)
//	{
//		for (int j = 1;j <=col; j++)
//		{
//			printf("%d*%d=%2d", i, j, i * j);
//		}
//		printf("\n");
//	}
//}
//void PrintfGraph(int x)
//{
//	for (int i = 1; i <= x; i++)
//	{
//		for (int j = 1; j <= i; j++)
//		{
//			printf("%d*%d=%-2d ", i, j, i * j);
//		}
//		printf("\n");
//	}
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	PrintfGraph(a);&
//	return 0;
//}

//int main()
//{
//	char arr[] = "abcdefg";//abcdefg\0
//	char arr2[20] = { "xxxxxxxxx"};
//	//将arr中的字符串拷贝到arr2中\0的ascall的值为0
//	strcpy(arr2, arr);
//	printf("%s", arr2);
//	return 0;
//}

//int main()
//{
//	char arr [] = { "hello bit"};
//	memset(arr+6,'X', 3);
//	//1.设置内存的时候都是以字节为单位
//	//2.每个字节的内容都是一样value
//	printf("%s",arr);
//
//	return 0;
//}
//void text(int *x)
//{
//	(*x)++;
//}
//int main()
//{
//	int num = 0;
//	scanf("%d", &num);
//	text(&num);
//	printf("%d\n", num);
//	text(&num);
//	printf("%d\n", num);
//	text(&num);
//	printf("%d\n", num);
//	text(&num);
//	printf("%d\n", num);
//	text(&num);
//	printf("%d\n", num);
//	text(&num);
//	printf("%d\n", num);
//	return 0;
//}

