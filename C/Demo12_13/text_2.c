#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//当实参传给形参的时候
//形参其实是实参的一份临时烤贝  拷贝其内容，并开辟新的内存空间
//对形参的修改是不会改变实参的

//void Swapl(int x,int y) {
//	int tem = 0;
//	tem = x;
//	x = y;
//	y = tem;
//	
//}
//void Swap2(int* pa, int* pb) {
//	int tmp= 0;
//	tmp = *pa;
//	*pa = *pb;
//	*pb = tmp;
//}
//int main() {
//	int a = 10, b = 20;
//	printf("a=%d b=%d\n", a, b);
//	/*Swapl(a, b);
//	printf("a=%d b=%d\n", a, b);*/
//	Swap2(&a, &b);
//	printf("a=%d b=%d\n", a, b);
//	return 0;
//}
//

//写一个函数，每次调用一次这个函数，就会将num的值增加1
//void add(int *p) {
//	(*p)++;//++的优先级比指针高  传址调用
//}
//int main() {
//	int num = 0;
//	add(&num);
//	printf("%d\n", num);
//	add(&num);
//	printf("%d\n", num);
//	add(&num);
//	printf("%d\n", num);
//	return 0;
//}
//写一个函数判断是否为闰年
//int is_leap_year(int y) {
//	if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
//		return 1;
//	}
//	else {
//		return 0;
//	}
//}
//
//int main() {
//	
//	for (int year = 1000; year <= 2000; year++) {
//		if (1 == is_leap_year(year)) {
//			printf("%d ", year);
//		}
//
//	}
//	return 0;
//}
