#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	int arr[5] = { 1,2,3,4,5 };
	int arr2[5] = { 1,2,3,4,5 };
	int arr3[5] = { 1,2,3,4,5 };
	int* p[3] = { arr,arr2,arr3 };//ָ������������������Ԫ�صĵ�ַ������൱�ڶ�ά����
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			printf("%-2d", *(p[i] + j));
			//printf("%2d", p[i][j]);//i ָ��arr,arr2,arr3 j ָ��arr,arr2,arr3 �е�Ԫ��
		}
		printf("\n");
	}
		return 0;
}