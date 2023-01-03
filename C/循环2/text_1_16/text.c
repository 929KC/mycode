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
//		printf("你好");
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
//		printf("请输入一个数：>");
//		scanf("%d", &guess);
//		if (guess > ret)
//		{
//			printf("你猜的数字大了\n");
//		}
//		else if (guess < ret)
//		{
//			printf("你猜的数字小了\n");
//		}
//		else
//		{
//			printf("恭喜你，你猜对了！！！\n");
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
//		printf("请输入你的选择：>");
//		scanf("%d", &input);
//		switch (input) {
//		case 1:
//			game();
//			break;
//		case 0:
//			printf("退出游戏");
//			break;
//		default:
//			printf("你输出的有误请重新输入！");
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
//	printf("请输入你要查找的数：");
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
//			printf("你查找到了，下标是：%d", mid);
//			break;
//		}
//	
//	}
//	if (left > right)
//	{
//		printf("很遗憾，没有找到！\n");
//	}
//	return 0;
//}
//int main()
//{
//	int age = 0;
//	printf("请输入你的年龄：>");
//	scanf("%d",&age);
//	if (age >=18)
//	{
//		printf("你可以喝酒了！");
//	}
//	else {
//			printf("你只能喝营养快线。");
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
//        printf("少年\n");
//    }
//    else if (age >= 18 && age < 30)
//    {
//        printf("青年\n");
//    }
//    else if (age >= 30 && age < 50)
//    {
//        printf("中年\n");
//    }
//    else if (age >= 50 && age < 80)
//    {
//        printf("老年\n");
//    }
//    else
//    {
//        printf("老寿星\n");
//    }
//
//}

