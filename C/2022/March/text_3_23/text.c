#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>

int main()
{
	char arr[] = "3076675259@qq.com";
	char* sep = "@.";

	char* ret = strtok(arr, sep);
	printf("%s\n", ret);

	char* ret2= strtok(NULL, sep);
	printf("%s\n", ret2);

	char* ret3 = strtok(NULL, sep);
	printf("%s\n", ret3);


	char* ret4 = strtok(NULL, sep);
	printf("%s\n", ret4);
	return 0;
}