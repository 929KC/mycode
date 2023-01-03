#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main() {
//	
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	for (int i = 0; i <= 9; i++) {
//		printf("%d\n", arr[i]);
//	}
//	return 0;
//}
//将unsigned int 重命名为uint_32, 所以uint_32也是一个类型名
//typedef unsigned int uint_32;
//int main()
//{
//    //观察num1和num2,这两个变量的类型是一样的
//    unsigned int num1 = 0;
//    uint_32 num2 = 0;
//    printf("%d\n", num1);
//    printf("%d", num2);
//    return 0;
//}
//代码1
//void text() {
//		int k = 0;
//	k++;
//	printf("%d\n", k);
//}
//int main() {
//	for (int i = 0; i < 10; i++) {
//		text();
//	}
//	return 0;
//}
////代码2
//void text() {
//static	int k = 0;
//	k++;
//	printf("%d\n", k);
//}
//int main() {
//	for (int i = 0; i < 10; i++) {
//		text();
//	}
//	return 0;
//}
//int main() {
//	int a = 20;
//	register int a = 10;//建议将10放到寄存器上
//	
//	return 0;
//}