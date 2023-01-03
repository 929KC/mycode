#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include < stdio.h >
//struct S
//{
//	int a;
//	int b;
//};
//int main()
//{
//	struct S a, * p = &a;
//	a.a = 99;
//	printf("%d\n", *p.a);
//	return 0;
//}

struct stu
{
    int num;
    char name[10];
    int age;
};


void fun(struct stu* p)
{
    printf("%s\n", (*p).name);
    return;
}


int main()
{
    struct stu students[3] = { {9801,"zhang",20},
                              {9802,"wang",19},
                              {9803,"zhao",18}
    };
    fun(students + 1);
    return 0;
}
