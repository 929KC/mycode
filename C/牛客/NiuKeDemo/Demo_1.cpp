#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

//int main() {
//    int a, b, c;
//    scanf("%d %d %d", &a, &b, &c);
//    int average = (a + b + c) / 3;
//    if (average >= 60) {
//        printf("NO");
//    }
//    else {
//        printf("YES");
//    }
//    return 0;
//}
// 法一
//int main() {
//    int number = 0;
//    scanf("%d", &number);
//    if (number >= 90 && number <= 100) {
//        printf("A");
//    }
//    else if (number >= 80 && number <= 89) {
//        printf("B");
//    }
//    else if (number >= 70 && number <= 79) {
//        printf("C");
//    }
//    else if (number >= 60 && number <= 69) {
//        printf("D");
//    }
//    else if (number >= 0 && number <= 59) {
//        printf("E");
//    }
//    else if (number < 0 || number>100) {
//        printf("F");
//    }
//    return 0;
//}
//法二
//int main()
//{
//    int score = 0;
//    scanf("%d", &score);
//    int c = score / 10;
//    if (score >= 0)
//    {
//        switch (c)
//        {
//        case 9:
//        case 10:
//            printf("A\n");
//            break;
//        case 8:
//            printf("B\n");
//            break;
//        case 7:
//            printf("C\n");
//            break;
//        case 6:
//            printf("D\n");
//            break;
//        case 5:
//        case 4:
//        case 3:
//        case 2:
//        case 1:
//        case 0:
//            printf("E\n");
//            break;
//        default:
//            printf("F\n");
//            break;
//        }
//    }
//    else
//    {
//        printf("F\n");
//    }
//
//    return 0;
//}
//int main() {
//    printf("The size of short is %d bytes.\n", sizeof(short));
//    printf("The size of int is %d bytes.\n", sizeof(int));
//    printf("The size of long is %d bytes.\n", sizeof(long));
//    printf("The size of long long is %d bytes.\n", sizeof(long long));
//	return;
//}
int main() {
    int n = printf("Hello world!\n");
    printf("%d", n);
    return 0;
}