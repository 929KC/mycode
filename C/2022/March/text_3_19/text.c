#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//void reverse(char* left, char* right)
//{
//	while (left < right)
//	{
//		char tmp = *left;
//		*left = *right;
//		*right = tmp;
//		left++;
//		right--;
//	}
//}
//void left_move(char arr[], int k)
//{
//	int len = strlen(arr);
//	k %= len;
//	reverse(arr, arr+k-1);
//	reverse(arr+k, arr + len-1);
//	reverse(arr, arr+len-1);
//}
//int main()
//{
//	
//	char arr[20] = "abcdef";
//	int k = 0;
//	scanf("%d", &k);
//	left_move(arr, k);
//	printf("%s\n", arr);
//	return 0;
//}
//void find_k(int arr[3][3], int row, int col, int k)
//{
//	int x = 0;
//	int y = col - 1;
//	int flag = 1;
//	while (x<row&&y>=0)
//	{
//		if (arr[x][y] < k)
//		{
//			x++;
//		}
//		else if (arr[x][y] > k)
//		{
//			y--;
//		}
//		else {
//			printf("找到了，下标为%d,%d",   x, y);
//			flag = 0;
//			break;
//		}
//		
//	}
//	if (flag)
//	{
//		printf("没有找到！");
//	}
//	
//}
//
//int main()
//{
//	int arr[3][3] = { {1,2,3},{4,5,6},{7,8,9} };
//	printf("请输入您要查找的数：");
//	int k= 0;
//	scanf("%d", &k);
//	find_k(arr, 3, 3, k);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int arr[50] = { 0 };
//	int num = 0;
//	scanf("%d", &num);
//	for (int i = 0; i < num; i++)
//	{
//		scanf("%d", &arr[i]);
//	}
//	int k = 0;
//	scanf("%d", &k);
//	for (int j = 0; j < num; j++)
//	{
//		if (arr[j] != k)
//		{
//			printf("%d ", arr[j]);
//		}
//	}
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int arr[50] = { 0 };
//	int num = 0;
//	scanf("%d", &num);
//	for (int i = 0; i < num; i++)
//	{
//		scanf("%d", &arr[i]);
//	}
//	int k = 0;
//	int i = 0;
//	int j = 0;
//	scanf("%d", &k);
//	for ( i = 0; i < num; i++)
//	{
//			if (arr[i] != k)
//			{
//				arr[j++]=arr[i];
//			}
//	}
//	for (i = 0; i < j; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}

//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	scanf("%d", &num);
//	for (int i = 0; i < num; i++)
//	{
//		for (int j = 0; j < num; j++)
//		{
//			if (i ==j || i + j == num - 1)
//			{
//				printf("*");
//			}
//			else {
//				printf(" ");
//			}
//		}
//		printf("\n");
//	}
//	return 0;
//}


//struct Student
//{
//	int age;
//	char name[20];
//	int score;
//};
//
//void prints2(struct Student* arr, int len)
//{
//	for (int i = 0; i < len; i++)
//	{
//		printf("%s ", (arr + i)->name);
//		printf("%d ", (arr + i)->age);
//		printf("%d ", (arr + i)->score);
//		printf("\n");
//	}
//}
//
//
//void prints(int arr[], int len)
//{
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//
//void Swap(char* buff1, char* buff2, int width)
//{
//	for (int i = 0; i < width; i++)
//	{
//		char tmp = *buff1;
//		*buff1 = *buff2;
//		*buff2 = tmp;
//		buff1++;
//		buff2++;
//	}
//}
//
//int  compare(const void* e1, const void* e2)
//{
//	//return (*(int*)e1 - *(int*)e2);
//	return strcmp(((struct Student*)e1)->name, ((struct Student*)e2)->name);
//}
//
//void bulle_sort(void* base, int num, int width, int (*compare)(const void* e1, const void* e2))
//{
//	for (int i = 0; i < num; i++)
//	{
//		for (int j = 0; j < num - 1 - i; j++)
//		{
//			if (compare((char*)base + j * width, ((char*)base + (j + 1) * width)) > 0)
//			{
//				Swap((char*)base + j * width, (char*)base + (j + 1) * width, width);
//			}
//		}
//	}
//}
//
//void text()
//{
//	struct Student arr[3] = { {19,"叶秋涵",99},{17,"叶子秋",45},{18,"叶知秋",100} };
//	//int arr[] = { 12,45,78,89,56,23,10,20,30,7 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	bulle_sort(arr, len, sizeof(arr[0]), compare);
//	//prints(arr, len);
//	prints2(arr, len);
//}
//
//int main()
//{
//	text();
//	return 0;
//}

struct Student
{
	int age;
	char name[20];
	int score;
};

void prints(struct Student* arr, int len)
{
	for (int i = 0; i < len; i++)
	{
		printf("%s ", (arr + i)->name);
		printf("%d ", (arr + i)->age);
		printf("%d ", (arr + i)->score);
		printf("\n");
	}
}

int  compare(void *e1,void *e2)
{
	return  (strcmp(((struct Student*)e1)->name, ((struct Student*)e2)->name));
}
void text()
{
	struct Student arr[3] = { {19,"叶秋涵",99},{17,"黄子秋",45},{18,"谢知秋",100} };
	int len = sizeof(arr) / sizeof(arr[0]);
	qsort(arr, len, sizeof(arr[0]), compare);
	prints(arr, len);
}
int main()
{
	//int arr[] = { 21,34,56,78,90,12,43,65,87,98 };
	//double arr[] = { 2.10,3.40,5.60,7.80,9.00,1.20,4.30,6.50,8.70,9.80 };
	//char arr[] = { 'a','b','e','w','l','o','y','f' };
	//int len = sizeof(arr) / sizeof(arr[0]);
	text();
	//arr_print(arr,len);
	return 0;
}