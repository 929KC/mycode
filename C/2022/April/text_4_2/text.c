#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
//void test()
//{
//	int a = 10;
//	int* p = &a;
//	free(p);
//}
//void test()
//{
//	int* p = (int*)malloc(100);
//	free(p);
//	free(p);//重复释放
//}
//int main()
//{
//	/*int* ptr = (int*)malloc(40);
//	if (ptr == NULL)
//	{
//		perror("malloc:");
//	}
//	int* ps = (int*)realloc(ptr,80);
//	free(ps);
//	ps = NULL;*/
//
//	test();
//	return 0;  
//}

//void GetMemory(char* p)
//{
//	p = (char*)malloc(100);
//}
//void Test(void)
//{
//	char* str = NULL;
//	GetMemory(str);
//	strcpy(str, "hello world");
//	printf(str);
//}
//
//int main()
//{
//	Test();
//	return 0;
//}


//char* GetMemory(void)
//{
//	char p[] = "hello world";
//	return p;
//}
//void Test(void)
//{
//	char* str = NULL;
//	str = GetMemory();
//	char ps = *(str);
//	printf(str);
//}
//int main()
//{
//	Test();
//	return 0;
//}
//void GetMemory(char** p, int num)
//{
//	*p = (char*)malloc(num);
//}
//void Test(void)
//{
//	char* str = NULL;
//	GetMemory(&str, 100);
//	strcpy(str, "hello");
//	printf(str);
//}
//
//int main()
//{
//
//	Test();
//	return 0;
//}

//void Test(void)
//{
//	char* str = (char*)malloc(100);
//	strcpy(str, "hello");
//	free(str);
//	if (str != NULL)
//	{
//		strcpy(str, "world");
//		printf(str);
//	}
//}
//
//int main()
//{
//	Test();
//
//	return 0;
//}\

//typedef struct st_type
//{
//	int i;
//	int a[0];//柔性数组成员
//}type_a;//结构体变量
//
//int main()
//{
//	int i = 0;
//	type_a* p = (type_a*)malloc(sizeof(type_a) + 100 * sizeof(int));
//	//业务处理
//	p->i = 100;
//	for (i = 0; i < 100; i++)
//	{
//		p->a[i] = i;
//	}
//	free(p);
//
//	return 0;
//}
//typedef struct st_type
//{
//	int i;
//	int* p_a;
//}type_a;
//
//int main()
//{
//
//	type_a* p = (type_a*)malloc(sizeof(type_a));
//	p->i = 100;
//	p->p_a = (int*)malloc(p->i * sizeof(int));
//	
//	for (int i = 0; i < 100; i++)
//	{
//		p->p_a[i] = i;
//	}
//
//	free(p->p_a);
//	p->p_a = NULL;
//	free(p);
//	p = NULL;
//	return 0;
//}

struct S
{
	int i;
	int arr[];
};
int main()
{
	struct S* ps = (struct S*)malloc(sizeof(struct S) + 5 * sizeof(int));
	
	return 0;
}