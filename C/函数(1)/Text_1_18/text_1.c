#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int main()
//{
//	int i = 1;
//	while (i <= 100)
//	{
//		printf("%d ", i);
//		i++;
//	}
//	return 0;
//}
//史上最简单的递归
//int main()
//{
//	printf("hello\n");
//	main();
//	return 0;
//}

//递归(递推，回归)
//void print(int n)
//{
//	if (n > 9)
//	{
//		print(n / 10);
//	}
//	printf("%d ", n % 10);
//
//}
//
//int main()
//{
//	int number = 0;
//	scanf("%d", &number);
//	print(number);
//
//	return 0;
//
//}
//求字符串长度
//my_strlen("abcdef")
//1+my_strlen("bcdef")
//1+1+my_strlen("cdef")
//1+1+1+ my_strlen("def")
//1+1+1+1+ my_strlen("ef")
//1 + 1 + 1 + 1 +1+my_strlen("f")
//1 + 1 + 1 + 1 + 1 + 1+ my_strlen("")
//1 + 1 + 1 + 1 + 1 + 1 + 0 = 6
//int my_strlen(char *str)
//{
//	int count = 0;
//	while (*str != '\0')
//	{
//		count++;
//		str++;
//	}
//	return count;  
//}
//int my_strlen(char* str)
//{
//	if (*str != '\0')
//	{
//		return 1 + my_strlen(str + 1);
//	}
//	else
//	{
//		return 0;
//	}
//
//}
//
//int main()
//{
//	char arr[] = "abcdef";
//	int len = my_strlen(arr);//数组元素首地址
//	printf("%d", len);
//	return 0;
//}

//int fac(int n)
//{
//	if (n <=1)
//	{
//		return 1;
//	}
//	else
//	{
//	return	n* fac(n - 1);
//	}
//
//}
//int fac1(int n)
//{
//	int sum = 1;
//	for (int i = 1; i <= n; i++)
//	{
//		 sum *= i;
//	}
//	return sum;
//}
//int main()
//{
//
//	int num = 0;
//	scanf("%d", &num);
//	int ret=fac1(num);
//	printf("%d", ret);
//
//	return 0;
//}
//实现：将参数字符串中的字符反向排列，不是逆序打印。
//void reverse_string(char* string)
//{
//	if ((*(string++) !='\0'  ))
//	{
//		reverse_string(string);
//	}
//	printf("%c", *(string - 1));
//}
//
//int main()
//{
//	char arr[] = "abcdef";
//	reverse_string(arr);
//	return 0;
//}
//计算一个数的每位之和（递归实现）
//写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和
//例如，调用DigitSum(1729)，则应该返回1 + 7 + 2 + 9，它的和是19
//输入：1729，输出：19
//int DigitSum(int n)
//{
//	int sum = 0;
//	if (n < 10)
//	{
//		return  n;
//	}
//	else
//	{
//		return n%10+ DigitSum(n/10);
//	}
//	
//}
//
//int main()
//{
//	unsigned int num=0;
//	scanf("%d", &num);
//	int ret = DigitSum(num);
//	printf("%d", ret);
//	return 0;
//}
//递归实现n的k次方
//int spa(int n, int k)
//{
//	if (k < 0)
//	{
//		k = -k;
//		return 1/spa(n,k-1);
//	}
//	else if (k == 0)
//	{
//		return 1;
//	}
//	else if (k > 0)
//	{
//		return n * spa(n,k - 1);
//	}
//}
//
//int main()
//{
//	int num = 0;
//	int kc = 0;
//	scanf("%d %d", &num, &kc);
//	int ret=spa(num, kc);
//	printf("%d", ret);
//	return 0;
//}
//递归和非递归分别实现求第n个斐波那契数
//int fac(int n)
//{
//	if (n <= 2)
//	{
//		return 1;
//	}
//	else
//	{
//		return fac(n - 1) + fac(n - 2);
//	}
//}

int fac(int n)
{
	int a = 1;
	int b = 1;
	int c = 1;
	while (n>2)
	{
		c = a + b;
		a = b;
		b = c;
		n--;
	}
	return c;
}

int main()
{
	int num = 0;
	scanf("%d", &num);
	int ret = fac(num);
	printf("%d", ret);
	return 0;
}