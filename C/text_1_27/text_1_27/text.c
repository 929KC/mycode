#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//struct Stu {
//	char name[20];
//	char num[12];
//	short age;
//	char sex[5];
//
//}s1,s2,s3,s4;//局部变量
//typedef struct Stu {
//	char name[20];
//	char num[12];
//	short age;
//	char sex[5];
//
//}Stu;
//int main()
//{
//		Stu s= { "叶秋涵","18711585787",19,"女" };
//	printf("%s\n", s.name);
//	printf("%s\n", s.num);
//	printf("%d\n", s.age);
//	printf("%s\n", s.sex);
//	return 0;
//}

typedef struct Stu 
{
	char name[20];
	short age;
	char sex[5];
	char num[12];

}Stu;

void print1(Stu s)
{
	printf("%s\n", s.name);
	printf("%s\n", s.num);
	printf("%d\n", s.age);
	printf("%s\n", s.sex);

}
void print2(Stu* ps)
{
	printf("%s\n", ps->name);
	printf("%s\n", ps->num);
	printf("%d\n", ps->age);
	printf("%s\n", ps->sex);
}

int main()
{
	Stu s = { "叶秋涵",19,"女","18711585787" };
	print1(s);
	print2(&s);

	return 0;
}