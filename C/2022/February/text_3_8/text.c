#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//
//	int a = 0x11223344;
//
//	return 0;
//}
//int main()
//{
//	int n = 9;
//	float* pFloat = (float*)&n;
//	printf("n的值为：%d\n", n);
//	printf("*pFloat的值为：%f\n", *pFloat);
//	*pFloat = 9.0;
//	printf("num的值为：%d\n", n);
//	printf("*pFloat的值为：%f\n", *pFloat);
//	return 0;
//}

//int main()
//{
//
//	float f = 5.5;
//	//101.1
//	//(-1)^0*1.011*2^2
//	//S=0
//	//E=2+127
//	//M=1.011
//	//存到内存中：
//	//0 10000001 01100000000000000000000
//	//0x40b00000
//	return 0;
//}

//#include <stdio.h>
//int main()
//{
//    char str1[] = "hello bit.";
//    char str2[] = "hello bit.";
//    char* str3 = "hello bit.";
//    char* str4 = "hello bit.";
//    if (str1 == str2)
//        printf("str1 and str2 are same\n");
//    else
//        printf("str1 and str2 are not same\n");
//
//    if (str3 == str4)
//        printf("str3 and str4 are same\n");
//    else
//        printf("str3 and str4 are not same\n");
//
//    return 0;
//}

//int main()
//{
//
//	int count = 10;
//	int arr2[count];//数组时候可以正常创建？
//	return 0;
//}

//int main()
//{
//
//	char arr1[] = "abc";
//	char arr2[3] = { 'a','b','c' };
//
//	return 0;
//}

//#include <stdio.h>
//int main()
//{
//    int arr[10] = { 0 };
//    int i = 0;
//    int sz = sizeof(arr) / sizeof(arr[0]);
//
//    for (i = 0; i < sz; ++i)
//    {
//        printf("&arr[%d] = %p\n", i, &arr[i]);//%p打印地址
//    }
//    return 0;
//}

//#include <stdio.h>
//int main()
//{
//	int arr[3][4];
//	int i = 0;
//	for (i = 0; i < 3; i++)
//	{
//		int j = 0;
//		for (j = 0; j < 4; j++)
//		{
//			printf("&arr[%d][%d] = %p\n", i, j, &arr[i][j]);
//		}
//	}
//	return 0;
//}

//#include <stdio.h>
//int main()
//{
//    int arr[10] = { 1,2,3,4,5 };
//    printf("%p\n", arr);
//    printf("%p\n", arr + 1);
//    printf("%d\n", *arr);
//    printf("%d\n", *arr+1);
//
//    printf("%p\n", &arr[0]);
//    printf("%p\n", &arr[0] + 1);
//    printf("%d\n", arr[0]);
//    printf("%d\n", arr[0] + 1);
//
//    printf("%p\n", &arr);
//
//    printf("%p\n", &arr+1);
// 
//    return 0;
//}



