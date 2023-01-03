#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
//#include<stdio.h>
//int main() {
//    int number1 = 0;
//    int number2 = 0;
//    while (scanf("%d %d", &number1, &number2) != EOF) {
//        if (number1 == number2) {
//            printf("%d=%d\n", number1, number2);
//        }
//        else if (number1 > number2) {
//            printf("%d>%d\n", number1, number2);
//        }
//        else {
//            printf("%d<%d\n", number1, number2);
//        }
//    }
//    return 0;
//}
//int main() {
//    float a, b, c, sum, average;
//    scanf("%f %f %f", &a, &b, &c);
//    sum = a + b + c;
//    average = sum / 3;
//    printf("%.2f %.2f", sum, average);
//    return 0;
//}
//int main() {
//	法一
//	int number = 0,a,b,i=1;
//	scanf("%d",&number);
//	if (number >= 1000 <= 9000) {
//		while (i<=4) {
//			printf("%d", number % 10);
//			number /= 10;
//			i++;
//		}
//	}
	//法二
	/*int number=0, i = 1;
	scanf("%d", &number);
	for (int n = 1; n <= 4; n++) {
		printf("%d", number % 10);
		number /= 10;
	}
	return 0;*/
//}
//int main(){
//	char arr [] = { 'a','b','c'};
//	printf("%s\n", arr);
//	char arr2[] = { 'a','b','c','\0'};
//	printf("%s", arr2);
//	return 0
//	;
//}
//int main() {
//	printf("c:\code\test.c\n");
//
//	/*printf("%d\n", strlen("c:\test\121"));*/
//	return 0;
//}
//int main()
//{
//	printf("%d\n", strlen("abcdef"));
//	// \62被解析成一个转义字符
//	printf("%d\n", strlen("c:\test\628\test.c"));
//	return 0;
//}
//int main()
//{
//	int coding = 0;
//	printf("你会去敲代码吗？（选择1 or 0）:>");
//	scanf("%d", &coding);
//	if (coding == 1)
//	{
//		prinf("坚持，走上人生巅峰r\n");
//	}
//	else
//	{
//		printf("放弃，工地搬砖！\n");
//	}
//	return 0;
//}
//int main()
//{
//	int n;
//	int sum=0;
//	int i = 1;
//	scanf("%d", &n);
//	
//	 do{
//		sum += i;
//		i++;
//	} while (i <= n);
//	printf("%d\n", sum);
//	return 0;
//}
//int main()
//{
//	int sum=0;
//	int n;
//	scanf("%d", &n);
//	for (int i = 1; i <= n; i++) {
//		sum += i;
//	}
//	printf("%d\n", sum);
//	return 0;
//}
//int Add(int x, int y)
//{
//	return x+y;
//}
//int main()
//{
//	int num1 = 0;
//	int num2 = 0;
//	int sum = 0;
//	printf("输入两个操作数:>");
//	scanf("%d %d", &num1, &num2);
//	sum = Add(num1, num2);
//	printf("sum = %d\n", sum);
//	return 0;
//}