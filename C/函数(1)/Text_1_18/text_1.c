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
//ʷ����򵥵ĵݹ�
//int main()
//{
//	printf("hello\n");
//	main();
//	return 0;
//}

//�ݹ�(���ƣ��ع�)
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
//���ַ�������
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
//	int len = my_strlen(arr);//����Ԫ���׵�ַ
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
//ʵ�֣��������ַ����е��ַ��������У����������ӡ��
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
//����һ������ÿλ֮�ͣ��ݹ�ʵ�֣�
//дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮��
//���磬����DigitSum(1729)����Ӧ�÷���1 + 7 + 2 + 9�����ĺ���19
//���룺1729�������19
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
//�ݹ�ʵ��n��k�η�
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
//�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲�������
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