#define _CRT_SECURE_NO_DEPRECATE
#include<stdio.h>


int main()
{

	int F = 0;
	scanf("%d", &F);
	double C = 5 * ((F - 32)/ 9);
	printf("%.5f", &C);

	return 0;
}