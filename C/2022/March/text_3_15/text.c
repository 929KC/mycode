#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int Add(int x,int y)
//{
//	return x + y;
//}
//
//text(int  (*p)(int, int))
//{
//	p(1,2);
//}
//int main()
//{
//
//	int ret=text(Add);
//	printf("%d\n", ret);
//	return 0;
//}
//int compare(const void * e1,const void *e2)
//{
//	return *((int *)e1)- *((int*)e2);//void *强制类型转换成int *
//}
//void prints(int arr[],int len)
//{
//	for (int i = 0; i<len; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//
//int main()
//{
//
//	int arr[] = { 1,0,4,6,8,9,12,67,23 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	qsort(arr, len, 4, compare);
//	prints(arr, len);
//	return 0;
//}
//struct Student
//{
//	int age;
//	char name[20];
//	int score;
//};
//
//void prints(struct Student  *arr,int len)
//{
//	for (int i = 0; i<len; i++)
//	{
//			printf("%s ", (arr + i)->name);
//			printf("%d ", (arr + i)->age);
//			printf("%d ", (arr + i)->score);
//			printf("\n");
//	}
//}
//int compare(const void * e1,const void *e2)
//{
//	return strcmp(((struct Student*)e1)->name, ((struct Student*)e1)->name);
//}
//
//void  text()
//{
//	struct Student arr[3] = { {19,"叶秋涵",99},{17,"叶子秋",45},{18,"叶知秋",100} };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	qsort(arr, len, sizeof(arr[0]), compare);
//	prints(&arr,len);
//}
//
//int main()
//{
//	text();
//	return 0;
//}

//int main()
//{
//    char ch = 'w';
//    char* pc = &ch;
//    *pc = 'a';
//    printf("%s ", pc);
//    return 0;
//}

//int main()
//{
//     const char* pstr = "hello bit.";//这里是把一个字符串放到pstr指针变量里了吗？//常量字符串，存储在常量区，一旦创建好就不能修改
//    *pstr = 'w';
//   /* printf("%c\n", *pstr);
//    printf("%s\n", pstr);*/
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

struct Student
{
	int age;
	char name[20];
	int score;
};

void prints2(struct Student  *arr,int len)
{
	for (int i = 0; i<len; i++)
	{
			printf("%s ", (arr + i)->name);
			printf("%d ", (arr + i)->age);
			printf("%d ", (arr + i)->score);
			printf("\n");
	}
}


void prints(int arr[],int len)
{
	for (int i = 0; i < len; i++)
	{
		printf("%d ", arr[i]);
	}
}

void Swap(char *buff1,char *buff2,int width)
{
	for (int i = 0; i < width; i++)
	{
		char tmp = *buff1;
		*buff1 = *buff2;
		*buff2 = tmp;
		buff1++;
		buff2++;
	}
}

int  compare(const void *e1,const void *e2)
{
	//return (*(int*)e1 - *(int*)e2);
	return strcmp(((struct Student*)e1)->name, ((struct Student*)e2)->name);
}

void bulle_sort(void*base,int num,int width,int (*compare)(const void *e1,const void *e2))
{
	for (int i = 0; i < num; i++)
	{
		for (int j = 0; j < num - 1 - i; j++)
		{
			if (compare((char*)base + j * width, ((char*)base + (j + 1) * width))>0)
			{
				Swap((char*)base + j * width, (char*)base + (j + 1) * width, width);
			}
		}
	}
}

void text()
{
	struct Student arr[3] = { {19,"叶秋涵",99},{17,"叶子秋",45},{18,"叶知秋",100} };
	//int arr[] = { 12,45,78,89,56,23,10,20,30,7 };
	int len = sizeof(arr) / sizeof(arr[0]);
	bulle_sort(arr, len, sizeof(arr[0]), compare);
	//prints(arr, len);
	prints2(arr, len);
}

int main()
{
	text();
	return 0;
}