#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//struct  stu {//struct stu  Ϊ�ṹ������
//	char name[20];
//	int age;
//	double height;
//	char sex[5];
//
//}s1,s2s3;//s1,s2,s3��Ϊȫ�ֱ���
//typedef struct stu {
//	char name[20];
//	int age;
//	double height;
//	char sex[5];
//};
//�ȼ���
//typedef struct stu {
//	char name[20];
//	int age;
//	double height;
//	char sex[5];
//}stu;
//int main() {
//
//
//
//	return 0;
//}
struct point {
	int x;
	int y;

}p = {12,45};

struct ss {
		char name[20];
		int age;
		double height;
		char sex[5];
		struct point sp ;
};
int main()
{
	struct point p = { 1224l,445 };
	struct ss s = { 'w',19,165.0,'Ů',{1,2} };
	

	return 0;
}