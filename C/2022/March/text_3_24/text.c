#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int main()
//{
//	char arr[] = "3076675259@qq.com";
//	char* sep = "@.";
//	char  arr2[20] = { 0 };
//	strcpy(arr2, arr);
//	char* ret = strtok(arr2, sep);
//	while (ret != NULL) 
//	{
//		printf("%s\n", ret);
//		ret = strtok(NULL, sep);
//	}
//	return 0;
//#include<stdio.h>
//#include<string.h>
//#include<limits.h>
//#include<errno.h>
//int main()
//{
//	int* p = (int*)malloc(INT_MAX);//Ïò¶ÑÄÚ´æÉêÇë¿Õ¼ä
//	if (p == NULL)
//	{
//		//printf("%s\n", strerror(errno));
//		perror("malloc");
//		return 1;
//	}
//	return 0;
//}
//#include<stdio.h>
//


//struct S3
//{
//	double d;
//	char c;
//	int i;
//};
//
//int main()
//{
//
//	printf()
//	return 0;
//}
#include<stdio.h>
#include<string.h>
#include<assert.h>
//void* my_memcpy(void* dest, void* sour, size_t count)
//{
//	assert(dest && sour);
//	void* ret = dest;
//	while (count--)
//	{
//		*(char*)dest = *(char*)sour;
//		dest = (char*)dest + 1;
//		sour = (char*)sour + 1;
//	}
//	return (char*)ret;
//}
//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int arr2[20] = { 0 };
//	int* ret = (int*)memmove(arr+3 , arr, 20);
//		for (int i = 0; i <=6; i++) {
//		printf("%d ", *(ret + i));
//	}
//
//	return 0;
//}

//int main()
//{
//	int arr[] = { 1,2,3,4,5 };
//	int arr2[] = { 1,2,3,4,0x1122334455 };
//	int ret = memcmp(arr, arr2, 16);
//	printf("%d\n", ret);
//	return 0;
//}

void* my_memmove(void* dest, const void*src, size_t count)
{
	assert(dest && src);
	void* ret = dest;
	if (dest < src)
	{
		while (count--)
		{
			*(char*)dest = *(char*)(src);
			dest = (char*)dest + 1;
			src = (char*)src + 1;
		}
	}
	else
	{
		while (count--)
		{
			*((char*)dest+count) = *((char*)src + count);
		}
	}

	return (int*)ret;

}

int main()
{

	int arr1[10] = { 1,2,3,4,5,6,7,8,9,10 };
	
	int *ret=my_memmove(arr1+2, arr1, 20);
	//my_memmove(arr1, arr1+2, 20);

	int i = 0;
	int sz = sizeof(arr1) / sizeof(arr1[0]);

	for (i = 0; i < sz; i++)
	{
		printf("%d ", arr1[i]);
	}

	return 0;
}