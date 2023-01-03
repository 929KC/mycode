#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
//int main()
//{
//	int sum = 0;
//	int k = 0;
//	int arr[50];
//	printf("请输入一个数：\n");
//	scanf("%d", &sum);
//	for (int i = 0; i < sum; i++)
//	{
//		scanf("%d", &arr[i]);
//	}
//	printf("请输入你要删除的数：\n");
//	scanf("%d", &k);
//	int i = 0;
//	int j = 0;
//	for (i = 0; i < sum; i++)
//	{
//		if (arr[i] != k)
//		{
//			arr[j++] = arr[i];
//		}
//	}
//	printf("删除后：");
//	for (i = 0; i < j; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}

//int main()
//{
//	int sum = 0;
//	printf("请输入一个数：");
//	scanf("%d",&sum);
//	int i = 0;
//	int j = 0;
//	for (i = 0; i < sum; i++)
//	{
//		for ( j = 0; j < sum; j++)
//		{
//			if (i==j||i+j==sum-1) 
//			{
//				printf("*");
//			}
//			else 
//			{
//				printf(" ");
//			}
//		}
//		printf("\n");
//	}
//	return  0;
//}
#include<string.h>

//void left_found(char arr [],int k)
//{
//	int len = strlen(arr);
//	char tmp = arr[0];
//	for (int i = 0; i < k % len; i++)
//	{
//		for (int j= 0; j < len - 1; j++)
//		{
//			arr[j] = arr[j + 1];
//		}
//		arr[len - 1] = tmp;
//	}
//	
//}
void left_found(char *left,char *right)
{
	while (left < right)
	{
		char  tmp = *left;
		*left = *right;
		*right = tmp;
		left++;
		right--;
	}
}

int main()
{

	char arr[20] = "ABCD";
	int len = strlen(arr);
	int k = 0;
	scanf("%d", &k);
	left_found(arr, arr + k - 1);
	left_found(arr+k, arr + len-1);
	left_found(arr, arr+len-1);
	printf("%s", arr);
	return 0;
}