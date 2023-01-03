#define _CRT_SECURE_NO_WARNINGS 1

//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	memcpy(arr + 2, arr,16);
//
//	return 0;
//}

#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int* ret = (int*)memmove(arr + 3, arr, 16);
//	for (int i = 0; i <= 6; i++) {
//		printf("%d ", *(ret + i));
//	}
//
//	return 0;
//}
//#include<assert.h>
//void* my_memmove(void* dest, const void* sour, size_t count)
//{
//	assert(dest && sour);
//	void* ret = dest;
//	if (dest < sour)
//	{
//		while (count--)
//		{
//			*(char*)dest = *(char*)(sour);
//			dest = (char*)dest + 1;
//			sour = (char*)sour + 1;
//		}
//	}
//	else
//	{
//		while (count--)
//		{
//			*((char*)dest + count) = *((char*)sour + count);
//		}
//	}
//	return ret;
//}
//
//int main()
//{
//	int arr1[10] = { 1,2,3,4,5,6,7,8,9,10 };
//	my_memmove(arr1 + 2, arr1, 16);
//	int i = 0;
//	int sz = sizeof(arr1) / sizeof(arr1[0]);
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr1[i]);
//	}
//	return 0;
//}

//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[] = { 1,2,3,4,5 };
//	int arr2[] = { 1,2,3,4,0x1122334455 };
//	int ret = memcmp(arr, arr2, 16);
//	printf("%d\n", ret);
//	return 0;
//}

//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[] = { 1,2,3,4,5 };
//	int arr2[] = { 1,2,3,4,0x1122334455 };
//	int ret = memcmp(arr, arr2, 17);
//	printf("%d\n", ret);
//	return 0;
//}

int main()
{
	char arr[] = "hello world" ;
	memset(arr, 6, 5);
	
	return 0;
}