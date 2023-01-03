#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

//int main() {
//	int a = 0, b = 0, c = 0;
//	scanf("%d %d %d ", &a, &b, &c);
//	printf("score1=%d score2=%d score3=%d", a, b, c);
//
//
//	return 0;
//}
int  main() {
    int number = 0;
    scanf("%d",&number);
    if (number >= 1 && number <= 20000000) {
        double score1 = 0, score2 = 0, score3 = 0;
        scanf("%f %f %f", score1,score2,score3);
        printf("The each subject score of No. %d is %.2f %.2f %.2f",number, score1, score2, score3);

    }

    return 0;
}