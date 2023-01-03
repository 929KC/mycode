#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//void text(int (*arr)[5],int row ,int col)
//{
//	for (int i = 0; i < col; i++)
//	{
//		printf("%d ", (*(arr + 1)));
//	}
//}
//
//int main()
//{
//	int arr[3][5] = { {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15} };
//	text(arr,3,5);
//	return 0;
//}

//#include <stdio.h>
//void test(int arr[])//ok?
//{}
//void test(int arr[10])//ok?
//{}
//void test(int* arr)//ok?
//{}
//void test2(int* arr[20])//ok?
//{}
//void test2(int** arr)//ok?
//{}
//int main()
//{
//	int arr[10] = { 0 };
//	int* arr2[20] = { 0 };
//	test(arr);
//	test2(arr2);
//}
#include <stdio.h>
//void test()
//{
//	printf("hehe\n");
//}
//int main()
//{
//	printf("%p\n", test);
//	printf("%p\n", &test);
//	void (*pr)() = &test;
//	void (*pr2)() = test;
////	void* pe();
//	return 0;
//}

int Add(int x, int y)
{
	return x + y;
}
int main()
{

	int (*p)(int,int ) = Add;
	int ret = (*p)(3, 4);
	int ret2 = Add(3, 4);
	int ret3 = (p)(3, 4);
	printf("%d\n", ret);
	printf("%d\n", ret2);
	printf("%d\n", ret3);
	return 0;
}