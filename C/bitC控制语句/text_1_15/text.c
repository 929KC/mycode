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
//	//		printf("%d ", i);//��ѭ���Ĵ�ӡ5
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
//	printf("��������������");
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
//д���뽫�������������Ӵ�С�����
//���磺
//���룺2 3 1
//�����3 2 1

//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int temp = 0;
//	printf("��������������");
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

//дһ�������ӡ1-100֮������3�ı���������
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

//���������������������������Լ��
//int main()
//{
//
//	return 0;
//}

//��ӡ1000�굽2000��֮�������
//1.�ܱ�4�����Ҳ��ܱ�100����Ϊ����
//2.�ܱ�400����Ϊ����
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

//дһ�����룺��ӡ100~200֮�������
//��������������Ϊ�ڴ���1����Ȼ���У�����1�����������ⲻ��������������
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


//��д������һ�� 1�� 100 �����������г��ֶ��ٸ�����9
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
//	printf("9�ĸ���count=%d \n", count);
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
//			printf("%d*%d=%2d ",j,i,sum);//2d���
//		}
//		printf("\n");
//	}
//	return 0;
//}

//��10 �����������ֵ
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
//	printf("ʮ�����������ֵ��%d", max);
//
//}

//�������
//����1/1-1/2+1/3-1/4+1/5 ���� + 1/99 - 1/100 ��ֵ����ӡ�����
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
//		printf("%f", sum);//ע�����γ������̣�������sum=1
//	return 0;
//}

//���������������������������Լ��
/*�ô�����С�����࣬������Ϊ0�������Ϊ���Լ������������Ϊ0��
����������Ϊ������С����Ϊ��������
�������ֱ࣬������Ϊ0Ϊֹ����ʱ�����Լ��Ϊ������*/
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
		printf("���Լ��Ϊ��%d\n", number2);
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
			printf("���Լ��Ϊ��%d\n", number);
		}
	}
	return 0;
}