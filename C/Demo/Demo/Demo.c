#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<string.h>
//int main()
//{
//    int n = 1;
//    int m = 2;
//    switch (n)
//    {
//    case 1:
//        m++;
//    case 2:
//        n++;
//    case 3:
//        switch (n)
//        {
//        case 1:
//            n++;
//        case 2:
//            m++;
//            n++;
//            break;
//        }
//    case 4:
//        m++;
//        break;
//    default:
//        break;
//    }
//    printf("m = %d, n = %d\n", m, n);
//    return 0;
//}

//int main()
//{
//	int i = 0;
//	//for(i=1/*初始化*/; i<=10/*判断部分*/; i++/*调整部分*/)
//	for (i = 1; i <= 100; i++)
//	{
//		printf("%d ", i);
//	}
//	return 0;
//}

//代码1
//#include <stdio.h>
//int main()
//{
//	int i = 0;
//	for (i = 1; i <= 10; i++)
//	{
//		if (i == 5)
//			break;
//		printf("%d ", i);
//	}
//	return 0;
//}
//代码2
//#include <stdio.h>
//int main()
//{
//	int i = 0;
//	for (i = 1; i <= 10; i++)
//	{
//		if (i == 5)
//			continue;
//		printf("%d ", i);
//	}
//	return 0;
//}

//int main()
//{
//
//	for (int i = 1; i <= 9; i++)
//	{
//		for (int j = 1; j <= i; j++)
//		{
//			printf("*");
//		}
//		printf("\n");
//	}
//}
//break 代码实例
//#include <stdio.h>
//int main()
//{
//	int i = 1;
//	while (i <= 10)
//	{
//		if (i == 5)
//			break;
//		printf("%d ", i);
//		i = i + 1;
//	}
//	return 0;
//}

//continue 代码实例1
//#include <stdio.h>
//int main()
//{
//	int i = 1;
//	while (i <= 10)
//	{
//		if (i == 5)
//			continue;
//		printf("%d ", i);
//		i = i + 1;
//	}
//	return 0;
//}
//int main()
//{
//	int num = 0;
//	int i = 1;
//	int sum = 1;
//	scanf("%d", &num);
//	do {
//		sum *= i;
//		i++;
//	}while(i <= num);
//	printf("%d", sum);
//}

//#include <stdio.h>
//int main()
//{
//    int i = 10;
//
//    do
//    {
//        if (5 == i)
//            break;
//        printf("%d\n", i);
//        i++;
//    } while (i < 10);
//
//    return 0;
//}
//#include <stdio.h>
//int main()
//{
//    int i = 10;
//
//    do
//    {
//        if (5 == i)
//            continue;
//        printf("%d\n", i);
//        i++;
//    } while (i < 10);
//
//    return 0;
//}
//int main()
//{
//	int i = 0;
//	for ( i= 1; i <= 5; i++)
//	{
//		if (i == 3)
//		{
//			break;
//		}
//		printf("我吃了第%d个包子!\n", i);
//		
//	}
//	
//	return 0;
//}
//int main()
//{
//	int num = 0;
//	
//	scanf("%d", &num);
//	for (int i = 0; i < 9; i++)
//	{
//		for (int j = 0; j < 9; j++)
//		{
//			for (int k = 0; k < 9; k++)
//			{
//				if (num == 3) {
//					goto error;
//				}
//			}
//		}
//		
//	}
//	error:
//	if (num == 3)
//	{
//		printf("你是猪\n");
//	}
//
//	return 0;
//}

//int main()
//{
//    int day = 1;
//    switch (day)
//    {
//    case 1:
//        printf("星期一\n");
//        break;
//    case 2:
//        printf("星期二\n");
//        break;
//    case 3:
//        printf("星期三\n");
//        break;
//    case 4:
//        printf("星期四\n");
//        break;
//    case 5:
//        printf("星期五\n");
//        break;
//    case 6:
//        printf("星期六\n");
//        break;
//    case 7:
//        printf("星期天\n");
//        break;
//    }
//    return 0;
//}

//	int main()
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
////get_max函数的设计
//int get_max(int x, int y) //xy为形参
//{
//	return (x > y) ? (x) : (y);//返回值求出来的最值
//}
//
//int main()
//{
//	int num1 = 10;
//	int num2 = 20;
//	int max = get_max(num1, num2);//num1 ,num2为实参，声明一个max的变量来接收返回值
//	printf("max = %d\n", max);
//	return 0;
//}
////错误的Swap1
//void Swap1(int x, int y)//形参x,外在内存中开辟空间，去分别存储传过来的num1和num2 空间3和空间4
//{
//	int tmp = 0;//开辟空间5存储0
//	tmp = x;
//	x = y;
//	y = tmp;
//	//这段代码就换的是以tmp为中间变量，来达到空间3和空间4的值互相交换，并没有把空间1和空间2中的值交换                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
//}
////正确的版本
//void Swap2(int* px, int* py)//px和py为指针变量，储存的就是地址，指针即地址
//{
//	int tmp = 0;//开辟空间存储0
//	tmp = *px;
//	*px = *py;
//	*py = tmp;
//}
//int main()
//{
//	int num1 = 1;//声明num1开辟空间存储1  空间1
//	int num2 = 2;//声明num1开辟空间存储2	空间2
//	Swap1(num1, num2);
//	printf("Swap1::num1 = %d num2 = %d\n", num1, num2);
//	Swap2(&num1, &num2);//去地址，传地址
//	printf("Swap2::num1 = %d num2 = %d\n", num1, num2);
//	return 0;
//}
//int Add(int x, int y) {
//	return x + y;
//}
//int main()
//{
//	int num1 = 0;
//	int num2;
//	scanf("%d %d", &num1, &num2);
//	int sum = Add(num1, num2);
//	printf("%d", sum);
//	return 0;
//}

//int main()
//{
//	printf("你是猪！\n");
//	main();
//	return 0;
//}
//void print(int n) 
//{
//	if (n > 9)
//	{
//		print(n / 10);
//	}
//	printf("%d ", n % 10);
//}
//int main()
//{
//	int num = 0;
//	scanf("%d", &num);
//	print(num);
//	return 0;
//}
//int main()
//{
//    int arr[] = { 1,2,(3,4),5 };
//    printf("%d\n", sizeof(arr));
//    return 0;
//}

//int main()
//{
////    char str[] = "hello bit";//空字符
////    //sizeof\0计算
////    printf("%d %d\n", sizeof(str), strlen(str));
//    char acX[] = "abcdefg";
//    char acY[] = { 'a','b,','c','d','e','f','g' };
//    printf("%d %d", sizeof(acX), sizeof(acY));
//    return 0;
//}

//int main()
//{
//	int a[2][] = { {0,1,2},{3,4,5} };
//	int a[][3] = { {0,1,2},{3,4,5} };
//	int a[2][4] = { {0,1,2},{3,4},{5} };
//	int a[][3] = { {0,,2},{},{3,4,5} };
//	return 0;
//}
//void scort(int *arr, int sz)
//{
//	for (int i = 0; i < sz - 1; i++)
//	{
//		for (int j = 0; j < sz - 1 - i; j++)
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				int temp = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j+ 1] = temp;
//			}
//		}
//	}
//
//
//}

//int main()
//{
//	int arr[] = { 1,8,7,9,4,5,6,30,0,10 };
//	int len = sizeof(arr)/sizeof(arr[0]);
//	scort(arr, len);
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 1,2,3,4,5,6,7,8,9,10 };
//	int arr2[10] = { 12,45,78,23,56,89,78,45,13,10 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	for (int i = 0; i < len; i++)
//	{
//		int temp = arr[i];
//		arr[i] = arr2[i];
//		arr2[i] = temp;
//		
//	}
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr2[i]);
//	}
//	return 0;
//}

//#include<stdio.h>
//#define N 10
//int ave(int a[], int cnt) {
//	int i;
//	double x = 0;
//	for (i = 0; i < cnt; i++)
//	{
//		x += a[i];
//	}
//	x = x / cnt;
//	return x;
//}
//int main()
//{
//	double a[N], x, res;
//	int i, cnt = 0;
//	for (i = 0; i < N; i++)
//	{
//		scanf("%lf", &x);
//		if (x > 0) { a[cnt] = x; cnt++; }
//	}
//	res = ave(a, cnt);   //调用函数求大于0的数的平均值
//	printf("%.2lf\n", res);
//	return 0;
//}
//double average(double* arr, int sz)
//{
//	double  sum = 0.0;
//	for (int i = 0; i < sz; i++)
//	{
//		sum += arr[i];
//	}
//	printf("%.2lf\t", sum);
//	return sum / sz;
//}
//
//int main()
//{
//	double arr[10] = {0.0};
//	int len = sizeof(arr) / sizeof(arr[0]);
//	for (int i = 0; i < len; i++)
//	{
//		scanf("%lf", &arr[i]);
//	}
//	double ave= average(arr, len);
//	printf("%.2lf", ave);
//	return 0;
//}