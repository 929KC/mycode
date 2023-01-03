#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//    int arr[10] = { 1,2,3,4,5,6,7,8,9,0 };
//    printf("%p\n", arr);
//    printf("%p\n", &arr[0]);
//    return 0;
//}

//#include <stdio.h>
//int main()
//{
//    int arr[] = { 1,2,3,4,5,6,7,8,9,0 };
//    int* p = arr; //指针存放数组首元素的地址
//    int sz = sizeof(arr) / sizeof(arr[0]);
//    int i = 0;
//    for (i = 0; i < sz; i++)
//    {
//        printf("&arr[%d] = %p   <====> p+%d = %p\n", i, &arr[i], i, p + i);
//    }
//    return 0;
//}
//int Add(int x,int y)
//{
//	return x + y;
//}
//int Sub(int x, int y)
//{
//	return x -y;
//}
//int Mul(int x, int y)
//{
//	return x * y;
//}
//int Div(int x, int y)
//{
//	return x /y;
//}
//void menu()
//{
//	printf("******欢迎使用计算器******");
//	printf("1 Add");
//	printf("2 Sub");
//	printf("3 Mul");
//	printf("4 Div");
//	printf("0 exit");
//}
//int main()
//{
//	menu();
//
//
//	return 0;
//}

//int main()
//{
//     const   char* pstr = "hello bit.";//这里是把一个字符串放到pstr指针变量里了吗？//常量字符串，存储在常量区，一旦创建好就不能修改
//    //  *pstr = 'w';
//    printf("%c\n", *pstr);
//    printf("%s\n", pstr);
//
//    return 0;
//}

//#include <stdio.h>
//int main()
//{
//    char str1[] = "abcdef";
//    char str2[] = "abcdef";
//    const char* str3 = "abcdef";
//    const char* str4 = "abcdef";
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

//#include <stdio.h>
//int main()
//{
//    int arr[10] = { 0 };
//    printf("%p\n", arr);
//    printf("%p\n", &arr);
//    return 0;
//}
#include <stdio.h>
int main()
{
	int arr[10] = { 0 };
	printf("arr = %p\n", arr);
	printf("&arr= %p\n", &arr);
	printf("arr+1 = %p\n", arr + 1);
	printf("&arr+1= %p\n", &arr + 1);
	return 0;
}
