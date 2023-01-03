#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//char* my_strcpy(char* dest,const char* str)
//{
//	char *ret= dest;
//	while (*dest++ = *str++) 
//	{
//		;
//	}
//	return ret;
//}
//
//int main()
//{
//	char  arr []= "hello world";
//	char arr2[] = "xxxxxxxxxxxxxx";
//
//	printf("%s", my_strcpy(arr2, arr));
//	return 0;
//}
//#include <stdio.h>
//int main()
//{
//    int i = 0;
//    int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//    for (i = 0; i <= 12; i++)
//    {
//        arr[i] = 0;
//        printf("hello bit\n");
//    }
//    return 0;
//}

//int main()
//{
//	int num = 0;
//	int arr[50] = { 0 };
//	int arr2[50] = { 0 };
//	int i = 0;
//	scanf("%d\n", &num);
//	for ( i = 0; i < num; i++)
//	{
//		scanf("%d ", &arr[i]);
//	}
//	int len = sizeof(arr) / sizeof(arr[0]);
//	int number = 0;
//	scanf("%d\n", &number);
//	for ( i = 0; i < len; i++)
//	{
//		if (arr[i] ==number)
//		{
//			arr2[i] = arr[i];
//		}
//	}
//	for (i = 0; i < len - 1; i++)
//	{
//		printf("%d ", arr2);
//	}
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	int arr[50] = { 0 };
//	int number = 0;
//	while ((scanf("%d", &num) != EOF))
//	{
//		for (int i = 0; i < num; i++)
//		{
//			scanf("%d", &arr[i]);
//		}
//		scanf("%d\n", &number);
//		for (int i = 0; i < num; i++)
//		{
//			if (arr[i] != number)
//			{
//				printf("%d", arr);
//			}
//		}
//	}
//
//	return 0;
//}