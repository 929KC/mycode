#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//��ʵ�δ����βε�ʱ��
//�β���ʵ��ʵ�ε�һ����ʱ����  ���������ݣ��������µ��ڴ�ռ�
//���βε��޸��ǲ���ı�ʵ�ε�

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

//дһ��������ÿ�ε���һ������������ͻὫnum��ֵ����1
//void add(int *p) {
//	(*p)++;//++�����ȼ���ָ���  ��ַ����
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
//дһ�������ж��Ƿ�Ϊ����
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
