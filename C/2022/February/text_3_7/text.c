#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//	int num = 0;
//	int j = 0;
//	while (scanf("%d", &num) != EOF)
//	{
//		for (int i = 0; i < num; i++)
//		{
//			for (j = 0; j <=i; j++)
//			{
//				if (j > 0 && j < i && i < num - 1)
//				{
//					printf(" ");
//				}
//				else {
//					printf("*");
//				}
//
//			}
//			printf("\n");
//		}
//	}
//	return 0;
//}

//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	int j = 0;
//	while (scanf("%d", &num) != EOF)
//	{
//		for (int i = 0; i < num; i++)
//		{
//			for (j = 0; j <= i; j++)
//			{
//				if (i > 1 && i < num - 1 && j > 0 && j < i)
//				{
//					printf("  ");
//				}
//				else if (i == j)	
//				{
//					printf("*");
//				}
//				else {
//					printf("* ");
//				}
//
//			}
//			printf("\n");
//		}
//	}
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int n = 0;
//	int m = 0;
//	int num = 0;
//	int i = 0;
//	int j = 0;
//
//	int  arr[3001] = { 0 };
//	for (i = 0; i < n; i++)
//	{
//		scanf("%d", &num);
//		arr[i] = num;
//	}
//
//	for (j = 0; j < m; j++)
//	{
//		scanf("%d", &num);
//		arr[i + j] = num;
//	}
//
//	for (int i = 0; i < n + m; i++)
//	{
//		for (int j = 0; j < m + n - i - 1; j++)
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				int tmp = 0;
//				tmp = arr[j + 1];
//				arr[j + 1] = arr[j];
//				arr[j] = tmp;
//
//			}
//		}
//	}
//
//	for (int k = 0; k < m + n; k++)
//	{
//		printf("%d", arr[k]);
//
//	}
//	return 0;
//}

//int main()
//{
//	unsigned char a = 200;
//	unsigned char b = 100;
//	unsigned char c = 0;
//	c = a + b;
//	printf("%d %d %d", a + b, c);
//	return 0;
//}

//int main()
//{
//    char a[1000] = { 0 };
//    int i = 0;
//    for (i = 0; i < 1000; i++)
//    {
//        a[i] = -1 - i;
//    }
//    printf("%d", strlen(a));
//    return 0;
//}

//int main()
//{
//
//	unsigned int a = 0x1234; 
//	unsigned char b = *(unsigned char*)&a;
//	printf("%d", b);
//	return 0;
//}
//#define N 10
//int main()
//{
//	int arr[N][N] = { 0 };
//	for (int i = 0; i <= N; i++)
//	{
//		for (int j = 0; j <= i; j++)
//		{
//			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//			printf("%2d", arr[i][j]);
//
//		}
//		printf("\n");
//	}
//
//	return 0;
//}

//#include<stdio.h>
//int main()
//{
//    int arr[100][100], i, j, num;
//    printf("请输入需要打印的行数：");
//    scanf("%d", &num);
//    for (i = 0; i < 100; i++)                                 
//    {
//        for (j = 0; j < 100; j++)
//            arr[i][j] = 0;
//    }
//    for (i = 0; i < num; i++)
//    {
//       
//        arr[i][0] = arr[i][i]=1;
//    }
//
//    for (i = 1; i < num; i++)
//    {
//      
//        for (j = 1; j <= i; j++) 
//        {
//            arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
//        }
//    }
//         
//    for (i = 0; i < num; i++)                                
//    {
//        for (j = 0; j <= i; j++)
//        {
//            printf("%d ", arr[i][j]);
//        }
//        printf("\n");
//    }
//    return 0;
//}
//int main()
//{
//	unsigned char a = 200;
//	unsigned char b = 100;
//	unsigned char c = 0;
//	c = a + b;
//	printf("%d %d", a + b, c);
//	return 0;
//}
