#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	int arr[5] = { 1,2,3,4,5 };
	int arr2[5] = { 1,2,3,4,5 };
	int arr3[5] = { 1,2,3,4,5 };
	int* p[3] = { arr,arr2,arr3 };//指针数组存三个数组的首元素的地址，这个相当于二维数组
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			printf("%-2d", *(p[i] + j));
			//printf("%2d", p[i][j]);//i 指向arr,arr2,arr3 j 指向arr,arr2,arr3 中的元素
		}
		printf("\n");
	}
		return 0;
}