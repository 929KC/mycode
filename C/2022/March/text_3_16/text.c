#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//
//	int arr[] = { 12,34 };
//	printf("%d\n", *arr);
//	printf("%d\n", *(arr+1));
//	printf("%p\n", arr);
//	return 0;
//}

//int main()
//{
//	int a[5] = { 5, 4, 3, 2, 1 };
//	int* ptr = (int*)(&a + 1);
//	printf("%d,%d", *(a + 1), *(ptr - 1));
//	return 0;
//}

//int main()
//{
//	int aa[2][5] = { 10,9,8,7,6,5,4,3,2,1 };
//	int* ptr1 = (int*)(&aa + 1);
//	int* ptr2 = (int*)(*(aa + 1));
//	printf("%d,%d", *(ptr1 - 1), *(ptr2 - 1));
//	return 0;
//}
void text(char arr[5])
{

}

int main()
{
	char* arr[5] = { "hello", "bit" };
	text(arr);
	return 0;
}