#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main() {
//	printf("\t**\n");
//	printf("\t**\n");
//	printf("   ************\n");
//	printf("   ************\n");
//	printf("\t**\n");
//	printf("\t**\n");
//	return 0;
//}
//int main() {
//		int M;
//		scanf("%d",  &M );
//		if (M >= 1 && M <= 100000) {
//			if (M % 5 == 0) {
//				printf("YES  ");
//			}
//			else {
//				printf("NO  ");
//			}
//			
//		}
//	return 0;
//}
int main() {
	int M;
	scanf("%d", &M);
	if (M > -10000 && M < 10000) {
		if (M > 0) {
			printf("-1");
		}
		else if (M == 0) {
			printf("0");
		}
		else {
			printf("1");
		}
	}
}