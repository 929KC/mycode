#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
//int main()
//{
//	int sum = 0;
//	int number = 0;
//	int i = 1;
//	int ret = 1;
//	scanf("%d", &number);
//	while (i <= number)
//	{
//		
//		ret *= i;
//		sum += ret;
//		i++;
//	}
//	printf("%d", sum);
//
//}

//int main()
//{
//	int i = 0;
//	while (i <= 100)
//	{
//		printf("���");
//	}
//	
//	return 0;
//}

//int main()
//{
//	int a = 0, b = 0;
//	for (a = 1, b = 1; a <= 100; a++)
//	{
//		if (b >= 20) break;
//		if (b % 3 == 1)
//		{
//			b = b + 3;
//			continue;
//		}
//		b = b - 5;
//	}
//	printf("%d\n", a);
//	printf("%d\n", b);
//
//
//	return 0;
//}

//void menu()
//{
//	printf("*******************\n");
//	printf("***1.play 0.exit***\n");
//	printf("********************\n");
//}

//void game()
//{
//	int guess = 0;
//	int ret = rand() % 100 + 1;
//	while (1)
//	{
//		printf("������һ������>");
//		scanf("%d", &guess);
//		if (guess > ret)
//		{
//			printf("��µ����ִ���\n");
//		}
//		else if (guess < ret)
//		{
//			printf("��µ�����С��\n");
//		}
//		else
//		{
//			printf("��ϲ�㣬��¶��ˣ�����\n");
//			break;
//		}
//	}
//	
//}
//
//int main()
//{
//	int input = 0;
//	srand((unsigned int)time(NULL));
//	do {
//		menu();
//		printf("���������ѡ��>");
//		scanf("%d", &input);
//		switch (input) {
//		case 1:
//			game();
//			break;
//		case 0:
//			printf("�˳���Ϸ");
//			break;
//		default:
//			printf("��������������������룡");
//			break;
//		}
//	} while (input);
//	return 0;
//}

//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int number = 0;
//	int len = sizeof(arr)/sizeof(arr[0]);
//	int left = 0;
//	int right = len - 1;
//	printf("��������Ҫ���ҵ�����");
//	scanf("%d", &number);
//	while (left <= right)
//	{
//		int mid = left + (right-left)/2;
//		//int mid=right+left;
//		if (arr[mid] > number)
//		{
//
//			right = mid ;
//		}
//		else if (arr[mid] < number)
//		{
//			left = mid + 1;
//		
//		}
//		else {
//			printf("����ҵ��ˣ��±��ǣ�%d", mid);
//			break;
//		}
//	
//	}
//	if (left > right)
//	{
//		printf("���ź���û���ҵ���\n");
//	}
//	return 0;
//}
//int main()
//{
//	int age = 0;
//	printf("������������䣺>");
//	scanf("%d",&age);
//	if (age >=18)
//	{
//		printf("����ԺȾ��ˣ�");
//	}
//	else {
//			printf("��ֻ�ܺ�Ӫ�����ߡ�");
//	}
//
//	
//	return 0;
//}

//int main()
//{
//    int age = 0;
//    scanf("%d", &age);
//    if (age < 18)
//    {
//        printf("����\n");
//    }
//    else if (age >= 18 && age < 30)
//    {
//        printf("����\n");
//    }
//    else if (age >= 30 && age < 50)
//    {
//        printf("����\n");
//    }
//    else if (age >= 50 && age < 80)
//    {
//        printf("����\n");
//    }
//    else
//    {
//        printf("������\n");
//    }
//
//}

