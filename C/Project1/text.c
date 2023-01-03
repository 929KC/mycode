#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	int n = 0;
	int a = 0;
	int b = 0;
	double ch[100];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &a,&b);
		ch[i] = 1.0 * b / a;
		printf("%f\n", ch[i]);
	}
	for (int k = 1; k < n; k++) {
		if (ch[k] - ch[0] > 0.05) {
			printf("better\n");
		}
		else {
			printf("worse\n");
		}
	}
}