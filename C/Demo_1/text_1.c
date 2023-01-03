#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//extern int a;
//int main() {
//	printf("%d",a);
//	return 0;
//}
//#define MAX 1000
//int main() {
//	int m = MAX;
//	printf("%d", m);
//	return 0;
//}
#define MAX(x,y)(x>y?x:y)
int main() {
	int a = 90;
	int b = 98;
	int m = MAX(a, b);
	printf("%d", m);
	return 0;
}
