#define _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<String.h>
//int main() 
//{
//	int sum = 0;
//	for (int i = 1; i <= 100; i++)
//	{
//		if (i % 2 != 0)
//		{
//			sum += i;
//		}
//	}
//	printf("%d", sum);
//	return 0;
//}

//int func(int a)
//{
//    int b;
//    switch (a)
//    {
//    case 1: b = 30;
//    case 2: b = 20;
//    case 3: b = 16;
//    default: b = 0;
//    }
//    return b;
//}
//
//int main()
//{
//	//int i = 0;
//	//for (i = 0; i < 10; i++)
//	//{
//	//	if (i = 5)
//	//		printf("%d ", i);//死循环的打印5
//	//}
//    int a = 1;
//    int number = func(a);
//    printf("%d ", number);
//    
//	return 0;
//}

//int main() {
//	int x = 3;
//	int y = 3;
//	switch (x % 2) {
//	case 1:
//		switch (y)
//		{
//		case 0:
//			printf("first");
//		case 1:
//			printf("second");
//			break;
//		default: printf("hello\t");
//		}
//	case 2:
//		printf("third");
//	}
//	return 0;
//}
//int main()
//{
//	int arr[3] = { 0 };
//	int i = 0;
//	printf("请输入三个数：");
//	for (i = 0; i < strlen(arr); i++)
//	{
//		scanf("%d ", arr[i]);
//	}
//
//	for (i = strlen(arr); i >= 0; i--)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}
// 
// 
//写代码将三个整数数按从大到小输出。
//例如：
//输入：2 3 1
//输出：3 2 1

//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int temp = 0;
//	printf("请输入三个数：");
//	scanf("%d %d %d", &a, &b, &c);
//	if (a < b)
//	{
//		temp = a;
//		a = b;
//		b = temp;
//	}
//	if (a < c)
//	{
//		temp = a;
//		a = c;
//		c = temp;
//	}
//	if (b < c)
//	{
//		temp = b;
//		b = c;
//		c = temp;
//	}
//	printf("%d %d %d", a, b, c);
//	return 0;
//}
//

//写一个代码打印1-100之间所有3的倍数的数字
//int main()
//{
//	int count = 0;
//	for (int i = 1; i <= 100; i++)
//	{
//		if (i % 3 == 0)
//		{
//			count++;
//			printf("%d\t", i);
//			if (count == 10)
//			{
//				printf("\n");
//				count = 0;
//			}
//		}
//	}
//	return 0;
//}

//给定两个数，求这两个数的最大公约数
//int main()
//{
//
//	return 0;
//}

//打印1000年到2000年之间的闰年
//1.能被4整除且不能被100整除为闰年
//2.能被400整除为闰年
//int main()
//{
//	int year = 0;
//	int count = 0;
//	for (year = 1000; year <= 2000; year++)
//	{
//		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
//		{	
//			count++;
//			printf("%d\t", year);
//			if (count == 10) 
//			{
//				printf("\n");
//				count=0;
//			}
//		}
//
//	}
//	return 0;
//}

//写一个代码：打印100~200之间的素数
//素数：质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
//int main()
//{
//	int i = 0;	int j = 0; int count = 0;
//	for ( i= 100; i <= 200; i++)
//	{
//		for ( j= 2; j <= i; j++)
//		{
//			if (i % j == 0) {
//				break;
//			}
//		}
//		if (i == j) 
//		{
//			count++;
//			printf("%d\t", i);
//			if (count == 5)
//			{
//				printf("\n");
//				count = 0;
//			}
//		}
//	}
//	return 0;
//}


//编写程序数一下 1到 100 的所有整数中出现多少个数字9
//int main()
//{
//	int count = 0;
//	int k = 0;
//	int i = 0;
//	for (i = 1; i <= 100; i++)
//	{
//		if ( i % 10 == 9)
//		{
//			count++;
//		}
//
//		if (i / 10 == 9)
//		{
//			count++;
//		}
//	}
//	printf("9的个数count=%d \n", count);
//	return 0;
//}

//int main()
//{
//	int sum = 0;
//	for (int i = 1; i <= 9; i++)
//	{
//		for (int j = 1; j <= i; j++)
//		{
//			sum = i * j;
//			printf("%d*%d=%2d ",j,i,sum);//2d宽度
//		}
//		printf("\n");
//	}
//	return 0;
//}

//求10 个整数中最大值
//int main()
//{
//	int arr[10] = {0};
//	int max = arr[0];
//	for (int i = 0; i < 10; i++)
//	{
//		scanf("%d", &arr[i]);
//	}
//	
//	for (int j = 0;j<10;j++)
//	{
//		if (arr[j] > max)
//		{
//			max = arr[j];
//		}
//	}
//	printf("十个整数的最大值：%d", max);
//
//}

//分数求和
//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值，打印出结果
//int main()
//{
//	float sum = 0;
//	float number = 0;
//	float number2=0;
//		for (int j = 1; j <= 100; j++) {
//			if (j % 2 !=0)
//			{
//				number += 1.0 / j;
//			}
//			if (j % 2 == 0)
//			{
//				number2 += 1.0 / j;
//			}
//		}
//		sum = (number - number2);
//		printf("%f", sum);//注意整形除法求商！！！！sum=1
//	return 0;
//}

//给定两个数，求这两个数的最大公约数
/*用大数对小数求余，若余数为0，则除数为最大公约数。若余数不为0，
将此余数作为除数，小数作为被除数，
重新求余，直到余数为0为止。此时的最大公约数为余数。*/
int main()
{
	int number = 0;
	int number2 = 0;
	int num = 0;
	int a = 0;
	scanf("%d %d", &number, &number2);
	
	if (number > number2) {
		num = number % number2;
		while(num!= 0) {
			number = number2;
			number2 = num;
			num = number % number2;
		}
		printf("最大公约数为：%d\n", number2);
	}
	else
	{
		if (number <number2) {
			 a = number2 % number;
			while (num != 0) {
				number2 = number;
				number = a;
				a = number2 % number;
			}
			printf("最大公约数为：%d\n", number);
		}
	}
	return 0;
}