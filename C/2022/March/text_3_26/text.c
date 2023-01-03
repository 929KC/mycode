#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//struct S1
//{
//	char c1;
//	int i;
//	char c2;
//};
//
//int main()
//{
//	printf("%d\n", sizeof(struct S1));
//	return 0;
//
#include<stddef.h>
////计算结构体成员相对于起始位置的偏移量距离
//struct S1
//{
//	char c1;
//	int i;
//	char c2;
//};
//int main()
//{
//
//	struct S1 s;
//	printf("%d\n", sizeof(s));
//	printf("%u\n", offsetof(struct S1, c1));
//	printf("%u\n", offsetof(struct S1, i));
//	printf("%u\n", offsetof(struct S1, c2));
//	return 0;
//}


//
//int main()
//{
//
//	struct S2 s;
//	printf("%d\n", sizeof(s));
//	return 0;
//}


//
//
//int main()
//{
//
//	struct S3 s;
//	printf("%d\n", sizeof(s));
//	return 0;
//}


//struct S2
//{
//	char c1;
//	char c2;
//	int i;
//};
//int main()
//{
//	printf("%u\n",offsetof(struct S2,c1));
//	printf("%u\n", offsetof(struct S2, c2));
//	printf("%u\n", offsetof(struct S2, i));
//	return  0;
////}
//#include<stdio.h>
//#include<stddef.h>
//struct S3
//{
//	double d;
//	char c;
//	int i;
//};
//struct S4
//{
//	char c1;
//	struct S3 s3;
//	double d;
//};
//
//
//
//int main()
//{
//	struct S4 s;
//	printf("%d\n", sizeof(s));
//	printf("%u\n", offsetof(struct S4,c1));
//	printf("%u\n", offsetof(struct S4,s3));
//	printf("%u\n", offsetof(struct S4,d));
//	return 0;
//}

//struct S1
//{
//	char c1;
//	int i;
//	char c2;
//};
//struct S2
//{
//	char c1;
//	char c2;
//	int i;
//};
//
//int main()
//{
//	printf("s1的大小：%d\n", sizeof(struct S1));
//	printf("s2的大小:%d\n", sizeof(struct S2));
//	return 0;
//}

//#include <stdio.h>
//#pragma pack(8)//设置默认对齐数为8
//struct S1
//{
//    char c1;
//    int i;
//    char c2;
//};
//#pragma pack()//取消设置的默认对齐数，还原为默认
//#pragma pack(1)//设置默认对齐数为1
//struct S2
//{
//    char c1;
//    int i;
//    char c2;
//};
//#pragma pack()//取消设置的默认对齐数，还原为默认
//int main()
//{
//
//    printf("%d\n", sizeof(struct S1));
//    printf("%d\n", sizeof(struct S2));
//    return 0;
//}
//struct S
//{
//	char a : 3;
//	char b : 4;
//	char c : 5;
//	char d : 4;
//};
//
//int  main()
//{
//	struct S s = { 0 };
//	s.a = 10;
//	s.b = 12;
//	s.c = 3;
//	s.d = 4;
//	return 0;
//}

//union Un
//{
//	char c;
//	int i;
//};
//
//int main()
//{
//	union Un u;
//	printf("%d\n", sizeof(union Un));
//	printf("%p\n", &u);
//	printf("%p\n", &u.c);
//	printf("%p\n", &u.i);
//	return 0;
//}
//union un
//{
//	char arr[5];//数组的默认对齐数只看其类型，因为是char，所以为1
//	int i;
//};
//int main()
//{
//	printf("%d\n", sizeof(union un));
//
//	return 0;
//}

//int main()
//{
//
//	double i = 10.45;
//	printf("%.5f", i);
//	return 0;
//}