#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//void* malloc(size_t size);

int main()
{
	int* arr = (int*)malloc(sizeof(int) * 2);
	//��������ɹ�û
	if (NULL == arr)
	{
		exit(-1);
	}

	*(arr + 0) = 9;
	*(arr + 1) = 5;

	return 0;
}