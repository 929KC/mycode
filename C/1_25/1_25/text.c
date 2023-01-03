#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<math.h>
//int main()
//{
//	/*int a = 5;
//	int b = a << 1;
//	printf("%d\n", a);
//	printf("%d\n", b);*/
//	//int a = -5;
//	//int b = a >> 1;
//	//printf("%d\n", a);
//	//printf("%d\n", b);
//	char arr1[] = "abc";
//	char arr2[] = { 'a','b','c'};
//	int len1 = strlen(arr1);
//	int len2 = strlen(arr2);
//	printf("%s %d\n", arr1,len1);
//	printf("%s %d", arr2,len2);//没有\0，打印数组遇到\0才结束
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,45,78,412,45,412 };
//	//int len = strlen(arr);
//	int sz = sizeof(arr)/sizeof(arr[0]);
//	/*printf("%d %d", len, sz);*/
//	//for (int i = 0; i < sz; i++)
//	//{
//	//	printf("&arr[%d]=%p\n",i, &arr[i]);
//	//}
//	return 0;
//}

//int main()
//{
//	int arr[3][4];
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 4; j++)
//		{
//			printf("&arr[%d][%d]=%p\n",i,j, &arr[i][j]);
//		}
//	}
//
//
//	return 0;
//}


//#include <stdio.h>
//void bubble_sort(int arr[])//实参传的是地址，所以需要指针变量来接收，
//{
//    int sz = sizeof(arr) / sizeof(arr[0]);//这样对吗？
//  
//    int i = 0;
//    for (i = 0; i < sz - 1; i++)
//    {
//        int j = 0;
//        for (j = 0; j < sz - i - 1; j++)
//        {
//            if (arr[j] > arr[j + 1])
//            {
//                int tmp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = tmp;
//            }
//        }
//    }
//}
//int main()
//{
//    int arr[] = { 3,1,7,5,8,9,0,2,4,6 };
//    bubble_sort(arr);//arr-->&arr[0]--->地址
//     for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++)
//    {
//        printf("%d ", arr[i]);
//    }
//    return 0;
//}

//int  main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9.10 };
//	printf("%p\n", arr);
//	printf("%p\n", arr + 1);
//	printf("%p\n", &arr[0]);
//	printf("%p\n", &arr[0] + 1);
//	printf("%p\n", &arr);
//	printf("%p\n", &arr+1);
//
//	return 0;
//}

//int main()
//{/*
//    int arr[] = { 1,2,3,4,5 };
//    short* p = (short*)arr;
//    int i = 0;
//    for (i = 0; i < 4; i++)
//    {
//        *(p + i) = 0;
//    }
//
//    for (i = 0; i < 5; i++)
//    {
//        printf("%d ", arr[i]);
//    }*/
//    //unsigned long pulArray[] = { 6,7,8,9,10 };
//    //unsigned long* pulPtr;
//    //pulPtr = pulArray;
//    //*(pulPtr + 3) += 3;
//    //printf(" % d, % d\n", *pulPtr, *(pulPtr + 3));
// 
//        int a = 0x11223344;
//        char* pc = (char*)&a;
//        *pc = 0;
//        printf("%x\n", a);
//
//    return 0;
//}

//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int* p = arr;
//	int len = sizeof(arr) / sizeof(arr[0]);
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", (*p + i));
//	}
//	return 0;
//}
//void resever(char* arr)
//{
//	char* left = arr;
//	char* right = arr +strlen(arr) - 1;
//	while (left < right)
//	{
//		char temp = *left;
//		*left = *right;
//		*right = temp;
//		left++;
//		right--;
//	}
//}
//int main()
//{
//	char arr[] = { 0 };
//	scanf("%s", &arr);
//	resever(arr);
//	printf("%s", arr);
//	
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	for ( i = 1; i < 100000; i++)
//	{
//		int temp = i;
//		int sum = 0;
//		int count = 0;
//		while (temp)
//		{
//			temp /= 10;
//			count++;
//		}
//		temp = i;
//		while (temp)
//		{
//			sum += pow((temp % 10), count);
//			temp /= 10;
//		}
//		if (sum == i)
//		{
//			printf("%d ", i);
//		}
//
//	}
//	return 0;
//}

//int main()
//{
//	int i = 0;
//	for (i = 1; i <= 99999; i++)
//	{
//		int tmp = i;//各位数
//		int count = 0;//n
//		int sum = 0;
//
//		while (tmp)
//		{
//			tmp /= 10;//各位数
//			count++;
//		}
//		tmp = i;
//		while (tmp)
//		{
//			sum += pow((tmp % 10), count);
//			tmp /= 10;
//		}
//		if (sum == i)
//		{
//			printf("%d是水仙花数\n", i);
//		}
//	}
//	return 0;
//}
//int main()
//{
//	
//	for (int i=0;i<13)
//	return 0;
//}

//void resever(char* arr)
//{
//	char* left = arr;
//	char* right = arr + strlen(arr) - 1;
//	while (left < right)
//	{
//		char temp = *left;
//		*left = *right;
//		*right = temp;
//		left++;
//		right--;
//	}
//}
//int main()
//{
//	char arr[10] = { 0 };
//	scanf("%s", &arr);
//	resever(arr);
//	printf("%s", arr);
//
//	return 0;
//}

//int main()
//{
//	int i = 0;
//	int n = 0;
//	int a = 0;
//	int sum = 0;
//	printf("请输入一个数：");
//	scanf("%d", &n);
//	while (i < 5)
//	{
//		a = n + a * 10;
//		sum += a;
//		i++;
//	} 
//	printf("sum=%d\n", sum);
//	return 0;
//}

//int main()
//{
//    int rows = 0;
//    scanf("%d", &rows);
//    for (int i = 1; i <= rows / 2 + 1; i++) {
//        
//        for (int j = rows / 2 + 1 - i; j >0 ; j--) {
//            printf("");
//        }
//        
//        for (int j = 0; j <= 2 * i - 1; j++) {
//            printf("*");
//            
//        }
//        printf("\n");
//       
//    }
//    
//
//	return 0;
//}


//int main()
//{
//    int a = 0;
//    int b = 0;
//
//    scanf("%d %d", &a, &b);
//    int c = a ^ b;
//    int count = 0;
//    int i = 0;
//    while (i<32)
//    {
//        if (c & 1 == 1)
//            count++;
//        c = c >> 1;
//    }
//    printf("%d", count);
//}
int main()
{
	int a = 3;
	int b = 5;
	printf("a=%d b=%d\n", a, b);
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	printf("a=%d b=%d\n", a, b);
	return 0;
}