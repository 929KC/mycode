#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<string.h>
//int main() {
//	//返回值代表的是正确匹配的参数个数
//	//例如scanf("%d %d",&a,&b)    若a，b均正确得到值，则返回2
//	//若a得到值，b不得到值，则返回1（返回成功接收到赋值的个数）
//		//如果遇到错误或遇到end of file，返回值为EOF(-1)
//	int iq = 0;
//	while (scanf("%d", &iq) != EOF) {
//		if (iq >= 14) {
//			printf("Genius\n");
//		}
//	}
//	return 0;
//}
//int main() {
//	char arr[] = { 'a','b','c','\0'};
//	printf("%d\n", strlen(arr));
//	return 0;
//}
// 单目操作符
//int main() {
//	//C语言中，0表示假，非0表示真
//	int flag = 5;
//	if (!flag) {
//		printf("hehehehe\n");
//	}
//	return 0;
//}
//int main() {
//	int a = -10;
//	int b = +a;
//	printf("%d\n", b);
//
//	return 0;
//}
//sizeof的使用
//int main() {
//	int a = 10;
//	printf("%d\n", sizeof(a));
//	printf("%d\n", sizeof(int));
//	//计算变量或其类型所占空间的大小
//	return 0;
//}
//int main() {
//	int a = 10;
//	/*int b = a + 1;*/
//	int b = a++;//前置++，先++，后使用//a=a+1;b=a;
//	int b = ++a;//后置+=，先使用，后++//int b=a;a=a+1;
//	int b = --a;*///a=a-1;b=a;
//	int b = a--;//b=a; a=a-1;
//
//	printf("a=%d b=%d\n", a, b);
//	return 0;
//}
//int main() {
//	//法一
//	int a = 3;
//	int b = 5;
//	int m = 0;
//	if (a > b) {
//		m = a;
//	}
//	else {
//		m = b;
//	}
//	printf("%d\n", m);
//	//法二
//	m = a > b ? a : b;
//	printf("%d\n", m);
//	return 0;
//}
//int main() {
//	int a = 3;
//	int b = 20;
//	int c = 0;
//	int d = (a -= 3,b+=a,c=a-b,b=a-4);
//	printf("%d\n",d);
//	return 0;
//}
//int main() {
//	int arr[10] = { 0 };
//	arr[5] = 9;//[]下标引用操作符，它的操作数：数组名，下标。
//
//	return 0;
//}
// 
//int get_max(int x,int y) {
//	return x > y ? x : y;
//}
//int main() {
//	int m = get_max(3, 5); //函数的调用操作符，它的操作数是：函数名，3,5
//	printf("%d", m);
//	return 0;
//}
//void text() {
//static	int a = 5;
// static修饰的局部变量时候，局部变量就变成了静态的局部变量
// 出了局部范围，不会销毁，下一次进入函数依然存在
// 其实是因为：static修饰的局部变量是存储在静态区的
// static修饰局部变量是，实际改变的是变量的存储位置，本来一个局部变量是放在栈区的，被static
// 修饰后放在静态区，从而导致，出了作用域依然存在，生命周期并没有结束
//	a++;
//	printf("%d " , a);
//}
//int main() {
//	int i = 0;
//	while (i < 10) {
//		text();
//		i++;
//	}
//	return 0;
//}