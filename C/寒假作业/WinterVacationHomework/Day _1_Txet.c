#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<string.h>
//��ӡ��1������nλ��
//�������� n����˳���ӡ���� 1 ������ n λʮ���������������� 3�����ӡ�� 1��2��3 һֱ������ 3 λ�� 999��
//1. �÷���һ�������б��������ӡ
//2. n Ϊ��������0 < n <= 5
//int main()
//{
//	int number = 0;
//	scanf("%d", &number);
//	switch (number)
//	{
//	case 1:
//		for (int i = 1; i <= 9; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 3:
//		for (int i = 1; i <= 999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 4:
//		for (int i = 1; i <= 9999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 5:
//		for (int i = 1; i <= 99999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 6:
//		for (int i = 1; i <= 999999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 7:
//		for (int i = 1; i <= 9999999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 8:
//		for (int i = 1; i <= 99999999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	case 9:
//		for (int i = 1; i <= 999999999; i++)
//		{
//			printf("%d,", i);
//		}
//		break;
//	}
//
//	return 0;
//}

//int main()
//{
//	//\\��һ���ַ� ��\1��һ���ַ�
//	char arr[] = { "\\123456\123456\t" };
//	printf("%d\n", strlen(arr));
//	return 0;
//}
//#define N 2
//#define M N+1
//#define NUM (M+1)*M/2
//int main()
//{
//	printf("%d", M);
//	printf("%d", NUM);
//	return 0;
//}
//�������ڵ�����ת��
//int main()
//{
//	int arr[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
//	int year = 0;
//	int month = 0;
//	int day = 0;
//	int sum = 0;
//	scanf("%d %d %d", &year, &month, &day);
//	for (int i = 0; i < month - 1; i++)
//	{
//		sum += arr[i];
//	}
//	sum += day;
//	if (month > 2 && (year % 100 != 0 && year % 4 == 0 || year % 400 == 0)) {
//		sum += 1;
//	}
//	printf("%d", sum);
//	return 0;
//}


//int main() 
//{
//
//	char c2[] = { '\x10','\xa','\8' };
//	printf("%s", c2);
//	return 0;
//}

//int f(int n)
//{
//	static int i = 1;
//	if (n >= 5)
//		return n;
//	n += i;
//	i++;
//	return f(n);
//
//}
//int main() {
//
//	int n = 1;
//	int ret=f(n);
//	printf("%d", ret);
//	return 0;
//}


//int main()
//{
//	int b;
//	//const int* a = &b;
//	//printf("%p", a);//0113FA44
//	//int const* a = &b;
//	//printf("%p", a);//00CFF8D0
//	int* const a = &b;
//	printf("%p", a);//00CFFE64
//
//	return 0;
//}


//int main()
//{
//	//char a[14] = "Hello, world!";
//	//printf("%s", a);//Hello, world!
//	//char a[14];
//	//a ="Hello, World!"; 
//	//printf("%s", a);
//
//
//
//
//	return 0;
//}

//int main()
//{
//	int i = 0;
//	int ret = 0;
//	int n = 0;
//
//	while (~scanf("%d", &n)) 
//	{
//
//		ret = n * n + 1 - n;
//
//		for ( i = 0; i < n; i++)
//		{
//			printf("%d", ret + 2 + i);
//
//			if (i < n - 1)
//			{
//				putchar('+');
//			}
//		}
//		printf("\n");
//	}
//
//	return 0;
//}


//int main()
//{
//	int i = 0;
//	int ret = 0;
//	int m = 0;
//	int n = 0;
//	while (scanf("%d",&m)!=EOF)
//	{
//		n = m;
//		ret = m*(m-1)+1;
//
//		for (i = 1; i <=n; i++)
//		{
//			if (i == n)
//			{
//				printf("%d",ret);
//			}
//			else
//			{
//				printf("%d+",ret);
//				ret += 2;
//			}
//		}
//		printf("\n");
//	}
//
//	return 0;
//}

int main()
{
	int n = 0;
	int sum = 0;

	while (scanf("%d", &n) != EOF)
	{
		
		sum = n*(2 + (2 + (n - 1) * 3)) / 2;
		printf("%d", sum);
		printf("\n");
	}

	return 0;
}