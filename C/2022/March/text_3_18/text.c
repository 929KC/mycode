#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
void get_left(char arr[],int num)
{
	int len = strlen(arr);
	int j = 0;
	for ( j = 0; j < num%len; j++)
	{
		int i = 0;
		char tmp = arr[0];
		for ( i = 0; i <len-1; i++)
		{
			arr[i] = arr[i + 1];
		}
		arr[len - 1] = tmp;
	}
}

int main()
{
	char arr[20] = {"abcdefg"};
	int num = 0;
	scanf("%d", &num);
	get_left(arr,num);
	printf("%s", arr);
	return 0;
}
//